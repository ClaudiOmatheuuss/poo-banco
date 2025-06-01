package view;

import java.util.Scanner;
import models.Banco;

public interface Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insira o nome do banco: \n >> ");
    String nomeBanco = scanner.nextLine();
    Banco banco = new Banco(nomeBanco);
    System.out.printf("\n \n Bem vindo ao sistema do %s \n", banco.getNome());

    while (true) {
      System.out.print("_".repeat(40) + "\n Escolha conta desejada(0 a 4): \n >> ");
      int contaSelecionada = scanner.nextInt();

      String opcoes = "1. sacar \n 2. depositar \n 3. consultar saldo \n 4. incrementar cashback \n 5. render conta \n";
      
      System.out.println("_".repeat(40));
      System.out.printf("Menu: \n %s", opcoes);
      System.out.println("_".repeat(40));

      System.out.print("Insira o digito da opcao desejada: \n >> ");
      int opcaoEscolhida = scanner.nextInt();
      
      if (opcaoEscolhida == 1) { 
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
