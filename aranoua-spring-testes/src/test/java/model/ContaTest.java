package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTest {

    private Conta conta;

    private static double valorDeposito;
    private static double valorSaque;
    private static double valorZerado;
    private static double valorSaqueInvalido;

    @BeforeAll
    private static void preparaValores(){
        valorDeposito = 100.00;
        valorSaque = 50.00;
        valorZerado = 0.00;
        valorSaqueInvalido = 150.00;
    }

    @BeforeEach
    private void preparaPreCondicao(){

        this.conta = new Conta();
        this.conta.setPessoa(new Pessoa());
        conta.ativar();
        conta.getPessoa().ativar();
    }

    @Test
    public void deveDepositarComValorValido(){
        conta.depositar(valorDeposito);

        Assertions.assertEquals(valorDeposito,conta.getSaldo());

    }

    @Test
    public void naoDeveDepositarComContaInativa(){
        conta.desativar();

        Assertions.assertThrows(RuntimeException.class, () -> conta.depositar(valorDeposito));

        Assertions.assertEquals(valorZerado, conta.getSaldo());
    }

    public void naoDeveDepositarComPessoaInativa(){
        conta.getPessoa().desativar();

        Assertions.assertThrows(RuntimeException.class, () -> conta.depositar(valorDeposito));

        Assertions.assertEquals(valorZerado, conta.getSaldo());
    }

    @Test
    public void naoDeveSacarComContaInativa(){
        conta.depositar(valorDeposito);
        conta.desativar();

        Assertions.assertThrows(IllegalStateException.class, () -> conta.sacar(valorSaque));

        Assertions.assertEquals(valorDeposito, conta.getSaldo());
    }

    public void naoDeveSacarComPessoaInativa(){
        conta.depositar(valorDeposito);
        conta.getPessoa().desativar();

        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(valorSaque));

        Assertions.assertEquals(valorDeposito, conta.getSaldo());
    }

    @Test
    public void deveSacarComValorMenorQueOSaldo(){
        conta.depositar(valorDeposito);

        conta.sacar(valorSaque);

        Assertions.assertEquals(valorDeposito - valorSaque, conta.getSaldo());
    }

    @Test
    public void naoDeveSacarContaComValorMaiorQueSaldo(){

        conta.depositar(valorDeposito);

        Assertions.assertThrows(RuntimeException.class, () -> conta.sacar(valorSaqueInvalido));
        Assertions.assertEquals(valorDeposito, conta.getSaldo());
    }

}
