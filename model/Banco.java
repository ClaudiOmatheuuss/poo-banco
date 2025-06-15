package model;
import exception.*;

public class Banco {
  private String nome;
  private Conta[] contas;
  private int contadorContas;
  private int tamanho;
  
  public Banco (String nomeBanco, int tamanho) throws TamanhoInvalidoException, TamanhoNegativoException {
    nome = nomeBanco;
    contadorContas = 0;
    if (tamanho == 0) {
      throw new TamanhoInvalidoException(tamanho);
    } else if (tamanho < 0) {
      throw new TamanhoNegativoException(tamanho);
    }
    contas = new Conta[tamanho];
    this.tamanho = tamanho;
  }

  public String criarConta (TipoConta tipo) throws LimiteContasException {
    int id = contadorContas;
    if (contadorContas == tamanho) {
      throw new LimiteContasException(tamanho);
    }
    
    if(tipo == TipoConta.CONTA) {
      contas[id] = new Conta(id);
    } else if(tipo == TipoConta.CONTABONIFICADA) {
      contas[id] = new ContaBonificada(id);
    } else {
      contas[id] = new Poupanca(id);
    }
    contadorContas += 1;
    return getContaInfo(id);
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

  public Conta getConta (int id) throws ContaInexistenteException {
    Conta c = contas[id];
    if (c == null) {
      throw new ContaInexistenteException(id);
    }
    return c;
  }

  public String getNome () {
    return this.nome;
  }

  public int getTamanho() {
    return this.tamanho;
  }
}
