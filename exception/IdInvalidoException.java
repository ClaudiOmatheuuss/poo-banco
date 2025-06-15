package exception;

public class IdInvalidoException extends Exception {
  private int id;

  public IdInvalidoException (int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }
}
