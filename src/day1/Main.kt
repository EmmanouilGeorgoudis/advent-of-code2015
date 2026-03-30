package day1

import java.io.File

//AoC2015 uppgift 1a
fun getFinalFloor(input: String): Int {
    var floor = 0

    for (c in input) {
        if (c == '(') floor++
        else if (c == ')') floor--
    }
    return floor;

}

//AoC2015 uppgift 2b
fun findFirstBasementPosition(input: String): Int {
    var floor = 0

    for ((i, c) in input.withIndex()) {
        when (c) {
            '(' -> floor++
            ')' -> floor--
        }
        if (floor == -1) return i + 1
        }
    return -1
    }




fun main() {

    val data = File("src/day1/AoCdataDay1").readText()

    println(getFinalFloor(data))
    println(findFirstBasementPosition(data))

}