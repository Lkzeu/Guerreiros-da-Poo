package main;

import java.util.Scanner;

public class Menu {
   
   public int mostrarMenu(Scanner input) {
      
      System.out.println("1 - CADASTRAR DOIS GUERREIROS");
      System.out.println("2 - LUTAR");
      System.out.println("3 - ALIMENTAR UM GUERREIRO");
      System.out.println("4 - EXEBIR INFORMAÇÕES DE UM GUERREIRO");
      System.out.println("5 - SAIR");
      
      int opcao = input.nextInt();
      return opcao;
   }
}
