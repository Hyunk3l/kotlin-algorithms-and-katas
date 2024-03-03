package katas.weather

class WeatherAnalyzer {
    private val temperatures: MutableList<Double> = mutableListOf()

    fun addTemperature(temperature: Double) {
        temperatures.add(temperature)
    }

    fun getAverageTemperature(): Double {
        return temperatures.average()
    }

    fun getMaxTemperature(): Double {
        return temperatures.maxOrNull() ?: Double.MIN_VALUE
    }

    fun getMinTemperature(): Double {
        return temperatures.minOrNull() ?: Double.MAX_VALUE
    }

    fun getTemperatureSpread(): Double {
        return getMaxTemperature() - getMinTemperature()
    }

    fun printReport() {
        println("Average Temperature: ${getAverageTemperature()}")
        println("Max Temperature: ${getMaxTemperature()}")
        println("Min Temperature: ${getMinTemperature()}")
        println("Temperature Spread: ${getTemperatureSpread()}")
    }
}
