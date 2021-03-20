from cidadao import Cidadao
from fila import Fila
import random

fila = Fila()

''' 
    #s/p sem prioridade definida ainda
    #Cadastro de 100 pessoas
'''
for i in range(100):
    c1 = Cidadao(random.randint(1000,5000), "saude","s/p", random.randint(18,100))
    c1.definirPrioridade(c1.idade, c1.classe)
    fila.insert(c1)


for i in range(100):
    c2 = fila.retornaDadosItem(i)
    c2.imprimeDados()
    arquivo = open('teste.txt','a')
    arquivo.write(str(f'CPF: {c2.cpf}, Classe: {c2.classe}, Prioridade: {c2.prioridade}, Idade: {c2.idade}') + '\n')