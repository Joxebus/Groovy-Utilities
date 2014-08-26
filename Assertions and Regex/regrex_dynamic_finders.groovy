def regexOne = /(findBy)+([a-zA-z]+(Like|Not|And|Or)*)+/
def regexAll = /(findAllBy)+([a-zA-z]+(Like|Not|And|Or)*)+/

def dynamicFinders = ["findByPropiedadA", 
    "findAllByPropiedadALikeAndPropiedadB",
    "findByPropiedadALikeAndPropiedadBOrPropiedadCNotLike",
    "findPropiedadLike"]

def assertDynamic = { expresion ->
    assert expresion ==~ regex
}    

def extractOperations = { expresion ->
    switch(expresion){
        case ~regexOne: (expresion-"findBy").split("And"); break
        case ~regexAll: (expresion-"findAllBy").split("And"); break
        default: expresion; break
    }
}

//dynamicFinders.collect(assertDynamic) 

dynamicFinders.collect(extractOperations)
