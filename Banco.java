public class Banco {
  private String nome;
  private Conta conta;

  public Banco (String nomeBanco) {
    nome = nomeBanco;
    conta = new Conta();
  }

  public boolean sacar (double valor) {
    return conta.sacar(valor);
  }

  public boolean depositar (double valor) {
    return conta.depositar(valor);
  }

  public double getSaldo () {
    return conta.getSaldo();
  }

  public String getNome () {
    return this.nome;
  }
}
