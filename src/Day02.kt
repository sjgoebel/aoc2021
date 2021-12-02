fun main() {
    fun part1(input: List<String>): Int {
        val directionList = input.map { it.split(" ")[0] }
        val distanceList = input.map {Integer.parseInt(it.split(" ")[1])}

        var horiz = 0
        var depth = 0

        for (index in directionList.indices) {
            if (directionList[index] == "forward") {
                horiz += distanceList[index]
            } else if (directionList[index] == "down") {
                depth += distanceList[index]
            } else if (directionList[index] == "up") {
                depth -= distanceList[index]
            }
        }
        return depth * horiz
    }


    fun part2(input: List<String>): Int {
        val directionList = input.map { it.split(" ")[0] }
        val distanceList = input.map {Integer.parseInt(it.split(" ")[1])}

        var horiz = 0
        var depth = 0
        var aim = 0

        for (index in directionList.indices) {
            if (directionList[index] == "forward") {
                horiz += distanceList[index]
                depth += aim * distanceList[index]
            } else if (directionList[index] == "down") {
                aim += distanceList[index]
            } else if (directionList[index] == "up") {
                aim -= distanceList[index]
            }
        }
        return depth * horiz
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}