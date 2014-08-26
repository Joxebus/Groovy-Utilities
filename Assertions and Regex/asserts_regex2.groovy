def regex = /([1-5a-dA-C]{3}-){2}[3-6]{2}\*[0-9]{3}/

try{
    assert '123-abc-45*687' ==~ regex
    assert 'BC3-251-45*687' ==~ regex
    assert 'dA1-c4a-45687' ==~ regex
}catch(Exception af){
    println af.getClass().name
    println af.getMessage()
}