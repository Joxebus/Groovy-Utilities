def totalClinks = 0
def partyPeople = 1100
1.upto(partyPeople) { guestNumber ->
    clinksWithGuest = guestNumber-1
    totalClinks += clinksWithGuest // #1 modifies outer scope
    println "$guestNumber: Clincks: $totalClinks \tClinks with Guest: $clinksWithGuest"
}
assert totalClinks == (partyPeople * (partyPeople-1)) / 2