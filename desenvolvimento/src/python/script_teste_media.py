import matplotlib.pyplot as plt
import numpy as np

vetor_tempo = []

# mude nome do arquivo
with open("src/arquivos_externos/tempo_teste_600m.txt","r") as arquivo:
    for valor in arquivo:
        valor = valor.rstrip()
        auxiliar = float(valor)
        vetor_tempo.append(auxiliar)

media = (sum(vetor_tempo)/len(vetor_tempo))
desvio = np.std(vetor_tempo)

print("Media: ",media)
print("Desvio Padrao: ",desvio)