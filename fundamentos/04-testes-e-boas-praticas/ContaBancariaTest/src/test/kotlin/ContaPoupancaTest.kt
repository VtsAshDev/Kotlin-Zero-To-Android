import org.example.ContaBancaria
import kotlin.test.*
import org.junit.jupiter.api.Test

class ContaBancariaTest {

    private val contaTest: ContaBancaria = ContaBancaria("vitor",50.00)

    @Test
    fun `deve depositar corretamente`() {
        contaTest.depositar(50.00)
        assertEquals(100.00, contaTest.saldo)
    }

    @Test
    fun `deve sacar corretamente`() {
        contaTest.sacar(50.00)
        assertEquals(0.00, contaTest.saldo)
    }

    @Test
    fun `não deve permitir deposito negativo`() {
        assertFailsWith<IllegalArgumentException> {
            contaTest.depositar(-50.00)
        }
    }

    @Test
    fun `não deve permitir saque acima do saldo`() {
        assertFailsWith<IllegalArgumentException> {
            contaTest.sacar(1000.00)
        }
    }

}
