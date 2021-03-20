class Cidadao():
    def __init__(self, cpf, classe, prioridade, idade):
        self.cpf = cpf
        self.classe = classe
        self.prioridade = prioridade
        self.idade = idade
    
    def definirClasse(self, index):
        if index == 1:
            self.classe = 'saude'
        elif index == 2:
            self.classe = 'idoso'
        else:
            self.classe = 'outros'
    
    def definirPrioridade(self, idade, classe):

        if idade >= 60:
            self.prioridade = "Importante"
        
        elif idade >= 60 and classe == 'saude':
            self.prioridade = "Alta A++"

        elif idade > 18 and classe == 'saude' :
            self.prioridade = "Alta"

        elif idade > 18 and classe == 'outros':
            self.prioridade = "Baixa"

    
    def imprimeDados(self):
        print(f'Dados de CPF: {self.cpf}, classe: {self.classe}, prioridade: {self.prioridade}, idade: {self.idade}')