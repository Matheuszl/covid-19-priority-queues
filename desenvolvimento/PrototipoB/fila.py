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

    '''
        retorna dados cadastrados na fila
    '''
    def retornaDadosItem(self, index):
            item = self.itens[index]
            return item