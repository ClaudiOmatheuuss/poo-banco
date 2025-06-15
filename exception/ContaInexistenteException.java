package exception;

public class ContaInexistenteException extends Exception {
  private int id;

  public ContaInexistenteException (int id) {
    this.id = id;
  }

  public int getId () {
    return this.id;
  }
}
