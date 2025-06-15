package model;
public class Banco {
  private String nome;
  private Conta[] contas;
  private int contadorContas;
  
  public Banco (String nomeBanco, int tamanho) {
    nome = nomeBanco;
    contas = new Conta[tamanho];
    contadorContas = 0;
  }

  public void criarConta (int id, TipoConta tipo) {
    if(tipo == TipoConta.CONTA) {
      contas[id] = new Conta(id);
    } else if(tipo == TipoConta.CONTABONIFICADA) {
      contas[id] = new ContaBonificada(id);
    } else {
      contas[id] = new Poupanca(id);
    }
    contadorContas += 1;
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
