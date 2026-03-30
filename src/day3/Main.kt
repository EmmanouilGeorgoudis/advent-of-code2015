package day3

import java.io.File

/*
Reflektion: En intressant strukturell skillnad mellan Java och Kotlin i denna lösning är hur hjälpfunktioner organiseras.
I Java definieras metoder separat på klassnivå, vilket ger en mer traditionell top-down-struktur.

I Kotlin kan funktioner istället definieras lokalt inom en global funktion, vilket är mer inkapslat. Detta gav mig ett
“bottom-up" intryck eftersom de interna funktioner börjar anropa varandra från return:et längst ner i globala funktionen.
 */

fun countUniqueVisits(input: String, amountOfWorkers: Int): Int {

    fun getWorkerVisits(startIndex: Int): List<String> {

        val coordinates = mutableListOf<String>()
        var x = 0
        var y = 0

        coordinates.add("0,0")

        var i = startIndex

        while (i < input.length) {
            when (input[i]) {
                '>' -> x++
                '<' -> x--
                '^' -> y++
                'v' -> y--
            }
            coordinates.add("$x,$y")

            i += amountOfWorkers
        }
        return coordinates
    }

    fun collectWorkerVisits(): List<String> {

        val allVisits = mutableListOf<String>()

        var i = 0
        while (i < amountOfWorkers) {

            val visits = getWorkerVisits(i)
            allVisits.addAll(visits)

            i++
        }

        return allVisits
    }
    return collectWorkerVisits().toSet().size
}




fun main() {

    val data = File("src/day3/AoCdataDay3").readText()

    //AoCDay3a
    println(countUniqueVisits(data, 1))
    //AoCDay3b
    println(countUniqueVisits(data, 2))

}