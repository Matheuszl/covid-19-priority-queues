/**
* @author Matheus Zalamena de Lima
* @version 3.1
* @email matheus.zzalamena@gmail.com
*/
package domain;

/**
 * Classe pessoa que recebe 3 atributos, é instaanciado um objeto de Pessoa na
 * hora da entrada dos dados na fila.
 */
public class Pessoa {
	// atributos
	private String nome;
	private int idade;
	private int grupo;

	/**
	 * Construtor
	 */
	public Pessoa(String nome, int idade, int grupo) {
		this.nome = nome;
		this.idade = idade;
		this.grupo = grupo;
	}

	// ----- METODOS GETERS E SETERS -----
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	/**
	 * Apresentação dos dados formatados
	 */
	@Override
	public String toString() {
		return "Pessoa| nome:" + nome + ", idade:" + idade + ", Grupo: " + grupo;
	}
}
