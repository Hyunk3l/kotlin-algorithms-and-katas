package katas.compoundinterest

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CompoundInterestCalculatorTest {
    @Test
    fun `should calculate compound interest result after 30 years`() {
        val calculator = CompoundInterestCalculator()
        val parameters = CompoundInterestParameters(
            initialInvestment = 10000,
            monthlyContribution = 500,
            lengthInYears = 30,
            estimatedInterestRate = 10,
        )

        val result = calculator.calculate(parameters = parameters)

        result shouldBe 1161458.16
    }
}
