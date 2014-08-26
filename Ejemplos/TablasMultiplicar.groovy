def archivo = new File('D:/salida.log')
def codigo  = new File('D:/Documentos/Groovy/TablasMultiplicar.groovy')
def out = archivo.newPrintWriter()

def tablaMultiplicar = { multiplicando ->
    1.upto(10){ multiplicador ->
        out.println("$multiplicando x $multiplicador = ${multiplicando*multiplicador}".center(30))
    }    
}

1.step(13,1){ numero->
    out.println("--- Tabla del $numero ---".center(30))
    tablaMultiplicar(numero)
    out.println("-------------------------".center(30))
}

out.println(''' '

Codigo que genera las tablas:
''')

codigo.eachLine{ linea ->
    out.println linea
}

out.close()