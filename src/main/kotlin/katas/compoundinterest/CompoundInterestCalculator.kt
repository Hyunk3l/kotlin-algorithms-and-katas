package katas.compoundinterest

import kotlin.math.pow

class CompoundInterestCalculator {
    fun calculate(parameters: CompoundInterestParameters): Double {
        val power = (parameters.lengthInYears * 12).toDouble()
        val interestRate = parameters.estimatedInterestRate.toDouble()/100.0
        val base = 1 + interestRate/12.0
        val formula = base.pow(power)

        val initial = parameters.initialInvestment * formula
        val monthly = (parameters.monthlyContribution * (formula - 1))/(interestRate/12)

        return initial + monthly
    }
}

data class CompoundInterestParameters(
    val initialInvestment: Int,
    val monthlyContribution: Int,
    val lengthInYears: Int,
    val estimatedInterestRate: Int,
)
