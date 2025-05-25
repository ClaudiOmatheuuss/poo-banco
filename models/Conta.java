package models;
public class Conta {
  protected double saldo;

  public Conta() {
    saldo = 0;
  }

  public boolean sacar (double valor) {
    if (valor > saldo) {
      return false;
    } else {
      saldo -= valor;
      return true;
    }
  }
  
  public boolean depositar (double valor) {
    if (valor <= 0) {
      return false;
    } else {
      saldo += valor;
      return true;
    }
  }

  public double getSaldo () {
    return saldo;
  }
}
