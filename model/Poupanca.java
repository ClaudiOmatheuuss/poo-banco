package model;

public class Poupanca extends Conta {
  public Poupanca (int id) {
    super(id);
  }

  public void rendeConta () {
    double taxaRendimento = super.getSaldo() * 0.05;
    super.depositar(taxaRendimento);
  }
}