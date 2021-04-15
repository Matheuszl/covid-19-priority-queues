/* Version information   2.0
 *
 * Date                  13/04/2021
 *
 * author                Matheus Zalamena de Lima
 * Copyright notice      MIT
 */
package principal;

import java.util.ArrayList;
import geradores.GenerateArquivos;

public class APA {
		
	static GenerateArquivos gerador;
	static ArrayList<Integer> idades;

	public static void main(String[] args) {
		priority();
			
	}

	public static void priority() {

		ArrayList<Integer> lista = GenerateArquivos.ler();
		FilaPessoa fila = new FilaPessoa(10);
		

		int i = 0;
		for (@SuppressWarnings("unused") Integer idade : lista) {
			Pessoa pessoa = new Pessoa("Pessoa ", lista.get(i));
			fila.enfileirar(pessoa);
			i++;
		}
		
		long init = System.currentTimeMillis();
		for (@SuppressWarnings("unused") Integer idade : lista) {
			Pessoa saida = fila.desenfileirar();
			System.out.println(saida.toString());
			i++;
		}
		long finish = System.currentTimeMillis();
		
		
		GenerateArquivos.saveTime(((finish - init) / 1000d));
		
		System.out.println("Finish");

	}

}
