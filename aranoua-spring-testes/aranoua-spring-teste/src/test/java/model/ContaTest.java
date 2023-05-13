package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ContaTest {
    @Test
    public void deveDepositarContaComValorValido(){
        Conta conta = new Conta();
        conta.depositar(100.00);

        Assertions.assertEquals(100.00, conta.getSaldo());
    }

    @Test
    public void deveSacarContaComValorValido(){
        Conta conta = new Conta();
        conta.depositar(100.00);
        conta.sacar(50.00);
        Assertions.assertEquals(50.00, conta.getSaldo());
    }

    @Test
    public void naoDeveSacarContaComValorMaiorQueSaldo(){
        Conta conta = new Conta();
        conta.depositar(100.00);
        conta.sacar(101.00);
        Assertions.assertEquals(100.00, conta.getSaldo());
    }
}
