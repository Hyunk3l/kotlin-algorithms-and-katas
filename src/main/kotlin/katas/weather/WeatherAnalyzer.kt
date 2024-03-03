package katas.weather

class WeatherAnalyzer {
    private val temperatures: MutableList<Double> = mutableListOf()

    fun addTemperature(temperature: Double) {
        temperatures.add(temperature)
    }

    fun getAverageTemperature(): Double {
        var sum = 0.0
        for (temperature in temperatures) {
            sum += temperature
        }
        return sum / temperatures.size
    }

    fun getMaxTemperature(): Double {
        var max = Double.MIN_VALUE
        for (temperature in temperatures) {
            if (temperature > max) {
                max = temperature
            }
        }
        return max
    }

    fun getMinTemperature(): Double {
        var min = Double.MAX_VALUE
        for (temperature in temperatures) {
            if (temperature < min) {
                min = temperature
            }
        }
        return min
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
