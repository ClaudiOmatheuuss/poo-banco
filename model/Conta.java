package model;
public class Conta {
  private double saldo;
  private int id;

  public Conta(int id) {
    saldo = 0;
    this.id = id;
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
