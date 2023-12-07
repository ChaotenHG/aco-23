import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/inputs/$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun <T> Array<Array<T>>.printMaxtrix() {
    this.forEach { row ->
        row.forEach { col ->
            print(col.toString())
        }
        println("")
    }
}

fun <T> Array<Array<T>>.getNeighbors(row: Int, col: Int): MutableList<T> {
    val neighbors = mutableListOf<T>()

    // Define the possible directions for neighbors
    val directions = arrayOf(
        -1 to -1, Pair(-1, 0), Pair(-1, 1),
        Pair(0, -1), Pair(0, 1),
        Pair(1, -1), Pair(1, 0), Pair(1, 1))

    for ((dr, dc) in directions) {
        val newRow = row + dr
        val newCol = col + dc

        // Check if the new indices are within bounds
        if (newRow in this.indices && newCol in this[0].indices) {
            neighbors.add(this[newRow][newCol])
        }
    }

    return neighbors
}