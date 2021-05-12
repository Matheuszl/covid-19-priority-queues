import numpy as np
from numpy import log as ln
import matplotlib.pyplot as plt
import scipy.optimize as opt
import math

vetor_quant_testes = [0,30,60,100,130,160,200,230,260,300,330,360,400]
tamanho_quant_testes = len(vetor_quant_testes)
vetor_tempos_grafico_grupos = []
vetor_tempos_grafico_idades = []
vetor_desvio_padrao_grupos = []
vetor_desvio_padrao_idades = []
aproximados = []
auxiliar = []
i = 0
j = 0
intervalo = np.linspace(1, 0.35, tamanho_quant_testes)
intervalo_n = np.linspace(1, 400, tamanho_quant_testes)

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
with open("src/model/desv_padrao_idade.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_desvio_padrao_idades.append(auxiliar)

#ABRIR ARQUIVO MEDIA DOS TEMPOS DE PRIORIDADE POR IDADE
with open("src/model/tempo_idade.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempos_grafico_idades.append(auxiliar)

def funcao_Onlogn(n, cpu):
    '''
    Aproximação O(n log n)
    :param n: tamanho da instância
    :param cpu: fator de conversão para tempo de CPU
    :return: aproximação
    '''
    result_log = np.log(n)
    log_convertido = abs(result_log)
    print(log_convertido)
    return (n * result_log)


def executa_aproximacao_grupo():
    #realiza aproximação
    parametros, pcov = opt.curve_fit(
        funcao_Onlogn, xdata=intervalo_n, ydata=vetor_tempos_grafico_grupos)
    aproximados = [
        funcao_Onlogn( x, *parametros) for x in intervalo_n
        ]
    #aproximados.reverse()
    print("Array is :",aproximados)
    return aproximados





# Visualizar gráfico
def grafico():
        x_s = np.arange(0,400)
        ls = 'dotted'   
        plt.style.use('seaborn')
        fig, ax = plt.subplots()
        #plt.plot(vetor_quant_testes, executa_aproximacao_idade(),color='lightcoral', label="Aproximação O(n log n) por idade")
        plt.plot(intervalo_n, executa_aproximacao_grupo(),color='cornflowerblue', label="Aproximação O(n log n) por grupo")

        plt.plot(vetor_quant_testes, vetor_tempos_grafico_grupos, 'go', color='blue', label="Tempo de processamento (grupos)") 
        ax.errorbar(vetor_quant_testes, vetor_tempos_grafico_grupos, vetor_desvio_padrao_grupos,linestyle=ls, color='blue')

        

        plt.legend(loc="upper left")
        plt.xlabel('Tamanho das instancias (n) em milhares')
        plt.ylabel('Tempo em ms')
        plt.title('Analise do algoritimo Priority Queue - Binary Heap')
        plt.show()

grafico()