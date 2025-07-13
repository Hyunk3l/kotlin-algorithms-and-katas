package katas.addtwonumbers

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {
   @Test
   fun `add two numbers`() {

      val result = AddTwoNumbers().addTwoNumbers(listOf(2),listOf(3))

      assertEquals(listOf(5), result)
   }

   @Test
   fun `add multiple numbers`() {
      val first = listOf(2,4,3)
      val second = listOf(5,6,4)

      val result = AddTwoNumbers()
         .addTwoNumbers(first, second)

      assertEquals(listOf(7, 0, 8), result)
   }

   @Test
   fun `add multiple numbers with different sizes`() {
      val first = listOf(9,9,9,9,9,9,9)
      val second = listOf(9,9,9,9)

      val result = AddTwoNumbers()
         .addTwoNumbers(first, second)

      assertEquals(listOf(8,9,9,9,0,0,0,1), result)
   }
}
