/* Version information   3.0
 *
 * Date                  03/05/2021
 *
 * author                Matheus Zalamena de Lima
 * email								 matheus.zzalamena@gmail.com
 * Copyright             MIT
 */
package principal;

import java.util.ArrayList;
import geradores.Generate;
import geradores.GenerateArquivos;

public class APA {
	//variaveis de escopo global
	static GenerateArquivos gerador;
	static ArrayList<Integer> idades;
	static ArrayList<Double> TEMPOS = new ArrayList<Double>();
	static double SOMA = 0;
	static double MEDIA = 0;
	static int QUANT_LOOPING = 15;

	public static void main(String[] args) {
		for (int i = 0; i < QUANT_LOOPING; i++) {
			priority();
		}

		//salva dados calculados nos arquivos txt
		GenerateArquivos.saveDesvioIdade(calculoDesvio());
		GenerateArquivos.saveTempoIdades(MEDIA);
		System.out.println("Finish");
	}

	public static void priority() {
		//Arraylist contendo todas idades
		ArrayList<Integer> lista = GenerateArquivos.ler();
		//instancia da fila prioritaria
		FilaPessoa fila = new FilaPessoa(10);
		//FilaGrupos filaGrupo = new FilaGrupos(10);
		int i = 0;
		int setGrupo = 0;

		for(int j=0;j<lista.size();j++){
			int getIdade = lista.get(i);
			
			if(getIdade <= 94 && getIdade >= 65){
				setGrupo = 5;
			}else if (getIdade <= 64 && getIdade >= 45){
				setGrupo = 4;
			}else if (getIdade <= 44 && getIdade >= 25){
				setGrupo = 3;
			}else if (getIdade <= 24 && getIdade >= 18){
				setGrupo = 2;
			}else if (getIdade <= 17 && getIdade >= 0){
				setGrupo = 1;
			}

			Pessoa pessoa = new Pessoa("Pessoa ", getIdade, setGrupo);
			
			fila.enfileirar(pessoa);
			//filaGrupo.enfileirar(pessoa);
			j++;
		}

		//Salva tempo inicial da priorizacao
		long init = System.currentTimeMillis();
		for(int j=0;j<lista.size();j++){
			fila.desenfileirar();
			j++;
		}
		//Salva tempo final da priorizacao
		long finish = System.currentTimeMillis();
		//Formata em ms o tempo de processamento
		double time = (finish - init) / 1000d;

		calculoMedia(time);
	}


	/**
	 * Calcula a media e salva em um array de medias
	 * depois esse array é usado novamente para o calculo do desvio padrao
	 */
	public static void calculoMedia(double time){
		SOMA = SOMA + time;
		MEDIA = SOMA/QUANT_LOOPING;
		TEMPOS.add(MEDIA);
	}

	/**
	 * Calculo do desvio padrao e logo após salva no arquivo txt alem de salvar a media tambem
	 */
	public static double calculoDesvio(){
		double somaNumeros = 0;
	
		for (int i = 0; i < QUANT_LOOPING; i++) {
			somaNumeros += Math.pow(MEDIA - TEMPOS.get(i), 2);
		}

		double resultado = somaNumeros / TEMPOS.size();
		double desvioPadrao = Math.sqrt(resultado);

		System.out.println("finish desvio/media");

		return desvioPadrao;
	}
}