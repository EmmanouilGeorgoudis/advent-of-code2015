package day2

import java.io.File
import java.util.*

//AoC2015 uppgift 2a
fun calculateWrappingPapper(input: String): Int {
    var total = 0;

    for (line in input.lines()) {
        val (l, w, h) = line.split("x").map(String::toInt)

        val d1 = l * w
        val d2 = w * h
        val d3 = l * h

        val surfaceNeeded = 2*d1 + 2*d2 + 2*d3 + minOf(d1, d2, d3)
        total += surfaceNeeded
    }
    return total
}


//AoC2015 uppgift 2b
fun calculateRibbon(input: String): Int {
    val scan = Scanner(input)
    var total = 0

    for (line in input.lines()) {
        val allSides = line.split("x").map(String::toInt).sorted()

        val (smallSide, mediumSide, bigSide) = allSides

        val wrapRibbon = 2 * smallSide + 2 * mediumSide
        val bowRibbon = smallSide * mediumSide * bigSide

        total += (bowRibbon + wrapRibbon)
    }
    return total
}




fun main() {

    val data = File("src/day2/AoCdataDay2").readText()

    println(calculateWrappingPapper(data))
    println(calculateRibbon(data))

}