@groovy.transform.EqualsAndHashCode
class Persona{
    String nombre
    Integer edad
    String telefono
}

p1 = new Persona([nombre:'Omar', edad:25, telefono:'123456789'])
p2 = new Persona([nombre:'Omar', edad:25, telefono:'123456789'])

println p1.equals(p2)

println p1.hashCode()==p2.hashCode()