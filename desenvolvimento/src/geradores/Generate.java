package geradores;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Generate {

    private int quant;
    private int imax;
    private int imin;

    static Random GERADOR = new Random();

    public void gerar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Pessoas no grupo: ");
        quant = in.nextInt();
        System.out.println("Maior idade do grupo: ");
        imax = in.nextInt();
        System.out.println("Menor idade do grupo: ");
        imin = in.nextInt();

        for (int i = 0; i < quant; i++) {
            int irand = GERADOR.nextInt((imax - imin) + 1) + imin;
            salvar(irand);
            i++;
        }

    }

    /**
     * Passam a sr gravados em txt as idades da populacao do RS
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
