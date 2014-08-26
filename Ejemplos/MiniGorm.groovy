class MiniGorm {
    def db = []
    def methodMissing(String name, Object args) {
        name = name.toLowerCase()-'findby'
        switch(name){
            case {it =~ /notlike+/}:
                db.findAll { !it[name-'notlike'].contains(args[0])  } //#1
                break;
            case {it =~ /like+/}:
                db.findAll { it[name-'like'].contains(args[0])  } //#1
                break;
            
            default:
                db.find { it[name] == args[0]  } //#1
                break;
        }
        
    }
}

def people = new MiniGorm() //#2
def dierk = [first: 'Dierk', last:'Koenig']
def paul = [first: 'Paul', last:'King']
def gavin = [first: 'Gavin', last:'King']
people.db << dierk << paul << gavin

println people.findByFirstNotLike('Gavin')
println people.findByLastLike('King')
println people.findByLastLike('Koenig')