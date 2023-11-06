package principles.lawofdemeter

data class Car(private val name: String, private val engine: Engine) {
    fun power(): String = "Car $name has ${engine.power()}"
}

data class Engine(private val cc: CylinderCapacity, private val powerSources: List<PowerSource>) {
    fun power(): String = "${powerSources.sumOf { it.power() }}hp"
}

data class CylinderCapacity(private val value: Int)

data class ElectricPowerSource(private val value: Int) : PowerSource {
    override fun power() = value
}

data class FuelPowerSource(private val value: Int) : PowerSource {
    override fun power() = value
}

interface PowerSource {
    fun power(): Int
}

fun main() {
    val powerSources = listOf(
        ElectricPowerSource(300),
        FuelPowerSource(200),
    )
    val car = Car(name = "Polo", engine = Engine(cc = CylinderCapacity(value = 2000), powerSources = powerSources))

    println(car.power())
}
