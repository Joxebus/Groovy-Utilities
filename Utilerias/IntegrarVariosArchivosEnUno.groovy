def directorio = new File('D:/Documentos')
def salida = new File('D:/fuentes.groovy')
def out = salida.newPrintWriter()
def regex = /\w+\.groovy$/

// Verificacion de expresion regular
assert 'miarchivo.groovy' ==~ regex

def escribirCodigo = { fuente ->
    out.println("//--- Fuente ${fuente.getPath()} ---".center(50))
    fuente.eachLine{ linea->
        out.println(linea)
    }    
    out.println("//----------------------------------".center(50))   
}

directorio.eachFileRecurse{ archivo ->    
    if(archivo.getName() ==~ regex){
        escribirCodigo(archivo)
    }
}

out.close()