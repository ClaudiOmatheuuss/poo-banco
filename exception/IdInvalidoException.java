package exception;

public class IdInvalidoException extends Exception {
  private int id;
  private int tamanho;

  public IdInvalidoException (int id, int tamanho) {
    this.id = id;
    this.tamanho = tamanho;
  }

  public int getId() {
    return this.id;
  }

  public int getTamanho() {
    return this.tamanho;
  }
}
