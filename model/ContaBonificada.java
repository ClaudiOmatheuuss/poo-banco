package model;
final class ContaBonificada extends Conta {
  private double bonus;

  public ContaBonificada (int id, TipoConta tipoConta) {
    super(id, tipoConta);
  }

  @Override
  public boolean sacar (double valor) {
    if (valor > super.getSaldo()) {
      return false;
    } else {
      double taxa = valor * 0.1;
      bonus += taxa;
      super.sacar(valor);

      System.out.printf("Bônus atual: %f \n", bonus);
      return true;
    }
  }

  public void incrementarBonus () {
    super.depositar(bonus);
  }
}
