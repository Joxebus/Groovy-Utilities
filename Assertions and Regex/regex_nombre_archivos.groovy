def regex = /mi_archivo_[0-9]{9}.txt/

new File('D:/Compartida VM/').eachFileRecurse{ archivo ->
    if(archivo.getName() ==~ regex){
        println archivo.getAbsolutePath()
    }   
}
