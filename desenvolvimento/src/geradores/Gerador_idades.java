package geradores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Gerador_idades {
	
	/**
	 * Construtor vazio
	 */
	public Gerador_idades() {

	}


	/**
	 * 
	 * @return Lista de idades lids do arquivo de idades IBGE
	 */
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
	 * @param time tempo calculado na classe main
	 *
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
}
