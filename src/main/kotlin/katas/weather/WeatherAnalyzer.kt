package katas.weather

class WeatherAnalyzer {
    private val temperatures: MutableList<Double> = mutableListOf()

    fun addTemperature(temperature: Double): WeatherAnalyzer {
        temperatures.add(temperature)
        return this
    }

    private fun average() = temperatures.average()

    private fun max() = temperatures.maxOrNull() ?: Double.MIN_VALUE

    private fun min() = temperatures.minOrNull() ?: Double.MAX_VALUE

    private fun spread() = max() - min()

    fun printReport() {
        println("Average Temperature: ${average()}")
        println("Max Temperature: ${max()}")
        println("Min Temperature: ${min()}")
        println("Temperature Spread: ${spread()}")
    }
}
