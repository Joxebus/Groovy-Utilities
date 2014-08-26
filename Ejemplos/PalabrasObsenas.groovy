Long inicio = System.currentTimeMillis()
def regex = /P[A-Z]*R|H[A-Z]*O+\D*/

def verifyWord = { word ->
    word ==~ regex ? 'X'*word.size()+' ' : word+' '
}

String texto = '''Estimado presidente
Debemos platicar sobre esta situacion su pueblo esta muy hinchado
y no pensamos plantar mas bombas
queremos paz DE UNA VEZ LE DIGO Que haga lo que haga no seremos sus esclavoz'''

def resultado = ''

texto.toUpperCase().replaceAll('\rn',' ').split(' ').each{ resultado += verifyWord(it) }
println resultado
println 'Tiempo de ejecucion '+((System.currentTimeMillis()-inicio)/1000)+'s'