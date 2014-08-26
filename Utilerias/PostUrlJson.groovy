import groovy.json.JsonSlurper

def urlString = "http://localhost:8080/ExampleApp/persona/edit"  

def url = new URL(urlString)
def connection = url.openConnection()
connection.setRequestMethod("POST")
connection.doOutput = true

def writer = new OutputStreamWriter(connection.outputStream)
writer.write(queryString(params))
writer.flush()
writer.close()
connection.connect()

def response = connection.content.text
// Este es el objeto JSON
def json = jsonSlurper.parseText(response)
