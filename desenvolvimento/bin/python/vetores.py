import matplotlib.pyplot as plt
import numpy as np

#VARIAVEIS
vetor_quant_testes = [30.000,60.000,120.000,200.000,400.000,
500.000,600.000,700.000, 800.000, 1000.000, 1200.000,2000.000]
#aux_vqt = len(vetor_quant_testes)
vetor_tempos_grafico = []
vetor_tempo_30 = []
vetor_tempo_60 = []
vetor_tempo_120 = []
vetor_tempo_200 = []
vetor_tempo_400 = []
vetor_tempo_500 = []
vetor_tempo_600 = []
vetor_tempo_700 = []
vetor_tempo_800 = []
vetor_tempo_1 = []
vetor_tempo_12 = []
vetor_tempo_2 = []
desvio_padrao = []
media_padrao = []
volatilidade = []
i = 0
j = 0

# Para arquivo de 30 mil objetos
with open("src/arquivos_externos/tempo_teste_30m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_30.append(auxiliar)

# Para arquivo de 60 mil objetos
with open("src/arquivos_externos/tempo_teste_60m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_60.append(auxiliar)

# Para arquivo de 120 mil objetos
with open("src/arquivos_externos/tempo_teste_120m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_120.append(auxiliar)

# Para arquivo de 200 mil objetos
with open("src/arquivos_externos/tempo_teste_200m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_200.append(auxiliar)

# Para arquivo de 400 mil objetos
with open("src/arquivos_externos/tempo_teste_400m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_400.append(auxiliar)

# Para arquivo de 500 mil objetos
with open("src/arquivos_externos/tempo_teste_500m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_500.append(auxiliar)

# Para arquivo de 600 mil objetos
with open("src/arquivos_externos/tempo_teste_600m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_600.append(auxiliar)

# Para arquivo de 700 mil objetos
with open("src/arquivos_externos/tempo_teste_700m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_700.append(auxiliar)

# Para arquivo de 800 mil objetos
with open("src/arquivos_externos/tempo_teste_800m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_800.append(auxiliar)

# Para arquivo de 2 milhos objetos
with open("src/arquivos_externos/tempo_teste_1mm.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_1.append(auxiliar)

# Para arquivo de 2 milhos objetos
with open("src/arquivos_externos/tempo_teste_12mm.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_12.append(auxiliar)
    
# Para arquivo de 2 milhos objetos
with open("src/arquivos_externos/tempo_teste_2mm.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo_2.append(auxiliar)



media30 = (sum(vetor_tempo_30)/len(vetor_tempo_30))
vetor_tempos_grafico.append(media30)
desvio30 = np.std(vetor_tempo_30)
desvio_padrao.append(desvio30)

media60 =(sum(vetor_tempo_60)/len(vetor_tempo_60))
vetor_tempos_grafico.append(media60)
desvio60 = np.std(vetor_tempo_60)
desvio_padrao.append(desvio60)

media120 =(sum(vetor_tempo_120)/len(vetor_tempo_120))
vetor_tempos_grafico.append(media120)
desvio120 = np.std(vetor_tempo_120)
desvio_padrao.append(desvio120)

media200 =(sum(vetor_tempo_200)/len(vetor_tempo_200))
vetor_tempos_grafico.append(media200)
desvio200 = np.std(vetor_tempo_200)
desvio_padrao.append(desvio200)

media400 =(sum(vetor_tempo_400)/len(vetor_tempo_400))
vetor_tempos_grafico.append(media400)
desvio400 = np.std(vetor_tempo_400)
desvio_padrao.append(desvio400)

media500 =(sum(vetor_tempo_500)/len(vetor_tempo_500))
vetor_tempos_grafico.append(media500)
desvio500 = np.std(vetor_tempo_500)
desvio_padrao.append(desvio500)

media600 =(sum(vetor_tempo_600)/len(vetor_tempo_600))
vetor_tempos_grafico.append(media600)
desvio600 = np.std(vetor_tempo_600)
desvio_padrao.append(desvio600)

media700 =(sum(vetor_tempo_700)/len(vetor_tempo_700))
vetor_tempos_grafico.append(media700)
desvio700 = np.std(vetor_tempo_700)
desvio_padrao.append(desvio700)

media800 =(sum(vetor_tempo_800)/len(vetor_tempo_800))
vetor_tempos_grafico.append(media800)
desvio800 = np.std(vetor_tempo_800)
desvio_padrao.append(desvio800)

media1 =(sum(vetor_tempo_1)/len(vetor_tempo_1))
vetor_tempos_grafico.append(media1)
desvio1 = np.std(vetor_tempo_1)
desvio_padrao.append(desvio1)

media12 =(sum(vetor_tempo_12)/len(vetor_tempo_12))
vetor_tempos_grafico.append(media12)
desvio12 = np.std(vetor_tempo_12)
desvio_padrao.append(desvio12)

media2 =(sum(vetor_tempo_2)/len(vetor_tempo_2))
vetor_tempos_grafico.append(media2)
desvio2 = np.std(vetor_tempo_2)
desvio_padrao.append(desvio2)



quantidade_tempos = len(vetor_tempos_grafico)

print("Media 30: ", media30)
print("Media 60: ", media60)
print("Media 120: ", media120)
print("Media 200: ", media200)
print("Media 400: ", media400)
print("Media 500: ", media500)
print("Media 600: ", media600)
print("Media 700: ", media700)
print("Media 800: ", media800)
print("Media 1m: ", media1)
print("Media 1m200: ", media12)
print("Media 2m: ", media2)

'''
#vetor desvio desvio_padrao
while (j<len(vetor_tempos_grafico)):
    desvio = np.std(vetor_tempos_grafico)
    desvio_padrao.append(desvio)
    j +=1
'''

#vetor com a media de tempo
while (i<len(vetor_tempos_grafico)):
    media_grupo = sum(vetor_tempos_grafico) / quantidade_tempos
    media_padrao.append(media_grupo)
    i +=1



#media volatil
for i in range(quantidade_tempos):
    if i+1 >= quantidade_tempos:
        break
    aux = (vetor_tempos_grafico[i] + vetor_tempos_grafico[i+1])/2
    volatilidade.append(aux)
    i += 1

'''
for mv in volatilidade:
    print(mv)
'''


# Visualizar gráfico de médias móveis
def grafico():
    plt.style.use('seaborn')
    plt.plot(vetor_quant_testes, vetor_tempos_grafico, 'go', color='blue') # green bolinha
    plt.plot(vetor_quant_testes, vetor_tempos_grafico, color='blue', label="Tempo de processamento")
    #plt.plot(vetor_quant_testes, media_padrao, 'go', color='green')
    #plt.plot(vetor_quant_testes, media_padrao, color='green', label='Media tempo')
    plt.plot(vetor_quant_testes, desvio_padrao, 'go', color='red' )
    plt.plot(vetor_quant_testes, desvio_padrao, color='red', label='Desvio padrao (n)')
    #plt.plot(aux_vqt, volatilidade, label='Volatilidade')
    plt.legend(loc="upper left")
    plt.xlabel('Tamanho das instancias (n)')
    plt.ylabel('Tempo em ms')
    plt.title('Tempo de processamento do algoritimo')
    
    plt.show()


grafico()