package model;
import exception.ValorInvalidoException;
public class Conta {
  private double saldo;
  private int id;
  private TipoConta tipoConta;

  public Conta(int id, TipoConta tipoConta) {
    saldo = 0;
    this.id = id;
    this.tipoConta = tipoConta;
  }

  public void sacar (double valor) throws ValorInvalidoException {
    if (valor > saldo | valor <= 0) {
      throw new ValorInvalidoException(saldo);
    } 
    saldo -= valor;
  }
  
  public void depositar (double valor) throws ValorInvalidoException {
    if (valor <= 0) {
      throw new ValorInvalidoException(saldo);
    }
    saldo += valor;
  }

  public double getSaldo () {
    return this.saldo;
  }

  public String getContaInfo () {
    return String.format("CONTA %s | ID: %d | Saldo: R$ %.2f", this.tipoConta, this.id,  this.saldo);
  }
}
