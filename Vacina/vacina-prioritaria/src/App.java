
/**
* @author Matheus Zalamena de Lima
* @version 3.1
* @email matheus.zzalamena@gmail.com
*/

//imports
import java.util.ArrayList;
import controller.Arquivos;
import controller.Fila;
import domain.Pessoa;

public class App {
    // Variavis de escopo global
    static Arquivos leitura;
    static ArrayList<Integer> idades;
    static ArrayList<Double> TEMPOS = new ArrayList<Double>();
    static double SOMA = 0;
    static double MEDIA = 0;
    static int QUANT_LOOPING = 15;
    static int COUNT;

    public static void main(String[] args) {
        apresentacao();
        for (int i = 0; i < QUANT_LOOPING; i++) {
            priorizacao();
        }
        

        // salva dados calculados nos arquivos txt //se nao for executado a
        // priorizacao() antes, erro! 
        Arquivos.saveDesvioIdade(calculoDesvio());
        Arquivos.saveTempoIdades(MEDIA);
        System.out.println(COUNT + " instancias Priorizados em: " + MEDIA+ "ms");
        System.out.println("Finish");

    }

    /**
     * Metodo oande ocorre a captura de tempo do procesamento do algoritimo fila
     * prioritaria
     */
    public static void priorizacao() {
        // ArrayList que salva as idades lidas do arquivo idades.txt
        ArrayList<Integer> lista = leitura.ler();
        COUNT = lista.size();
        // instancia da classe Fila pode ser altrada para FilaGrupo
        Fila fila = new Fila(10);
        int setGrupo = 0;

        for (int j = 0; j < lista.size(); j++) {
            int getIdade = lista.get(j);

            if (getIdade <= 94 && getIdade >= 65) {
                setGrupo = 5;
            } else if (getIdade <= 64 && getIdade >= 45) {
                setGrupo = 4;
            } else if (getIdade <= 44 && getIdade >= 25) {
                setGrupo = 3;
            } else if (getIdade <= 24 && getIdade >= 18) {
                setGrupo = 2;
            } else if (getIdade <= 17 && getIdade >= 0) {
                setGrupo = 1;
            }

            Pessoa pessoa = new Pessoa("Pessoa ", getIdade, setGrupo);

            fila.enfileirar(pessoa);
            // filaGrupo.enfileirar(pessoa);
            j++;
        }

        // Salva tempo inicial da priorizacao
        long init = System.currentTimeMillis();
        for (int j = 0; j < lista.size(); j++) {
            fila.desenfileirar();
            j++;
        }
        // Salva tempo final da priorizacao
        long finish = System.currentTimeMillis();
        // Formata em ms o tempo de processamento
        double time = (finish - init) / 1000d;
        calculoMedia(time);
    }

    /**
     * Calcula a media e salva em um array de medias depois esse array é usado
     * novamente para o calculo do desvio padrao
     */
    public static void calculoMedia(double time) {
        SOMA = SOMA + time;
        MEDIA = SOMA / QUANT_LOOPING;
        TEMPOS.add(MEDIA);
    }

    /**
     * Calculo do desvio padrao e logo após salva no arquivo txt alem de salvar a
     * media tambem
     */
    public static double calculoDesvio() {
        double somaNumeros = 0;

        for (int i = 0; i < QUANT_LOOPING; i++) {
            somaNumeros += Math.pow(MEDIA - TEMPOS.get(i), 2);
        }

        double resultado = somaNumeros / TEMPOS.size();
        double desvioPadrao = Math.sqrt(resultado);

        System.out.println("Desvio padrao: " + desvioPadrao);

        return desvioPadrao;
    }

    public static void apresentacao() {
        System.out.println("|Algoritimo fila prioritaria usando Binary Heap| \n"
                + " ---------------------------------------------- \n");
    }
}
