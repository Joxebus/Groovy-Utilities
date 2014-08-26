def camelCase = /[A-Z]{0,1}[a-z]*([A-Z]{1}[a-z]*)*/

assert 'A' ==~ camelCase
assert 'aA' ==~ camelCase

assert 'estaEsUnaVariableEnCamelCase' ==~ camelCase

def lista = []

('estaEsUnaVariableEnCamelCase' =~ /[A-Z]{0,1}[a-z]*/).each{
    lista << it.toUpperCase()
}

print lista[0]
1.upto(lista.size()-2){
    print '_'+lista[it]
}


