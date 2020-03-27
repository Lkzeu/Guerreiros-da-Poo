package main;

import java.util.Scanner;

import lutadores.Guerreiro;
import lutadores.Luta;

public class Main {

   public static void main(String[] args) {
      Guerreiro[] guerreiros = new Guerreiro[2];
      
      int opcao;
      
      do {
         Scanner input = new Scanner(System.in); 
         opcao = new Menu().mostrarMenu(input);
         
         switch (opcao) {
            case 1:
               guerreiros = cadastrar(input);
               break;
            case 2:
               limparTela();
               new Luta().lutar(guerreiros[0], guerreiros[1]);
               aguardarEnter(input);
               break;
            case 3:
               alimentar(guerreiros, input);
               break;
            case 4:
               exibirInformacoes(guerreiros, input);
               break;
            default:
               break;
         }
         
         limparTela();
      } while (opcao != 5); 
      
      System.out.println("Até logo!");
   }

   public static void limparTela() {
      System.out.println(System.lineSeparator().repeat(50));
   }
   
   public static void aguardarEnter(Scanner input) {
      System.out.print("Aperte qualquer letra para continuar: ");
      input.next();
   }
   
   public static Guerreiro[] cadastrar(Scanner input) {
      Guerreiro[] guerreiros = new Guerreiro[2];
      input.nextLine();
      limparTela();
      for (int i = 0; i < guerreiros.length; i++) {
         System.out.format("Qual o nome do %d guerreiro? ", i+1);
         String nome = input.nextLine();
         Guerreiro guerreiro = new Guerreiro(nome);
         guerreiros[i] = guerreiro;
      }
      aguardarEnter(input);
      return guerreiros;
   }
   
   public static int selecionarGuerreiro(String msg, Guerreiro[] guerreiros, Scanner input) {
      limparTela();
      System.out.println(msg);
      
      for (int i = 0; i < guerreiros.length; i++) {
         System.out.format("%d - Guerreiro: %s%n", i+1, guerreiros[i].getNome());
      }
      
      System.out.print("Digite o número: ");
      int opcao = input.nextInt();
      
      return opcao;
   }
   
   public static void alimentar(Guerreiro[] guerreiros, Scanner input) {
      String msg = "DIGITE O NÚMERO DO GUERREIRO QUE DESEJA ALIMENTAR";
      
      int opcao = selecionarGuerreiro(msg, guerreiros, input);
      
      if (opcao == 1) {
         guerreiros[0].alimentar();
      } else if (opcao == 2) {
         guerreiros[1].alimentar();
      } else {
         System.out.println("Não foi possível alimentar.\nNúmero inválido.");
      }
      
      aguardarEnter(input);
   }

   public static void exibirInformacoes(Guerreiro[] guerreiros, Scanner input) {
      String msg = "DIGITE O NÚMERO DO GUERREIRO QUE DESEJA VER AS INFORMAÇÕES";
      
      int opcao = selecionarGuerreiro(msg, guerreiros, input);
      
      limparTela();
      if (opcao == 1) {
         System.out.println(guerreiros[0]);
      } else if (opcao == 2) {
         System.out.println(guerreiros[1]);
      } else {
         System.out.println("Impossível exibir informações, número inválido.");
      }
      
      aguardarEnter(input);
   }
}
