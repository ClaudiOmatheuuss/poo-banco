package models;
public class ContaBonificada extends Conta {
  
  public boolean sacar (double valor) {
    if (valor > super.saldo) {
      return false;
    } else {
      double taxa = saldo * 0.01;
      super.saldo = super.saldo - valor + taxa;
      return true;
    }
  }
}
