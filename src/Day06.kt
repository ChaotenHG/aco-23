fun main() {

     fun calculateDistance(maxtime : Long, holdTime : Long): Long {
        return (maxtime - holdTime) * holdTime
    }

    fun part1(input: List<String>): Int {

        val time = input[0].split(":")[1].trim().split(" ").filter { it.isNotEmpty() }.map { n -> n.toInt() }
        val recordDistance = input[1].split(":")[1].trim().split(" ").filter { it.isNotEmpty() }.map { n -> n.toInt() }


        return time.zip(recordDistance).map {

            var wins = 0

            for (i in 1..it.first) {
                val distance = calculateDistance(it.first.toLong(), i.toLong())

                if (distance > it.second) {
                    wins++
                }
            }

            wins
        }.reduce(Int::times)

    }

    fun part2(input: List<String>): Long {

        val time = input[0].split(":")[1].filter {c : Char -> c.isDigit() }.toLong()
        val recordDistance = input[1].split(":")[1].filter {c : Char -> c.isDigit() }.toLong()

        var wins = 0L

        // inprove using binary search
        for (i in 1..time) {
            val distance = calculateDistance(time, i)

            if (distance > recordDistance) {
                wins++
            }
        }

        return wins
   }


    val testInput = readInput("Day06_test")
    check(part1(testInput) == 288)

    val input = readInput("Day06")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 71503L)
    println("Part 2: ${part2(input)}")
}
