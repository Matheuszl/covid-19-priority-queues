import numpy as np
import matplotlib.pyplot as plt

vetor_quant_testes = [0,30,60,100,130,160,200,230,260,300,330,360,400]
tamanho_quant_testes = len(vetor_quant_testes)
vetor_tempos_grafico_grupos = []
vetor_tempos_grafico_idades = []
vetor_desvio_padrao_grupos = []
vetor_desvio_padrao_idades = []
i = 0
j = 0

#ABRIR ARQUIVO MEDIA DOS TEMPOS DE PRIORIDADE POR GRUPOS
with open("C:/Users/matza/Desktop/Vacina/vacina-prioritaria/src/model/tempo_grupo.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempos_grafico_grupos.append(auxiliar)

#ABRIR ARQUIVO desvio padrao DOS TEMPOS DE PRIORIDADE POR GRUPOS
with open("C:/Users/matza/Desktop/Vacina/vacina-prioritaria/src/model/desv_padrao_grupo.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_desvio_padrao_grupos.append(auxiliar)

#ABRIR ARQUIVO desvio padrao DOS TEMPOS DE PRIORIDADE POR IDADES
with open("C:/Users/matza/Desktop/Vacina/vacina-prioritaria/src/model/desv_padrao_idade.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_desvio_padrao_idades.append(auxiliar)

#ABRIR ARQUIVO MEDIA DOS TEMPOS DE PRIORIDADE POR IDADE
with open("C:/Users/matza/Desktop/Vacina/vacina-prioritaria/src/model/tempo_idade.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempos_grafico_idades.append(auxiliar)



# Visualizar gráfico
def grafico():
        x = np.linspace(0, 0.35, tamanho_quant_testes)
        plt.style.use('seaborn')
        fig, ax = plt.subplots()

        plt.plot(vetor_quant_testes, vetor_tempos_grafico_idades, 'go', color='red')
        ax.errorbar(vetor_quant_testes, vetor_tempos_grafico_idades, vetor_desvio_padrao_idades, color='red', label="Tempo de processamento (idades)")
        plt.plot(vetor_quant_testes, vetor_tempos_grafico_grupos, 'go', color='blue') 
        ax.errorbar(vetor_quant_testes, vetor_tempos_grafico_grupos, vetor_desvio_padrao_grupos, color='blue', label="Tempo de processamento (grupos)")

        plt.plot(vetor_quant_testes, x , 'b--', color='green', label="O(n log n)")

        plt.legend(loc="upper left")
        plt.xlabel('Tamanho das instancias (n)')
        plt.ylabel('Tempo em ms')
        plt.title('Analise do algoritimo Priority Queue - Binary Heap')
        plt.show()

grafico()