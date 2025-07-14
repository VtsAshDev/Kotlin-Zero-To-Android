package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate

enum class Metodo{
    SAQUE,
    DEPOSITO,
}

data class Transacao(var value:Double, var metodo: Metodo, var data: LocalDate)

open class ContaBancaria(
    protected var titular: String,
    var saldo: Double,
    protected var transacoes: MutableList<Transacao> = mutableListOf()
){

    fun depositar(value:Double) {
        println("Titular: $titular Está efetuando um Deposito:")
        if (value <= 0) throw IllegalArgumentException("Digite um valor válido para deposito")
        this.saldo += value
        this.transacoes.add(Transacao(value,Metodo.DEPOSITO,LocalDate.now()))

        println("Deposito no valor de R$ $value efetuado com sucesso saldo atual : ${this.saldo}\n")
    }

    open fun sacar(value:Double) {
        if (value > this.saldo) throw IllegalArgumentException("Saldo Insuficiente para saque")
        this.saldo -= value
        this.transacoes.add(Transacao(value,Metodo.SAQUE,LocalDate.now()))
        println("Titular: $titular Está efetuando um Saque:")
        println("Saque no valor de R$ $value efetuado com sucesso saldo atual : ${this.saldo}\n")
    }

    fun exibirSaldo() {
        println("Saldo Atual do Titular ${this.titular}: R$ ${this.saldo}")
    }

}

class ContaPoupanca(titular: String, saldo:Double) : ContaBancaria(titular, saldo) {

    override fun sacar(value:Double) {
        println("Titular: $titular  Está efetuando um Saque da conta Poupança:")

        val limite = 3 ;

        if (value > this.saldo){
            println("Saldo insuficiente para o saque")
            return
        }

        val saques = transacoes.filter { it.metodo.equals(Metodo.SAQUE) }
        val ultimosSaques = saques.filter { it.data.month == LocalDate.now().month }

        if ( ultimosSaques.size >= limite) {
            println("Limite de Saques Mensais atingidos")
            return
        }

        this.saldo -= value
        this.transacoes.add(Transacao(value,Metodo.SAQUE,LocalDate.now()))

        println("Saque no valor de R$ $value efetuado com sucesso saldo atual : ${this.saldo}")
    }
}

fun main() {
    val Conta = ContaBancaria("Vitor",200.00)
    val Poupanca = ContaPoupanca("Vitin",200.00)

    Conta.depositar(200.00)
    Conta.sacar(200.00)
    Conta.exibirSaldo()

}



