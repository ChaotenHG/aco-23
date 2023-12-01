fun main() {
    fun part1(input: List<String>): Int {

        return input.map { it.filter { c -> c.isDigit() } }
            .map { "${it.first()}${it.last()}" }
            .sumOf { it.toInt() }
    }

    fun wordToNumber(word: String): String {
           val wordMap = mapOf(
            "nine" to "9",
            "eight" to "8",
            "seven" to "7",
            "six" to "6",
            "five" to "5",
            "four" to "4",
            "three" to "3",
            "two" to "2",
            "one" to "1",
            "zero" to "0",
        )


        val first = word.findAnyOf(wordMap.keys)
        val last = word.findLastAnyOf(wordMap.keys)

        var newWord = word

        if (last != null)
            newWord = newWord.replaceRange(last.first + last.second.length
                , last.first + last.second.length, wordMap[last.second]!!)


        if (first != null)
            newWord = newWord.replaceFirst(first.second, wordMap[first.second]!!)

        return newWord
    }

    fun part2(input: List<String>): Int {

        return input.map { wordToNumber(it) }
            .map { it.filter { c -> c.isDigit() } }
            .map { "${it.first()}${it.last()}" }
            .sumOf { it.toInt() }
    }


    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    val testInput2 = readInput("Day01_test2")
    println("Part 1: ${part1(input)}")

    check(part2(testInput2) == 281)
    println("Part 2: ${part2(input)}")
}
