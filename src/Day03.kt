import java.util.stream.Collectors

fun main() {
    fun part1(input: List<String>): Int {
        val gamma: StringBuilder = StringBuilder()
        val epsilon: StringBuilder = StringBuilder()
        for (i in 0 until input[0].length) {
            var numOnes = 0
            var numZeros = 0
            for (j in input.indices) {

                if (input[j][i] == '1') {
                    numOnes++
                } else {
                    numZeros++
                }
            }
            if (numOnes > numZeros) {
                gamma.append('1')
                epsilon.append('0')
            } else {
                gamma.append('0')
                epsilon.append('1')
            }
        }
        return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2)
    }


    fun part2(input: List<String>): Int {
        var oxygenInput = input.stream().collect(Collectors.toList())
        var co2input = input.stream().collect(Collectors.toList())
        var oxygen = ""
        var co2 = ""
        val numLength = input[0].length
        for (i in 0 until numLength) {
            var numOnes = 0
            for (j in oxygenInput.indices) {
                if (oxygenInput[j][i] == '1') {
                    numOnes++
                }
            }
            oxygenInput = if (numOnes >= oxygenInput.size / 2) {
                oxygenInput.filter { it[i] == '1' }
            } else {
                oxygenInput.filter { it[i] == '0' }
            }
            var numZeros = 0
            for (j in co2input.indices) {
                if (co2input[j][i] == '0') {
                    numZeros++
                }
            }
            co2input = if (numZeros > co2input.size / 2) {
                co2input.filter { it[i] == '1'}
            } else {
                co2input.filter { it[i] == '0'}
            }
            if (oxygenInput.size == 1) {
                oxygen = oxygenInput[0]
            }
            if (co2input.size == 1) {
                co2 = co2input[0]
            }
            println(oxygenInput)
            println(co2input)
        }
        println("Oxygen: $oxygen, CO2: $co2")

        return Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2)
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}