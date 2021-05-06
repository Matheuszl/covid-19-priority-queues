package controller;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Gerador {

  private int quantPessoas; // numero de pessoas no grupo de idade
  private int imax; // maior idade do grupo
  private int imin; // meor idade do grupo
  private int quantGrupos; // quantidade de grupos que voce ira cadastrar

  static Random GERADOR = new Random();

  // construtor vazio
  public Gerador() {
  }

  /**
   * Metodo gerador de grupos de idade 1° informe quantos grupos deseja cadastrar
   * 2° Informe a maior idade pertencente ao grupo e a menor
   * 
   * Exemplo: Pessoas no grupo: 20, imax=50, imin=30 Ele ira salvar no arquivo 20
   * pessoas om idades entre 50 e 30
   */
  public void gerar() {
    Scanner in = new Scanner(System.in);
    System.out.println("Quntidade de grupos para cadastro: ");
    quantGrupos = in.nextInt();
    for (int i = 0; i < quantGrupos; i++) {
      System.out.println("Pessoas no grupo: ");
      quantPessoas = in.nextInt();
      System.out.println("Maior idade do grupo: ");
      imax = in.nextInt();
      System.out.println("Menor idade do grupo: ");
      imin = in.nextInt();
      for (int j = 0; j < quantPessoas; j++) {
        int irand = GERADOR.nextInt((imax - imin) + 1) + imin;
        salvar(irand);
        j++;
      }
    }
  }

  /**
   * Metodo geraro automatico de idades de acordo com os dados do IBGE de
   * Uruguaiana
   */
  public void gerarAutomatico() {
    for (int j = 0; j < 1200; j++) {
      int irand = GERADOR.nextInt((94 - 75) + 1) + 75;
      salvar(irand);
      j++;
    }

    for (int j = 0; j < 4500; j++) {
      int irand = GERADOR.nextInt((74 - 60) + 1) + 60;
      salvar(irand);
      j++;
    }

    for (int j = 0; j < 11350; j++) {
      int irand = GERADOR.nextInt((59 - 45) + 1) + 45;
      salvar(irand);
      j++;
    }
    for (int j = 0; j < 13000; j++) {
      int irand = GERADOR.nextInt((44 - 30) + 1) + 30;
      salvar(irand);
      j++;
    }

    for (int j = 0; j < 17000; j++) {
      int irand = GERADOR.nextInt((29 - 15) + 1) + 15;
      salvar(irand);
      j++;
    }

    for (int j = 0; j < 20300; j++) {
      int irand = GERADOR.nextInt((14 - 0) + 1) + 15;
      salvar(irand);
      j++;
    }
  }

  /**
   * Passam a ser gravados em txt as idades da populacao do RS
   * 
   * @param idade
   */
  public void salvar(int idade) {
    try {

      FileWriter arq = new FileWriter("model/idades.txt", true);
      PrintWriter gravarArq = new PrintWriter(arq);

      gravarArq.printf(idade + "\n");

      arq.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
