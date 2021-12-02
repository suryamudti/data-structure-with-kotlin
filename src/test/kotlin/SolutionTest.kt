import org.junit.Test

class SolutionTest {

    @Test
    fun `test has pair of sum with 26 input should output true`() {
        val data = listOf(1L, 24, 25, 10, 13)
        assert(data.hasPairOfSum(26))
    }

    @Test
    fun `test sum by 2020 input should output true`() {
        val data = listOf(1000, 1020, 25, 10, 13)
        assert(data.findSumOfBy(2020))
    }
}

