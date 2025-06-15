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

  public boolean sacar (int id, double valor) {
    return contas[id].sacar(valor);
  }

  public boolean depositar (int id, double valor) {
    return contas[id].depositar(valor);
  }

  public boolean incrementarBonus (int id) {
    if (contas[id] instanceof ContaBonificada) {
      ContaBonificada c = (ContaBonificada) contas[id];
      c.incrementarBonus();
      return true;
    } else {
      return false;
    }
  }

  public boolean rendeConta (int id) {
    if (contas[id] instanceof Poupanca) {
      Poupanca p = (Poupanca) contas[id];
      p.rendeConta();
      return true;
    } else {
      return false;
    }
  }

  public double getSaldo (int id) {
    return contas[id].getSaldo();
  }

  public String getContaInfo (int id) {
    return contas[id].getContaInfo();
  }

  public String getNome () {
    return this.nome;
  }
}
