package lutadores;

import java.util.Random;

public class Luta {

   public void lutar(Guerreiro lutador, Guerreiro oponente) {
      
      if (lutador.getCodigoLutador() != oponente.getCodigoLutador()) {
         
         if (lutador.getEnergia() == 0 | oponente.getEnergia() == 0) {
            
            System.out.println("não é possível lutar. Vá comer e depois volte!");
         
         } else {
            while(true) {
               int ordemDeAtaque = new Random(System.nanoTime()).nextInt(2); 
               
               if (ordemDeAtaque == 0) {
                   if (lutando(lutador, oponente) == "Venceu") {
                      System.out.format("%s GANHOU!!!%n", lutador.getNome().toUpperCase());
                      
                      lutador.setVitorias(lutador.getVitorias() + 1);
                      oponente.setDerrotas(oponente.getDerrotas() + 1);
                      break;
                   }
                   if (lutando(oponente, lutador) == "Venceu") {
                      System.out.format("%s GANHOU!!!%n", oponente.getNome().toUpperCase());
                      
                      oponente.setVitorias(oponente.getVitorias() + 1);
                      lutador.setDerrotas(lutador.getDerrotas() + 1);
                      break;
                   }
              
               } else {
                  
                  if (lutando(oponente, lutador) == "Venceu") {
                     System.out.format("%s GANHOU!!!%n", oponente.getNome().toUpperCase());
                     
                     oponente.setVitorias(oponente.getVitorias() + 1);
                     lutador.setDerrotas(lutador.getDerrotas() + 1);
                     break;
                  }
                  if (lutando(lutador, oponente) == "Venceu") {
                     System.out.format("%s GANHOU!!!%n", lutador.getNome().toUpperCase());
                     
                     lutador.setVitorias(lutador.getVitorias() + 1);
                     oponente.setDerrotas(oponente.getDerrotas() + 1);
                     break;
                  }
               }
            } // while end
         } // if energia end
         
      } else {
         System.out.println("NÃO É POSSÍVEL LUTAR CONSIGO MESMO!");
      }
   }
   
   public String lutando(Guerreiro lutador1, Guerreiro lutador2) {
      if (lutador1.getEnergia() > 0) {
         if (lutador1.atacar()) {
            lutador2.decrementar();
            if (lutador2.getEnergia() == 0) {
               return "Venceu";
            }
         }
      }
      
      return "";
   }
}
