package model;

public class Conta {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor){
        if (saldo >= valor){
           saldo -= valor;
        }

    }
}
