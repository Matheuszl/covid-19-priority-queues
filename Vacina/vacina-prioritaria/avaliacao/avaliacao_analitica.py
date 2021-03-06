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
intervalo = np.linspace(0, 0.35, tamanho_quant_testes)
intervalo_n = np.linspace(0, 400, tamanho_quant_testes)

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
    return (n * log_convertido)

def executa_aproximacao_idade():
    #realiza aproximação
    parametros, pcov = opt.curve_fit(
        funcao_Onlogn, xdata=vetor_quant_testes, ydata=vetor_tempos_grafico_idades)
    aproximados = [
        funcao_Onlogn(x, *parametros) for x in vetor_tempos_grafico_idades
        ]
    
    return aproximados

def executa_aproximacao_grupo():
    #realiza aproximação
    parametros, pcov = opt.curve_fit(
        funcao_Onlogn, xdata=vetor_quant_testes, ydata=vetor_tempos_grafico_grupos)
    aproximados = [
        funcao_Onlogn( x, *parametros) for x in intervalo
        ]
    aproximados.reverse()
    print("Array is :",aproximados)
    return aproximados





# Visualizar gráfico
def grafico():
        aproxGrupos = np.polyfit(vetor_quant_testes, vetor_tempos_grafico_grupos,2)
        aproxIdades = np.polyfit(vetor_quant_testes, vetor_tempos_grafico_idades,2)
        aprox_final_grupos = np.poly1d(aproxGrupos)
        aprox_final_idades = np.poly1d(aproxIdades)
        x_s = np.arange(0,400)
        ls = 'dotted'
        
        plt.style.use('seaborn')
        fig, ax = plt.subplots()
        #plt.plot(vetor_quant_testes, executa_aproximacao_idade(),color='lightcoral', label="Aproximação O(n log n) por idade")
        #plt.plot(vetor_quant_testes, executa_aproximacao_grupo(),color='cornflowerblue', label="Aproximação O(n log n) por grupo")
        #plt.plot(intervalo_n, intervalo , color='black', label='teste')
        #plt.plot(x_s,aprox_final_grupos(x_s),color='cornflowerblue', label='Aproximação O(n log n) por grupo')
        #plt.plot(x_s,aprox_final_idades(x_s),color="lightcoral", label='Aproximação O(n log n) por idade')
        plt.plot(vetor_quant_testes, vetor_tempos_grafico_idades, 'go', color='red', label="Tempo de processamento (idades)")
        ax.errorbar(vetor_quant_testes, vetor_tempos_grafico_idades, vetor_desvio_padrao_idades, color='red',label="Desvio padrao (idades)")
        plt.plot(vetor_quant_testes, vetor_tempos_grafico_grupos, 'go', color='blue', label="Tempo de processamento (grupos)") 
        ax.errorbar(vetor_quant_testes, vetor_tempos_grafico_grupos, vetor_desvio_padrao_grupos, color='blue',label="Desvio padrao (grupos)")

        #plt.plot(vetor_quant_testes, intervalo , 'b--', color='green', label="O(n log n)")

        plt.legend(loc="upper left")
        plt.xlabel('Tamanho das instancias (n) em milhares')
        plt.ylabel('Tempo em ms')
        plt.title('Analise do algoritimo Priority Queue - Binary Heap')
        plt.show()

grafico()