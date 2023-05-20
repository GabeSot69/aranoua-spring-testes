package model;

public class Conta {

    private double saldo;
    private boolean ativa;
    private Pessoa pessoa;

    public void ativar(){
        this.ativa = true;
    }

    public void desativar(){
        this.ativa = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void depositar(double valor){
        if(!this.ativa){
            throw new RuntimeException("Conta Inativa! Não é possível depositar.");
        }
        if (!pessoa.isAtiva()){
            throw new RuntimeException("Pessoa Inativa! Não é possível depositar.");
        }

        saldo += valor;
    }

    public void sacar(double valor){

        if (!this.ativa){
            throw new IllegalStateException("Conta Inativa");
        }
        if (!pessoa.isAtiva()){
            throw new RuntimeException("Pessoa Inativa! Não é possível sacar.");
        }
        if (saldo < valor){
            throw new RuntimeException("Saldo Menor que o Saque");
        }

        saldo -= valor;


    }


}
