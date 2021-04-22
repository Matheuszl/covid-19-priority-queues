package geradores;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Generate {

    private int quantPessoas; //numero de pessoas no grupo de idade
    private int imax; //maior idade do grupo
    private int imin; //meor idade do grupo
    private int quantGrupos; //quantidade de grupos que voce ira cadastrar

    static Random GERADOR = new Random();

    /**
     * Metodo gerador de grupos de idade
     * 1° informe quantos grupos deseja cadastrar
     * 2° Informe a maior idade pertencente ao grupo e a menor
     * 
     * Exemplo: Pessoas no grupo: 20, imax=50, imin=30
     * Ele ira salvar no arquivo 20 pessoas om idades entre 50 e 30
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
     * Passam a ser gravados em txt as idades da populacao do RS
     * 
     * @param idade
     */
    public void salvar(int idade) {

        try {

            FileWriter arq = new FileWriter(
                    "C:/Repositorios/covid-19_PriorityQueues/desenvolvimento/src/arquivos_externos/Idades-RS.txt",
                    true);
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.printf(idade + "\n");

            arq.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
