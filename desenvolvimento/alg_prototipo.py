class Fila():
    def __init__(self):
        self.itens = []

    def isEmpty(self):
        return self.itens == []
    
    def insert(self, item):
        self.itens.append(item)
    
    def remove(self):
        id_max = 0
        for i in range(1, len(self.itens)):
            if self.itens[i] > 60:
                id_max = i
            
        item = self.itens[id_max]
        self.itens[id_max: id_max+1] = []
        return item

prioritario = Fila()
normal = Fila()

n_prioritario = 0
n_normal = 0
n_idoso = 0
n_jovem = 0

while True :
    #Entrada de pessoas
    for x in range(5, 100):
        cidadao = x

        if cidadao < 0:
            print("Invalido!")
            continue

        if cidadao >= 60:
            n_idoso += 1
            n_prioritario += 1
            prioritario.insert(n_prioritario)
            
        elif cidadao > 0:
            n_jovem += 1
            n_normal += 1
            normal.insert(n_normal)
            
    else:
        break
print(f'N° de idosos: {n_idoso}')
print(f'N° de jovns: {n_jovem}')
print(f'-'*20)
print(f'Ordem da fila: ')

#Nesse momento unimos as duas filas aonde passamos como parametro q quantidade de idosos no laço de repetiçao
#simulando a atendimento dos prioritarios antes dos normais
while len(prioritario.itens) != 0 or len(normal.itens) != 0:
    cont = 0
    for n in range(n_idoso):
        if len(prioritario.itens) != 0:
            print("Atendimnto prioritario")
            print("P: ",prioritario.remove())
    
    if len(normal.itens) != 0:
        print("Atendimento normal!")
        print("N: ",normal.remove())
        