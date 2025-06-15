package model;

import exception.SemRendimentoException;
import exception.ValorInvalidoException;

final class ContaBonificada extends Conta {
  private double taxa;

  public ContaBonificada (int id, TipoConta tipoConta) {
    super(id, tipoConta);
  }

  @Override
  public void sacar (double valor) throws ValorInvalidoException {
    if (valor > super.getSaldo()) {
      throw new ValorInvalidoException(getSaldo());
    }
    double bonus = valor * 0.1;
    taxa += bonus;
    super.sacar(valor);
    System.out.printf("Bônus atual: %f \n", bonus);
  }

  public void incrementarBonus () throws SemRendimentoException {
    if (taxa == 0) {
      throw new SemRendimentoException(taxa);
    }
    try {
      super.depositar(taxa);
      taxa = 0;
    } catch (ValorInvalidoException e) {}

  }
}
