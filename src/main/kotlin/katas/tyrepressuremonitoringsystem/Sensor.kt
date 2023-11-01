package katas.tyrepressuremonitoringsystem

interface Sensor<T> {
    fun popNextValue(): T
}
