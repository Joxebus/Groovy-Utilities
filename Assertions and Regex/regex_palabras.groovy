def regex = /(P[A-Z]*R|H[A-Z]*O[A-Z]*)/

def verifyWord = { word ->
    word ==~ regex ? 'X'*word.size() : word  
}
 
def resultado = ''

def texto = '''Estimado presidente
Debemos platicar sobre esta situacion su pueblo esta muy hinchado
y no pensamos plantar mas bombas
queremos paz DE UNA VEZ LE DIGO Que haga lo que haga no seremos sus esclavoz'''

resultado = texto.toUpperCase().split(' ').collect{ verifyWord(it) }
println resultado