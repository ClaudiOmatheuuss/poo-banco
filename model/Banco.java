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
    
    if(tipo == TipoConta.CORRENTE) {
      contas[id] = new Conta(id, tipo);
    } else if(tipo == TipoConta.CORRENTEBONIFICADA) {
      contas[id] = new ContaBonificada(id, tipo);
    } else {
      contas[id] = new Poupanca(id, tipo);
    }
    contadorContas += 1;
    return getContaInfo(id);
  }

  public void sacar (int id, double valor) throws ValorInvalidoException {
    contas[id].sacar(valor);
  }

  public void depositar (int id, double valor) throws ValorInvalidoException {
    contas[id].depositar(valor);
  }

  public void incrementarBonus (int id) throws TipoIncorretoException, SemRendimentoException {
    if (!(contas[id] instanceof ContaBonificada)) {
      throw new TipoIncorretoException();
    }
    ContaBonificada c = (ContaBonificada) contas[id];
    c.incrementarBonus();
  }

  public void rendeConta (int id) throws TipoIncorretoException, SemRendimentoException, ValorInvalidoException {
    if (!(contas[id] instanceof Poupanca)) {
      throw new TipoIncorretoException();
    }
    Poupanca p = (Poupanca) contas[id];
    p.rendeConta();
  }

  public void deletarConta (int id) {
    contas[id] = null;
  }
  
  public void validarConta (int id) throws ContaInexistenteException, IdInvalidoException {
    if (id >= tamanho | id < 0) {
      throw new IdInvalidoException(id, tamanho);
    }
    if (contas[id] == null) {
      throw new ContaInexistenteException(id);
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

  public int getTamanho() {
    return this.tamanho;
  }
}
