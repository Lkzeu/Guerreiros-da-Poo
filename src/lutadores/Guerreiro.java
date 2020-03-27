package lutadores;

import java.util.Random;

public class Guerreiro implements Lutador {

   private static int COD_INICIAL = 1;
   
   private String nome;
   private byte energia;
   private int vitorias;
   private int derrotas;
   private int codigoLutador;
   
   public Guerreiro(String nome) {
      this.codigoLutador = COD_INICIAL++;
      this.nome = nome;
      this.energia = 5; 
      this.vitorias = 0;
      this.derrotas = 0;
   }
   
   @Override
   public String toString() {
      String estado = " -- INFORMAÇÕES DO GUERREIRO -- " +
                      "\nCódigo: " + this.getCodigoLutador() +
                      "\nNome: " + this.getNome() +
                      "\nEnergia: " + this.getEnergia() +
                      "\nVitórias: " + this.getVitorias() +
                      "\nDerrotas: " + this.getDerrotas();
      return estado;
   }
   
   @Override
   public boolean atacar() {
      Random random = new Random(System.nanoTime());
      boolean ataqueBemSucedido = random.nextBoolean();
      return ataqueBemSucedido;
   }

   @Override
   public void alimentar() {
      this.incrementar();
   }

   @Override
   public void incrementar() {
      if (this.getEnergia() < 5) {
         this.setEnergia((byte) (this.getEnergia() + (byte) 1));
      } else {
         System.out.println("A energia já está cheia!");
      }

   }

   @Override
   public void decrementar() {
      if (this.getEnergia() > 0) {
         this.setEnergia((byte) (this.getEnergia() - (byte) 1));
      } else {
         System.out.format("%s, lamento informar, mas você está sem energia%n", this.getNome());
      }
   }

   // GETTERS AND SETTERS
   public int getCodigoLutador() {
      return codigoLutador;
   }

   public String getNome() {
      return nome;
   }
   
   public void setEnergia(byte energia) {
      this.energia = energia;
   }
   public byte getEnergia() {
      return energia;
   }

   public void setVitorias(int vitorias) {
      this.vitorias = vitorias;
   }
   public int getVitorias() {
      return vitorias;
   }
 
   public void setDerrotas(int derrotas) {
      this.derrotas = derrotas;
   }
   public int getDerrotas() {
      return derrotas;
   }
}
