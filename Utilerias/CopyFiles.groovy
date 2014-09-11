String originalPath = "C:\\Users\\jobv\\Documents\\workspace-lacertus\\"
String newPath = "C:\\Users\\jobv\\Documents\\H2H_MODIFICACIONES\\"
def resource = new File("C:\\Users\\jobv\\Documents\\Rutas_relativas_archivos.txt")
/*
-- Ejemplo Contenido del archivo Rutas_relativas_archivos.txt
\Documents\archivo1.txt
\Documents\subcarpeta\archivo2.txt
\Documents\otro_archivo.txt
*/
AntBuilder ab = new AntBuilder()
println "Begin..."
resource.eachLine{ line ->
    String path = newPath+line.substring(0, line.lastIndexOf('\\'))
    def dir = new File(originalPath+path)
    if( !dir.exists() ){
        //Create directories
        dir.mkdirs()
    }
    
    ab.copy(file:originalPath+line, tofile:newPath+line)
}
println "... finish"