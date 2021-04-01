package principal;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class APA {

	static int IDADE_MINIMA = 18;
	static int IDADE_MAXIMA = 120;
	static int QUANTIDADE_TESTE_A = 100;
	static int QUANTIDADE_TESTE_B = 100000;
	static int QUANTIDADE_TESTE_C = 100000000;
	static Random GERADOR = new Random();

	
	
	public static void main(String[] args) {
		System.out.println("| FILA PRIORITARIA |");

		FilaPessoa filaPessoa = new FilaPessoa(4);
		

		long tempoInicial = System.currentTimeMillis();
		for (int j = 0; j < QUANTIDADE_TESTE_A; j++) {
			Pessoa pessoa = new Pessoa("teste", GERADOR.nextInt((IDADE_MAXIMA - IDADE_MINIMA) + 1) + IDADE_MINIMA);
			filaPessoa.enfileirar(pessoa);
		}
		long tempoFinal = System.currentTimeMillis();

		long tempoInicialDesenpilha = System.currentTimeMillis();
		for (int i = 0; i < QUANTIDADE_TESTE_A; i++) {
			Pessoa saida = filaPessoa.desenfileirar();
			System.out.println(saida.toString());
		}
		long tempoFinalDesenpilha = System.currentTimeMillis();

		System.out.printf("Tempo de cadastro: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
		System.out.printf("Tempo de Prioridade: %.3f ms%n", (tempoFinalDesenpilha - tempoInicialDesenpilha) / 1000d);
		
		salvar(tempoFinalDesenpilha, tempoInicialDesenpilha);

	}

	/**
	 * Salva em txt um historico de tempo em tempo/ms para futuras analise de dados.
	 * 
	 * @param tempoFinal tempo de inicio do cadastro
	 * @param tempoInicial tempo do final do cadastro
 	 */
	public static void salvar(double tempoFinal, double tempoInicial) {

		try {

			FileWriter arq = new FileWriter("C:/Users/matza/Desktop/DadosSaida.txt", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			double gravarTempoEntrada = (tempoFinal - tempoInicial) / 1000d;
			String str = Double.toString(gravarTempoEntrada);
			gravarArq.printf(str + "\n");

			arq.close();

		} catch (Exception e) {
			
		}

	}

}
