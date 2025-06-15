package exception;

public class ValorInvalidoException extends Exception {
  private double saldo;

  public ValorInvalidoException (double saldo) {
    this.saldo = saldo;
  }

  public double getSaldo () {
    return this.saldo;
  }
}
