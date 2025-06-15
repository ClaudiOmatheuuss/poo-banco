package exception;
import java.lang.NegativeArraySizeException;

public class TamanhoNegativoException extends NegativeArraySizeException {
  private int tamanho;

  public TamanhoNegativoException(int tamanho) {
    super("Tamanho negativo não permitido: " + tamanho);
    this.tamanho = tamanho;
  }

  public int getTamanho() {
    return this.tamanho;
  }
}
