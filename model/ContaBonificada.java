package model;

import exception.ValorInvalidoException;

final class ContaBonificada extends Conta {
  private double bonus;

  public ContaBonificada (int id, TipoConta tipoConta) {
    super(id, tipoConta);
  }

  @Override
  public void sacar (double valor) throws ValorInvalidoException {
    if (valor > super.getSaldo()) {
      throw new ValorInvalidoException(getSaldo());
    }
    double taxa = valor * 0.1;
    bonus += taxa;
    super.sacar(valor);
    System.out.printf("Bônus atual: %f \n", bonus);
  }

  public void incrementarBonus () {
    try {
      super.depositar(bonus);
    } catch (ValorInvalidoException e) {}
  }
}
