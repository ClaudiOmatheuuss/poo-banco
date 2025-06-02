package models;
public class Banco {
  private String nome;
  private Conta[] contas;
  
  public Banco (String nomeBanco, int tamanho) {
    nome = nomeBanco;
    contas = new Conta[tamanho];
    double qtdEspeciais = contas.length * 0.3; // 30% da quantidade total de contas
    int i;
    for (i = 0; i < contas.length; i++) {
      if (i < qtdEspeciais) {             // cerca de 0 a 30% do total: eh ContaBonificada()
        contas[i] = new ContaBonificada();
      } else if (i < 2*qtdEspeciais) {      // cerca de 30% a 60% do total: eh Poupanca()
        contas[i] = new Poupanca();
      } else {                            // restante: eh Conta()
        contas[i] = new Conta();
      }
    }
  }

  public void criarConta (int id, int tipoConta) {
    switch (tipoConta) {
      case 2:
        contas[id] = new ContaBonificada();
        break;
      case 3:
        contas[id] = new Poupanca();
        break;
      default:
        contas[id] = new Conta();
        break;
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
