fun main() {
    fun part1(input: List<String>): Int {

        val matrix = Array(input.size) { Array(input[0].split("").lastIndex) { '.' } }

        // load matrix
        input.forEachIndexed { row, s ->

            s.split("").forEachIndexed { col, c ->
                if (c.firstOrNull() != null)
                        matrix[row][col] = c.first()
            }
        }

       return matrix.mapIndexed{ row, s ->

            var lineSum = 0
            var current = ""
            var isPartNumber = false

            s.forEachIndexed { col, c ->
                if (c.isDigit()) {
                    current += c

                    if (!isPartNumber){
                        isPartNumber = matrix.getNeighbors(row, col).any { !it.isDigit() && it != '.' }
                    }

                }else {

                    if (isPartNumber) {
                        lineSum += current.toInt()
                        isPartNumber = false
                    }

                    current = ""
                }
            }

            lineSum
        }.sum()
    }

    fun part2(input: List<String>): Int {

         val matrix = Array(input.size) { Array(input[0].split("").lastIndex) { '.' } }

        // load matrix
        input.forEachIndexed { row, s ->

            s.split("").forEachIndexed { col, c ->
                if (c.firstOrNull() != null)
                        matrix[row][col] = c.first()
            }
        }

        matrix.forEachIndexed { row, s ->

            var isGearRatio = false
            var current = ""

            s.forEachIndexed { col, c ->

                if (c == '*') {

                }
            }
        }


        return input.size
   }


    val testInput = readInput("Day03_test")
    check(part1(testInput) == 4361)

    val input = readInput("Day03")
    println("Part 1: ${part1(input)}")

    check(part2(testInput) == 467835)
    println("Part 2: ${part2(input)}")
}
