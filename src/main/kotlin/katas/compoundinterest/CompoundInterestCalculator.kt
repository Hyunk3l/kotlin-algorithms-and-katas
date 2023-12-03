package katas.compoundinterest

class CompoundInterestCalculator {
    fun calculate(parameters: CompoundInterestParameters) {
        TODO()
    }
}

data class CompoundInterestParameters(
    val initialInvestment: Int,
    val monthlyContribution: Int,
    val lengthInYears: Int,
    val estimatedInterestRate: Int,
)
