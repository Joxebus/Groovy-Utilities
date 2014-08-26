class Persona{
    String nombre
    Integer edad
    
    String toString(){
        "Mi nombre es $nombre y tengo $edad años"
    }
}

def texto = 'Groovy'
def variable = 15 //new Persona([nombre:'Omar', edad:25]) //15.2 //'Cadena normal' //"Cadena de $texto"

switch(variable){
    case BigDecimal: println "Tipo double";  break;
    case Integer: println "Tipo int";  break;
    case String: println "Tipo string";  break;
    case GString: println "Tipo string de groovy";  break;
    case Persona: println variable; break;
    default: println "Tipo ${variable.getClass().name}"; break;
}


