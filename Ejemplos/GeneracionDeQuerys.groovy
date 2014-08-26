def archivo = new File("D:\\resultado.txt")
def archivoGuardado = archivo.newPrintWriter()
def mapa = ''
/*
def properties = new Properties()
new File("D:\\cfg.properties").withInputStream{ stream ->
    properties.load(stream)
}
*/
def valores = []
def nombresVariables = []
def descripciones = []
new File("D:\\llaves2.txt").eachLine{
    if(it.contains('public static final String ')){
        valores << it.substring(it.indexOf('=')).replace('= \"','').replace('\";','') 
        nombresVariables << it.substring(0, it.indexOf('=')).replace('public static final String ','').trim()
    }else if(it.contains("/**")){
        descripciones << it.replace('/** ','').replace('*/','')
    }
}

def consulta = "INSERT INTO TABLA (ID, NMBR, VALOR, DESRIPCION, BANDERA) VALUES (#ID_PARAM, '#NMBR_PARAM', ' ', '#DESCRIPCION', '1')"
int indice = 62
valores.size().times{
    //println consulta.replace('#ID_PARAM', indice.toString()).replace('#NMBR_PARAM',valores[it]).replace('#DESCRIPCION', descripciones[it])
    archivoGuardado.println consulta.replace('#ID_PARAM', indice.toString()).replace('#NMBR_PARAM',valores[it]).replace('#DESCRIPCION', descripciones[it].trim())
    indice++
}

archivoGuardado.println """
>>> Mapa de variables
paramDAO.buscarParametros(temporal, new String[]{"""
nombresVariables.each{ variable ->
    archivoGuardado.println "\t $variable,"
}
archivoGuardado.println '});'
archivoGuardado.close()
