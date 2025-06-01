package models;
public class Banco {
  private String nome;
  private Conta[] contas;
  
  public Banco (String nomeBanco) {
    nome = nomeBanco;
    contas = new Conta[5];
    int i;
    for (i = 0; i < 5; i++) {
      if (i == 0) {
        contas[i] = new ContaBonificada();
      } else if (i == 1) {
        contas[i] = new Poupanca();
      } else {
        contas[i] = new Conta();
      }
    }
  }

  public boolean sacar (int contaSelecionada, double valor) {
    return contas[contaSelecionada].sacar(valor);
  }

  public boolean depositar (int contaSelecionada, double valor) {
    return contas[contaSelecionada].depositar(valor);
  }

  public boolean incrementarBonus (int contaSelecionada) {
    if (contas[contaSelecionada] instanceof ContaBonificada) {
      ContaBonificada c = (ContaBonificada) contas[contaSelecionada];
      c.incrementarBonus();
      return true;
    } else {
      return false;
    }
  }

  public boolean rendeConta (int contaSelecionada) {
    if (contas[contaSelecionada] instanceof Poupanca) {
      Poupanca p = (Poupanca) contas[contaSelecionada];
      p.rendeConta();
      return true;
    } else {
      return false;
    }
  }

  public double getSaldo (int contaSelecionada) {
    return contas[contaSelecionada].getSaldo();
  }

  public String getNome () {
    return this.nome;
  }

}
