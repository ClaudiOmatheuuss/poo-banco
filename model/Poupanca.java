package model;

import exception.ValorInvalidoException;

final class Poupanca extends Conta {
  public Poupanca (int id, TipoConta tipoConta) {
    super(id, tipoConta);
  }

  public void rendeConta () {
    try {
      double taxaRendimento = super.getSaldo() * 0.05;
      super.depositar(taxaRendimento);
    } catch (ValorInvalidoException e) {}
  }
}