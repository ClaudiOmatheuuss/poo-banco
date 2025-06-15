package exception;

public class SemRendimentoException extends Exception {
  private double taxa;
 
  public SemRendimentoException (double taxa) {
    this.taxa = taxa;
  }

  public double getTaxa() {
    return taxa;
  }
}