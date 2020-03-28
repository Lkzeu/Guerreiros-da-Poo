package lutadores;

import java.util.Random;

public class Luta {

   public void lutar(Guerreiro lutador, Guerreiro oponente) {

      if (lutador.getCodigoLutador() != oponente.getCodigoLutador()) {

         if (lutador.getEnergia() == 0 | oponente.getEnergia() == 0) {

            System.out.println("não é possível lutar. Vá comer e depois volte!");

         } else {
            String lutador1 = null;
            String lutador2 = null;

            while(true) {
               int ordemDeAtaque = new Random(System.nanoTime()).nextInt(2);

               if (ordemDeAtaque == 0) {
                   lutador1 = lutando(lutador, oponente);
                   if (lutador1 == "Venceu") { break; }

                   lutador2 = lutando(oponente, lutador);
                   if (lutador2 == "Venceu") { break; }

               } else {
                  lutador2 = lutando(oponente, lutador);
                  if (lutador2 == "Venceu") { break; }

                  lutador1 = lutando(lutador, oponente);
                  if (lutador1 == "Venceu") { break; }
               }
            }
            if (lutador1 == "Venceu") { lutaFinalizada(lutador, oponente); }
            if (lutador2 == "Venceu") { lutaFinalizada(oponente, lutador); }
         }
      } else {
         System.out.println("NÃO É POSSÍVEL LUTAR CONSIGO MESMO!");
      }
   }

   public void lutaFinalizada(Guerreiro vencedor, Guerreiro perdedor) {
      System.out.format("%s GANHOU!!!%n", vencedor.getNome().toUpperCase());

      vencedor.setVitorias(vencedor.getVitorias() + 1);
      perdedor.setDerrotas(perdedor.getDerrotas() + 1);
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
