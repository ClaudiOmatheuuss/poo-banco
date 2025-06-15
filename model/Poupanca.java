package model;

import exception.SemRendimentoException;
import exception.ValorInvalidoException;

final class Poupanca extends Conta {
  private double taxaRendimento = getSaldo() * 0.05;

  public Poupanca (int id, TipoConta tipoConta) {
    super(id, tipoConta);
  }

  public void rendeConta () throws SemRendimentoException, ValorInvalidoException {
    if (taxaRendimento == 0) {
      throw new SemRendimentoException(taxaRendimento);
    }
    super.depositar(taxaRendimento);
    throw new ValorInvalidoException(getSaldo());      
  }

  public double getTaxaRendimento () {
    return taxaRendimento;
  }

}