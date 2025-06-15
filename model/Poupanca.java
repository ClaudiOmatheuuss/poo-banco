package model;

final class Poupanca extends Conta {
  public Poupanca (int id, TipoConta tipoConta) {
    super(id, tipoConta);
  }

  public void rendeConta () {
    double taxaRendimento = super.getSaldo() * 0.05;
    super.depositar(taxaRendimento);
  }
}