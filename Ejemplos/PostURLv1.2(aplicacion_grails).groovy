/**
* 
* Esta clase sirve para probar los WS expuestos por los controllers de GRAILS
* se hace una llamada POST con los parametros a consultar del lado del servidor
* recibe una respuesta en formato JSON.
*
* @author: Jorge Omar Bautista Valenzuela
* Date: 12/05/2013
* Time: 19:30 hrs
* @email: jbautista@sintelti.com.mx
*/

import groovy.json.JsonSlurper

/**
* Clase utilitaria para probar la respuesta en JSON
*/ 
class Persona {
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    Integer edad    
    
    String toString(){ "$nombre $apellidoPaterno $apellidoMaterno" }       
}

def archivo = new File('D:/grails_ws.log')
def logger = archivo.newPrintWriter()

/**
* Genera el query del encabezado
*/
def queryString = { params ->
    def query = ''
    params.collect{key, value->
    "$key=$value&"
        }.each{ parametro ->
        query += parametro
    }    
    query
}

/**
* Convertidor de la respuesta JSON
*/
def jsonSlurper = new JsonSlurper()

/**
* Parametros para la consulta
*/
//def params = [nombre:'Emmanuel',apellidoPaterno:'Ventura',apellidoMaterno:'Santamaria',edad:24] //save
def params = [id:1, user:'joxebus'] //show

/**
* URL a la cual se hace la llamada POST
* para este caso puede cambiar show por los siguientes valores
* save | delete | list etc. los diferentes closures que están expuestos.
*
* La lista de argumentos cambia segun lo que se quiera hacer.
*/
def urlString = "http://localhost:8080/ExampleApp/persona/edit" 
//def urlString = "http://localhost:8080/ExampleApp/login/authenticate" 
//def urlString = "http://localhost:8080/ExampleApp/login/logout" 

def url = new URL(urlString)
def connection = url.openConnection()
connection.setRequestMethod("POST")
connection.doOutput = true

def writer = new OutputStreamWriter(connection.outputStream)
writer.write(queryString(params))
writer.flush()
writer.close()
connection.connect()

def response = connection.content.text
def json = jsonSlurper.parseText(response)


/*
* Ver la respuesta del controller.
*/
logger.println "Respuesta:   $response"
if(json.errors){
    println json.message
    json.errors.errors.each{ error ->
        logger.println '\t'+error.message
        logger.println '\tCampo del error:'+ error.field
        logger.println '\tValor erroneo:'+error['rejected-value']
    }
}else if(json.message){
    logger.println json.message
}else if(json.personaInstance){
    ['id', 'class'].each{ invalid ->
        json.personaInstance.remove(invalid)
    }
    logger.println 'Objeto JSON:            ' + json
    logger.println 'Objeto Persona JSON:    ' + json.personaInstance
    logger.println 'Objeto Persona PostURL: '+new Persona(json.personaInstance)
}else {
    logger.println 'Objeto JSON:                  ' + json
    json.personaInstanceList.sort{ it.id }
    logger.println '----------- Lista de personas -----------'.center(50)
    json.personaInstanceList.each{ personaInstance ->
        def id = personaInstance.id
        ['id', 'class'].each{ invalid ->
            personaInstance.remove(invalid) 
        }
        logger.println "Objeto Persona id $id PostURL: "+new Persona(personaInstance)
    }
    logger.println '-----------------------------------------'.center(50)
    logger.println 'Objeto lista Persona JSON:    ' + json.personaInstanceList
    logger.println 'Total objetos Persona JSON:   ' + json.personaInstanceTotal
}

logger.close()
