Map map = ['a':1, 'b':2]
map.each{ key, value -> map[key] = value * 2 } //#1 Parameter sequence with commas
println map
def doubler = {key, value -> map[key] = value * 2 } //#2 Assign and then call
def quad = { item -> item*item }
map.collect(doubler) //#2 a closure reference
println map

def list = map.values().toList()
list = list.collect(quad)
println list