package domain;

public class Pessoa {
  
  private String nome;
	private int idade;
	private int grupo;
	
	
	

	public Pessoa(String nome, int idade, int grupo) {
		this.nome = nome;
		this.idade = idade;
		this.grupo = grupo;
	}

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



	@Override
	public String toString() {
		return "Pessoa| nome:" + nome + ", idade:" + idade+", Grupo: "+grupo;
	}

    

}
