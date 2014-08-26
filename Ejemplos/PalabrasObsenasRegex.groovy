Long inicio = System.currentTimeMillis()

def texto = '''Estimado presidente
Debemos platicar sobre esta situacion su pueblo esta muy hinchado
y no pensamos plantar mas bombas
queremos paz DE UNA VEZ LE DIGO Que haga lo que haga no seremos sus esclavoz
'''

// Expresion regular para identificar palabras.
def regex = /(^P[A-Z]*R$)|(^H[A-Z]*O[A-Z]*)/

// Closure para validar palabras coincidentes.
def censurar = { palabra ->
    (palabra =~ regex) ? 'X'*palabra.size()+' ' : palabra+' '
}

texto.toUpperCase().eachLine{ linea ->
    linea.split(' ').each{ palabra-> print censurar(palabra) }
    println ''
}

println 'Tiempo de ejecucion '+((System.currentTimeMillis()-inicio)/1000)+'s'