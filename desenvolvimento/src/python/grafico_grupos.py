import matplotlib.pyplot as plt
import numpy as np
import scipy.optimize as opt

vetor_quant_testes = [30,60,100,130,160,200,230,260,300,330,360,400]
vetor_tempos_grafico_grupos = []
vetor_tempos_grafico_idades = []
vetor_desvio_padrao_grupos = []
vetor_desvio_padrao_idades = []
i = 0
j = 0


with open("src/arquivos_externos/Tempo_grupos.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempos_grafico_grupos.append(auxiliar)

with open("src/arquivos_externos/desvio_padrao_grupo.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_desvio_padrao_grupos.append(auxiliar)

with open("src/arquivos_externos/desvio_padrao_tempo.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_desvio_padrao_idades.append(auxiliar)

with open("src/arquivos_externos/TimesPriority.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempos_grafico_idades.append(auxiliar)


def funcao_linear(n, cpu):
    '''
    Aproximação linear
    :param n: tamanho da instância
    :param cpu: fator de conversão para tempo de CPU
    :return: aproximação
    '''
    return (n * cpu)


# Visualizar gráfico de médias móveis
def grafico():
    
    plt.style.use('seaborn')
    fig, ax = plt.subplots()
    plt.plot(vetor_quant_testes, vetor_tempos_grafico_idades, 'go', color='red')
    ax.errorbar(vetor_quant_testes, vetor_tempos_grafico_idades, vetor_desvio_padrao_idades, color='red', label="Tempo de processamento (idades)")
        
    plt.plot(vetor_quant_testes, vetor_tempos_grafico_grupos, 'go', color='blue') 
    ax.errorbar(vetor_quant_testes, vetor_tempos_grafico_grupos, vetor_desvio_padrao_grupos, color='blue', label="Tempo de processamento (grupos)")

    opt.curve_fit(funcao_linear(vetor_quant_testes, vetor_tempos_grafico_idades))

    plt.legend(loc="upper left")
    plt.xlabel('Tamanho das instancias (n)')
    plt.ylabel('Tempo em ms')
    plt.title('Tempo de processamento do algoritimo')
    
    plt.show()


grafico()