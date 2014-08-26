class Persona {
    String nombre
    Integer edad 
    
    String toString(){ "$nombre $edad"}
}

def lista = [1,2,2,6,4,8,8,6,1,3]

def cuadrado = { it*it }

println lista.sort()
println lista.unique()
println lista.collect(cuadrado)


def listaPersonas = []
listaPersonas << new Persona([nombre:'Omar', edad:25])
listaPersonas << new Persona([nombre:'Diego', edad:24])
listaPersonas << new Persona([nombre:'Saul', edad:15])
listaPersonas << new Persona([nombre:'Maria', edad:23])

println listaPersonas.sort{ it.nombre }
println listaPersonas.sort{ it.edad }
println listaPersonas.sort{ it.edad }.reverse()

def cantidadLetras = { it?.nombre?.size() }

println listaPersonas*.nombre
println listaPersonas*.edad
println listaPersonas.collect(cantidadLetras)

listaPersonas.metaClass.toTable = {->
    delegate.each{[nombre, edad]}
}

println listaPersonas.toTable()