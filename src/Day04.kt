fun main() {
    fun part1(input: List<String>): Int {

        return input.asSequence().map { it.split(":")[1] }
            .map { it.split("|") }
            .map {
                Pair(it[0].trim().split(" ").filter { n -> n.isNotEmpty() }.map { n -> n.toInt() },
                    it[1].trim().split(" ").filter { n -> n.isNotEmpty() }.map { n -> n.toInt() })
            }.map { it.second.filter { f -> it.first.contains(f) }.size }
            .sumOf { it ->
                var points = 1

                repeat(it) {
                    points *= 2
                }

                return@sumOf points / 2
            }
    }

    fun part2(input: List<String>): Int {

        val map = input.map {
            val split = it.split(":")
            val left = split[1].split("|")[0].trim().split(" ").filter { n -> n.isNotEmpty() }.map { n -> n.toInt() }
            val right = split[1].split("|")[1].trim().split(" ").filter { n -> n.isNotEmpty() }.map { n -> n.toInt() }
            Pair(split[0].filter { c: Char ->  c.isDigit()}.toInt(), Pair(left, right))
        }.map {
            Pair(it.first, it.second.first.filter { f -> it.second.second.contains(f) }.size)
        }


        fun recursive(card : Int, current : Int): Int {

            if (map[card].second == 0) {
                return current
            }

            for (i in 0 until map[card].second) {
                return recursive(map[card].first, current + 1)
            }

            return current
        }

        val value = map.sumOf {
            recursive(it.first, 0)
        }


        return value
   }


    val testInput = readInput("Day04_test")
    check(part1(testInput) == 13)

    val input = readInput("Day04")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 30)
    println("Part 2: ${part2(input)}")
}
