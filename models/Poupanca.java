package models;

public class Poupanca extends Conta {
  
  public void rendeConta () {
    double taxaRendimento = super.getSaldo() * 0.05;
    super.depositar(taxaRendimento);
  }
}