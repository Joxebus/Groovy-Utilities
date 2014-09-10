import groovy.json.JsonSlurper
import java.util.ArrayList
import java.util.HashMap

/*
 * Ejemlo lista Conversiones
 * def listaConversiones = []
 * listaConversiones << [from:'USD', to:'EUR']
 * listaConversiones << [from:'USD', to:'MXN']
 * listaConversiones << [from:'MXN', to:'EUR']
 * listaConversiones << [from:'EUR', to:'USD']
*/

public class GoogleExchangeRates{

    /*public static void main(String[] args){
        List listaConversiones = []
         listaConversiones << [from:'USD', to:'EUR']
         listaConversiones << [from:'USD', to:'MXN']
         listaConversiones << [from:'MXN', to:'EUR']
         listaConversiones << [from:'EUR', to:'USD']
         List res = new GoogleExchangeRates().findAllExchangeRatesFromList(listaConversiones)
         println res

    }*/

    public ArrayList<HashMap> findAllExchangeRatesFromList(List listaConversiones){
        ArrayList<HashMap> response = []
        listaConversiones.each{
            response << findRate(it.from, it.to)
        }
        response
    }

    public HashMap findRate (String from, String to){
        Map response = [:]
        response.from = from
        response.to = to
        
        def urlString = 'https://www.google.com/finance/converter?'
        def queryString = "a=1&from=${from}&to=${to}"
          
        def url = new URL(urlString+queryString) 
        def connection = url.openConnection()
        connection.setRequestMethod("POST") 
        connection.doOutput = true
           
        def writer = new OutputStreamWriter(connection.outputStream) 
        //writer.write(queryString) 
        writer.flush() 
        writer.close() 
        connection.connect()
           
            
        def out  = connection.content.text
        out = (out =~  /<span class=bld>(.+)$to/)[0][1]
        //out = out.substring(out.indexOf('<span class=bld>')+'<span class=bld>'.length())
        response.rate = out.trim() 
        response
    }


}


 



   