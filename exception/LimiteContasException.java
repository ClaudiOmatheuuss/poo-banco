package exception;

public class LimiteContasException extends Exception {
  private int tamanho;

  public LimiteContasException (int tamanho) {
    this.tamanho = tamanho;
  }

  public int getTamanho() {
    return this.tamanho;
  }
}
