package view;

import java.util.Scanner;
import models.Banco;

public class Main {
  public static void exibirMenu() {
    System.out.println("_".repeat(40));
    System.out.println(" Menu:");
    System.out.println("  0. Criar conta");
    System.out.println("  1. Sacar");
    System.out.println("  2. Depositar");
    System.out.println("  3. Consultar saldo");
    System.out.println("  4. Incrementar cashback");
    System.out.println("  5. Render conta");
    System.out.println("_".repeat(40));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insira o nome do banco: \n >> ");
    String nomeBanco = scanner.nextLine();
    System.out.print("Insira a quantidade de contas desejada: \n >> ");
    int tamanho = scanner.nextInt();
    Banco banco = new Banco(nomeBanco, tamanho);
    System.out.printf("\n \n Bem vindo ao sistema do %s \n", banco.getNome());

    while (true) {
      System.out.printf("_".repeat(40) + "\n Escolha conta desejada(0 a %d): \n >> ", tamanho - 1);
      int contaSelecionada = scanner.nextInt();

      exibirMenu();
      System.out.print("Insira o digito da opcao desejada: \n >> ");
      int opcaoEscolhida = scanner.nextInt();
      
      if (opcaoEscolhida == 0) {
        System.out.println("Escolha o tipo de conta que deseja criar");
        System.out.print("\n 1. conta corrente \n 2. conta corrente bonificada \n 3. conta poupanca \n>> ");
        int tipoEscolhido = scanner.nextInt();
        banco.criarConta(contaSelecionada, tipoEscolhido); 
      } else if (opcaoEscolhida == 1) { 
        boolean saqueRealizado = false;
        while (saqueRealizado == false) {
          System.out.println("_".repeat(40));
          System.out.print("Insira o valor do saque: \n >> ");
          double valor = scanner.nextDouble();
          System.out.println("_".repeat(40));
          saqueRealizado = banco.sacar(contaSelecionada, valor);

          if (saqueRealizado == false) {
            System.out.println("DICA: Insira um valor menor ou igual ao seu saldo atual.");
            System.out.printf("Saldo: %s \n", banco.getSaldo(contaSelecionada));
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
          depRealizado = banco.depositar(contaSelecionada, valor);
          if (depRealizado == false) {
            System.out.println("DICA: insira um valor maior que zero.");
          } else {
            System.out.println("Deposito realizado!");
          }
        }
      } else if (opcaoEscolhida == 3) {

        System.out.printf("O seu saldo eh: %f \n", banco.getSaldo(contaSelecionada));
        
      } else if (opcaoEscolhida == 4) {

        if (banco.incrementarBonus(contaSelecionada)) {
          System.out.println("Bônus adicionado ao saldo da conta");
          System.out.println("_".repeat(40));
          System.out.printf("Saldo atual: %f \n", banco.getSaldo(contaSelecionada));
        } else {
          System.out.println("A conta nao eh do tipo corrente bonificada, tente novamente!");
        }


      } else if (opcaoEscolhida == 5) {

        if (banco.rendeConta(contaSelecionada)) {
          System.out.println("Rendimentos adicionados a conta");
          System.out.println("_".repeat(40));
          System.out.printf("Saldo atual: %f \n", banco.getSaldo(contaSelecionada));
        } else {
          System.out.println("A conta nao eh do tipo poupanca, tente novamente!");
        }

      } else {
        System.out.println("Opcao invalida, reinicie o sistema e tente novamente.");
        break;
      }
    }
    scanner.close();
  }
}
