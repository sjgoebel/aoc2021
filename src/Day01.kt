fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        val numList = input.map { Integer.parseInt(it) }

        var index = 0

        while (index < numList.size - 1) {
            if (numList[index + 1] > numList[index]) {
                result++
            }
            index++
        }
        return result
    }


    fun part2(input: List<String>): Int {
        var result = 0
        val numList = input.map { Integer.parseInt(it) }

        var index = 0
        while (index < numList.size - 4) {
            if (numList[index] + numList[index + 1] + numList[index + 2] < numList[index + 1] + numList[index + 2] + numList[index + 3]) {
                result++
            }
            index++
        }


        return result
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
