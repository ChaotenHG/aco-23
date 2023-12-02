fun main() {

    fun parseValues(input: List<String>): List<Pair<Int, Triple<Int, Int, Int>>> =
        input.map { line ->

            val id = line.split(":")[0].split(" ")[1].toInt()
            val values = line.split(":")[1].split(";")
                .map { it.split(",") }
                .map { value ->
                    // there can be multiple values for each color, so we need to add them up
                    val redValues = (value.filter { it.contains("red") }
                            .map { cd -> cd.filter { c: Char -> c.isDigit() } })
                    val red = if (redValues.isEmpty()) 0 else redValues.sumOf { it.toInt() }

                    val greenValues = (value.filter { it.contains("green") }
                            .map { cd -> cd.filter { c: Char -> c.isDigit() } })
                    val green = if (greenValues.isEmpty()) 0 else greenValues.sumOf { it.toInt() }

                    val blueValues = (value.filter { it.contains("blue") }
                            .map { cd -> cd.filter { c: Char -> c.isDigit() } })
                    val blue = if (blueValues.isEmpty()) 0 else blueValues.sumOf { it.toInt() }


                    Triple(red, green, blue)
                }

            Pair(id, Triple(
                values.maxBy { it.first }.first, // red
                values.maxBy { it.second }.second, // green
                values.maxBy { it.third }.third)) // blue


        }


    fun part1(input: List<String>)
        = parseValues(input).filter { it.second.first <= 12 && it.second.second <= 13 && it.second.third <= 14 }.sumOf { it.first }


    fun part2(input: List<String>)
        = parseValues(input).map { it.second }.sumOf { it.first * it.second * it.third }


    val testInput = readInput("Day02_test")
    check(part1(testInput) == 8)

    val input = readInput("Day02")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 2286)
    println("Part 2: ${part2(input)}")
}
