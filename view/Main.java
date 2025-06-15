package view;

import java.util.Scanner;

import exception.*;
import model.Banco;
import model.TipoConta;

public class Main {

  public static boolean validaOpcao (int opcaoEscolhida) {
    int[] opcoesValidas = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
    for (int i = 0; i < opcoesValidas.length; i++) {
      if (opcaoEscolhida == opcoesValidas[i]) {
        return true;
      }
    }
    return false;
  }

  public static void exibirMenu() {
    System.out.println("_".repeat(40));
    System.out.println(" Menu:");
    System.out.println("  0. Criar conta");
    System.out.println("  1. Sacar");
    System.out.println("  2. Depositar");
    System.out.println("  3. Consultar saldo");
    System.out.println("  4. Incrementar cashback");
    System.out.println("  5. Render conta");
    System.out.println("  6. Deletar conta");
    System.out.println("  7. Sair do sistema");
    System.out.println("_".repeat(40));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insira o nome do banco: \n >> ");
    String nomeBanco = scanner.nextLine();
    int tamanho;
    Banco banco = null;
    while (banco == null) {
      try {
        System.out.print("Insira a quantidade de contas desejada: \n >> ");
        tamanho = scanner.nextInt();
        banco = new Banco(nomeBanco, tamanho);
      } catch (TamanhoInvalidoException e) {
        System.out.printf("Quantidade de contas invalida(%d), por favor escolha um valor positivo \n", e.getTamanho());
        System.out.println("_".repeat(40));
      } catch (TamanhoNegativoException e) {
        System.out.printf("Quantidade de contas invalida(%d), por favor escolha um valor positivo \n", e.getTamanho());
        System.out.println("_".repeat(40));
      }
    }
    System.out.printf("\n \n Bem vindo ao sistema do %s \n", banco.getNome());
    
    while (true) {
      TipoConta tipo;
           
      exibirMenu();
        System.out.print("Insira o digito da opcao desejada: \n >> ");
        int opcaoEscolhida = scanner.nextInt();

      if (validaOpcao(opcaoEscolhida)) {
        if (opcaoEscolhida == 0) {
          System.out.println("Escolha o tipo de conta que deseja criar");
          System.out.print("\n 1. conta corrente \n 2. conta corrente bonificada \n 3. conta poupanca \n>> ");
          int tipoEscolhido = scanner.nextInt();
          if (tipoEscolhido == 1) {
            tipo = TipoConta.CONTA; 
          } else if (tipoEscolhido == 2) {
            tipo = TipoConta.CONTABONIFICADA;
          } else {
            tipo = TipoConta.POUPANCA;
          }
          try {
            System.out.println(banco.criarConta(tipo));
          } catch (LimiteContasException e) {
            System.out.printf("Nao eh possivel criar mais contas(voce excedeu o limite de contas): %s contas \n", e.getTamanho());
          }

        } else if (opcaoEscolhida == 7) {
          scanner.close();
          System.out.println("Encerrando o sistema...");
          break;
        } else {
          System.out.printf("_".repeat(40) + "\n Escolha conta desejada(0 a %d): \n >> ", banco.getTamanho() - 1);
          int id = scanner.nextInt();
          try {
            banco.validarConta(id);
          
            if (opcaoEscolhida == 1) { 
              boolean saqueRealizado = false;
              while (saqueRealizado == false) {
                System.out.println("_".repeat(40));
                System.out.print("Insira o valor do saque: \n >> ");
                double valor = scanner.nextDouble();
                System.out.println("_".repeat(40));
                saqueRealizado = banco.sacar(id, valor);

                if (saqueRealizado == false) {
                  System.out.println("DICA: Insira um valor menor ou igual ao seu saldo atual.");
                  System.out.printf("Saldo: %s \n", banco.getSaldo(id));
                } else {
                  System.out.println("Saque realizado!");
                }
              }
            } else if (opcaoEscolhida == 2) { 
              boolean depRealizado = false;
              while (depRealizado == false) {
                System.out.println("_".repeat(40));
                System.out.print("Insira o valor do deposito: \n >> ");
                double valor = scanner.nextDouble();
                System.out.println("_".repeat(40));
                depRealizado = banco.depositar(id, valor);
                if (depRealizado == false) {
                  System.out.println("DICA: insira um valor maior que zero.");
                } else {
                  System.out.println("Deposito realizado!");
                }
              }
            } else if (opcaoEscolhida == 3) {
              System.out.println("_".repeat(40));
              System.out.println(banco.getContaInfo(id));      
            } else if (opcaoEscolhida == 4) {
              
              if (banco.incrementarBonus(id)) {
                System.out.println("Bônus adicionado ao saldo da conta");
                System.out.println("_".repeat(40));
                System.out.printf("Saldo atual: %f \n", banco.getSaldo(id));
                } else {
                  System.out.println("A conta nao eh do tipo corrente bonificada, tente novamente!");
                }

            } else if (opcaoEscolhida == 5) {

              if (banco.rendeConta(id)) {
                System.out.println("Rendimentos adicionados a conta");
                System.out.println("_".repeat(40));
                System.out.printf("Saldo atual: %f \n", banco.getSaldo(id));
              } else {
                System.out.println("A conta nao eh do tipo poupanca, tente novamente!");
              }

            } else if (opcaoEscolhida == 6) {
              banco.deletarConta(id);
              System.out.println("Conta apagada com sucesso.");
            }
          } catch (ContaInexistenteException e) {
            System.out.printf("Conta(id: %d) escolhida ainda nao existe, tente novamente.\n", e.getId());
          } catch (IdInvalidoException e) {
            System.out.printf("id(%d) invalido! escolha um id positivo e de uma conta existente.\n", e.getId());
          }
        }
      } else {
        System.out.println("Opcao invalida, tente novamente.");
      }
    }
  }
}