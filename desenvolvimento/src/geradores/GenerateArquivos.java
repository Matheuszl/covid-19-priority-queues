package geradores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * Classe aonde se encontra todos os metodos que salvam os tempos de processamentos
 * e desvios padroes em txt.
 */
public class GenerateArquivos {
	/**
	 * Construtor vazio
	 */
	public GenerateArquivos() {

	}


	/**
	 * Metodo que le do arquivo txt idades-RS e trafere para dentro de um array
	 * @return Lista de idades lidas do arquivo de idades IBGE
	 */
	public static ArrayList<Integer> ler() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Integer idade = 0;

		try {
			BufferedReader buf = new BufferedReader(new FileReader("src/arquivos_externos/Idades-RS.txt"));
			String linha = "";

			while (true) {
				if (linha != null) {
					linha = buf.readLine();
					if (linha == null) {
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
	public static void saveTempoIdades(double time) {

		try {
			FileWriter arq = new FileWriter("src/arquivos_externos/tempo_idades.txt", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(time + "\n");
			arq.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void saveTempoGrupos(double time) {

		try {
			FileWriter arq = new FileWriter("src/arquivos_externos/tempo_grupos.txt", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(time + "\n");
			arq.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Salva no arquivo desvio_padrao_idade.txt os desvios padrao da priorização por idade
	 * @param time tempo priorização
	 */
	public static void saveDesvioIdade(double time) {

		try {
			FileWriter arq = new FileWriter("src/arquivos_externos/desvio_padrao_idade.txt", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(time + "\n");
			arq.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Salva no arquivo desvio_padrao_idade.txt os desvios padrao da priorização por grupos
	 * @param time tempo priorização
	 */
	public static void saveDesvioGrupo(double time) {

		try {
			FileWriter arq = new FileWriter("src/arquivos_externos/desvio_padrao_grupo.txt", true);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(time + "\n");
			arq.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

