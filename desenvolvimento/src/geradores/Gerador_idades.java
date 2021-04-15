package geradores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Gerador_idades {
	static Random GERADOR = new Random();

	int quant_idade_90_94 = 43;
	int quant_idade_85_89 = 163;
	int quant_idade_80_84 = 383;
	int quant_idade_75_79 = 636;

	int quantItens = 0;

	/**
	 * Construtor vazio
	 */
	public Gerador_idades() {

	}

	/**
	 * Gera idades Leia a variavel como: gere 43 vezes idades entre 90 anos e 94
	 * anos
	 */
	public void geradores() {

		while (quant_idade_90_94 >= 0) {
			int idade = GERADOR.nextInt((94 - 90) + 1) + 90;
			salvar(idade);
			quant_idade_90_94--;
			quantItens++;
		}

		while (quant_idade_85_89 >= 0) {
			int idade = GERADOR.nextInt((89 - 85) + 1) + 85;
			salvar(idade);
			quant_idade_85_89--;
			quantItens++;
		}

		while (quant_idade_80_84 >= 0) {
			int idade = GERADOR.nextInt((84 - 80) + 1) + 80;
			salvar(idade);
			quant_idade_80_84--;
			quantItens++;
		}

		while (quant_idade_75_79 >= 0) {
			int idade = GERADOR.nextInt((79 - 75) + 1) + 75;
			salvar(idade);
			quant_idade_75_79--;
			quantItens++;
		}

	}


	/**
	 * Passam a sr gravados em txt as idades da populacao do RS
	 * @param idade 
	 */
	public void salvar(int idade) {

		try {

			FileWriter arq = new FileWriter("C:/Repositorios/covid-19_PriorityQueues/desenvolvimento/src/arquivos_externos/Idades-RS.txt", true);
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.printf(idade + "\n");

			arq.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Integer> ler() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Integer idade = 0;

		try {
			BufferedReader buf = new BufferedReader(new FileReader("C:/Repositorios/covid-19_PriorityQueues/desenvolvimento/src/arquivos_externos/Idades-RS.txt"));
			//C:/Repositorios/covid-19_PriorityQueues/desenvolvimento/src/arquivos_externos/
			String linha = "";

			while (true) {
				if (linha != null) {
					linha = buf.readLine();
					if (buf.readLine() == null) {
						break;
					}
					idade = Integer.parseInt(linha);
					lista.add(idade);

				} else {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	

	/**
	 * Salva em txt um historico de tempo em tempo/ms para futuras analise de dados.
	 * @param time
	 * @return 
	 */
	public static void saveTime(double time) {

		try {
			FileWriter arq = new FileWriter("C:/Repositorios/covid-19_PriorityQueues/desenvolvimento/src/arquivos_externos/TimesPriority.txt", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(time + "\n");
			arq.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	//------ GETERS E SETERS-----//

	public int getQuantItens() {
		return quantItens;
	}

	public void setQuantItens(int quantItens) {
		this.quantItens = quantItens;
	}

}
