def directorio = new File('ruta/del/espacio/de/trabajo')
def ruta = '/ruta/de/otro/espacio/de/trabajo'
def regex = /(.jsp)$/    // Esta es la extension de los archivos a revisar para hacer el cambio
// MINUSCULAS
String a = 225 as Character
String e = 233 as Character
String i = 237 as Character
String o = 243 as Character
String u = 250 as Character
String n = 241 as Character
// MAYUSCULAS
String A = 193 as Character
String E = 201 as Character
String I = 205 as Character
String O = 211 as Character
String U = 218 as Character
String N = 209 as Character

/*
\u00e1 -> á
\u00e9 -> é
\u00ed -> í
\u00f3 -> ó
\u00fa -> ú
\u00c1 -> Á
\u00c9 -> É
\u00cd -> Í
\u00d3 -> Ó
\u00da -> Ú
\u00f1 -> ñ
\u00d1 -> Ñ
*/

def findAcutes = { linea->    
    if(linea.indexOf(a)!=-1){         
       linea = linea.replace(a, '\\u00e1')
    }
    if(linea.indexOf(e)!=-1){         
       linea = linea.replace(e, '\\u00e9')
    }
    if(linea.indexOf(i)!=-1){         
       linea = linea.replace(i, '\\u00ed')
    }
    if(linea.indexOf(o)!=-1){         
       linea = linea.replace(o, '\\u00f3')
    }
    if(linea.indexOf(u)!=-1){         
       linea = linea.replace(u, '\\u00fa')
    }
    if(linea.indexOf('ñ')!=-1){         
       linea = linea.replace('ñ', '\\u00f1')
    }
    // MAYUSCULAS
    if(linea.indexOf(A)!=-1){         
       linea = linea.replace(A, '\\u00c1')
    }
    if(linea.indexOf(E)!=-1){         
       linea = linea.replace(E, '\\u00c9')
    }
    if(linea.indexOf(I)!=-1){         
       linea = linea.replace(I, '\\u00cd')
    }
    if(linea.indexOf(O)!=-1){         
       linea = linea.replace(O, '\\u00d3')
    }
    if(linea.indexOf(U)!=-1){         
       linea = linea.replace(U, '\\u00da')
    }
    if(linea.indexOf('Ñ')!=-1){         
       linea = linea.replace('Ñ', '\\u00d1')
    }
    linea
}

directorio.eachFileRecurse{ archivo->
    if(archivo.name =~ regex){
        println archivo.name
        def path = archivo.path.replace(ruta, "D:\\Restructura")
        path = path.replace(archivo.name, '')
        new File(path).mkdirs()        
        def propertyFile = new File("$path${archivo.name}")
        def out = propertyFile.newPrintWriter()
        archivo.eachLine{
            out.println findAcutes(it)
        }
        out.close()
    }
}

