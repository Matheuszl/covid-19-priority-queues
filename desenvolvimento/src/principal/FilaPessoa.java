package principal;

import java.util.Arrays;

/**
 * Classe fila prioritaria
 * @author matza
 *
 */
public class FilaPessoa {
	
	//vetor de Pessoa aonde armazena os integrantes da fila
	private Pessoa[] fila;
	//index usado para percorrer a fila fazendo as operacoes
	private int ultima_possicao;
	
	/**
	 * Essa fila � implementada usando uma matriz, em seguida a fila de prioridade recebe
	 * um parametro de tamanho que inicializa o tamanho desta matriz.
	 * 
	 * a ultima possicao � inicializada com zero embora nao haja nenhum elemento ainda nesta fila
	 * 
	 * O algoritimo precisa ter duas opera�oes, troca pra cima e troca para baixo
	 * 
	 * A troca pra baixo pega o ultimo elemento da fila e o esloca para o superior
	 * 
	 * @param pilha
	 * @param ultima_possicao
	 */
	public FilaPessoa(Integer size) {
		this.fila = new Pessoa[size];
		this.ultima_possicao = 0;
	}
	
	
	
	/**
	 * Complexibilidade de 0(n) pra enfileirar
	 * @param Objeto pessoa com no minimo a (idade >0 e 120<)
	 */
	void enfileirar(Pessoa valor) {
		/**
		 * A ultima possicao que inicializa com 0 e soma +1 se compara com o tamanho da fila
		 * se o tamanho da fila for maior, ele insere o elemento na possicao disponivel, caso contrario
		 * ele cria uma 2 fila auxiliar, transferindo os dados, da A -> B dobrando seu tamanho.
		 * 
		 * Se a fila antes tinha 5 possisoes, agora ela vai ter 10 e assim vai aumentando seu tamanho
		 * 
		 * 
		 */
		if(ultima_possicao +1 > fila.length -1) {
			Pessoa[] auxFila = fila;
			fila = new Pessoa[auxFila.length * 2];
			
			for(int i=0; i<auxFila.length; i++) {
				fila[i] = auxFila[i];
			}
		}
		
		ultima_possicao++;
		fila[ultima_possicao] = valor;
		trocaSuperior();	
	}
	
	/**
	 * Complexibilidade de 0(1) pra desenfileirar
	 * @return
	 */
	Pessoa desenfileirar() {
		if(ultima_possicao <= 0) {
			return null;
		}
		/**
		 * fila[objto.idade]
		 */
		Pessoa valorRaiz = fila[1];
		troca(1, ultima_possicao);
		ultima_possicao--;
		trocaInferior();
		
		return valorRaiz;
	}
	
	/**		*
	 * 		*
	 * 	->	* TROCA
	 *  ->	*  
	 * desloca o �ltimo elemento da fila para cima
	 */
	private void trocaSuperior() {
		/**
		 * Enquanto a idade da pessoa no indice for maior que a do indexPai, troca possicao.
		 */
		int index = ultima_possicao;
		int indexPai = getPai(index);
		
		while(indexPai > 0 && fila[index].getIdade() > fila[indexPai].getIdade()) {
			troca(index, indexPai);
			index = indexPai;
			indexPai = getPai(indexPai);
		}
	}

	/**
	 *	 	 
	 *		*
	 * 		*
	 * 	->	* 
	 *  ->	* TROCA
	 * desloca o elemento raiz da fila para baixo
	 */
	private void trocaInferior() {
		int index = 1;
		
		while(index < ultima_possicao) {
			Pessoa pessoaMaior = fila[index];
			
			int indexMaior = index;
			
			int indexEsquerda = getFilhoEsquerda(index);
			if(indexEsquerda > 0 && pessoaMaior.getIdade() < fila[indexEsquerda].getIdade()) {
				pessoaMaior = fila[indexEsquerda];
				indexMaior = indexEsquerda;
			}
			
			int indexDireita = getFilhoDireita(index);
			if(indexDireita > 0 &&  pessoaMaior.getIdade() < fila[indexDireita].getIdade()) {
				pessoaMaior = fila[indexDireita];
				indexMaior = indexDireita;
			}
			
			if(indexMaior == index) {
				break;
			}
			troca(indexMaior, index);
			index = indexMaior;
		}
		
	}

	/**
	 * 
	 * @return Encontra o indice pai de do objeto
	 */
	private int getPai(int index) {
		if(index <= 1) return 0;
		return index/2;
	}
	
	/**
	 * 
	 * 	      Pai
	 *         |
	 *         |
	 *        / \
	 *       /   \
	 * Esquerda  Direita
	 *    /\       /\
	 *   /  \     /  \
	 * 
	 * @return O filho da esquerda do pai
	 */
	private int getFilhoEsquerda(int index) {
		int filhoDaEsquerda = index * 2;
		//Se o filho da esquerda for menor ou igual a ultima possicao, retorna index * 2, se nao retorna 0
		return filhoDaEsquerda <= ultima_possicao ? filhoDaEsquerda : 0;
	}
	
	/**
	 *        Pai
	 *         |
	 *        / \
	 *       /   \
	 * Esquerda |Direita|
	 * 
	 * 
	 * @param index
	 * @return O filho da direita do pai
	 */
	private int getFilhoDireita(int index) {
		int filhoDaDireita = index * 2 + 1;
		return filhoDaDireita <= ultima_possicao ? filhoDaDireita : 0;
	}
	
	/**
	 * [0,1,2,3,4]
	 * [0,1,2,3]
	 * [0,1,2]
	 * ...
	 * 
	 * Apos a implementa�ao ele vai diminuindo os indices
	 * @param indexA
	 * @param indexB
	 */
	private void troca(int indexA, int indexB) {
		Pessoa aux = fila[indexA];
		fila[indexA] = fila[indexB];
		fila[indexB] = aux;
		
	}



	@Override
	public String toString() {
		return "FilaPessoa [fila=" + Arrays.toString(fila) + "]";
	}
	
	

}
