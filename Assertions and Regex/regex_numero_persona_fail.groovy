class Persona{
    String nombre
    String telefono
    void setTelefono(String numeroTelefono){
        if(numeroTelefono ==~ /(\d{3})-(\d{3})-(\d{4})/){
            telefono = numeroTelefono
        }else{
            throw new Exception("$numeroTelefono tiene un formato invaliddo ###-###-####")
        }
    }
    
    String toString(){ nombre +' con numero '+ telefono}
}

def numerosTelefonicos = ["442-123-4567","442-1234568","442-123-4569","442-123-4560"]
def nombrePersona = ['Jorge','Omar','Amaia','Lupita']

0.upto(nombrePersona.size()-1){ pos ->
    Persona persona = new Persona()
    persona.setNombre(nombrePersona.get(pos))    
    persona.setTelefono(numerosTelefonicos.get(pos))
    println 'Registro exitoso de '+persona
}