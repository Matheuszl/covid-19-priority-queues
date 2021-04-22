import matplotlib.pyplot as plt

y = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
x = [0.017,0.039,0.044,0.011,0.004,0.068,
0.035,0.068,0.01,0.033,0.017,0.018,0.009,0.015,0.103,0.031]

plt.style.use('ggplot')
plt.title("Tempo de processamento de inserção do Binary Heap")
plt.xlabel('Quantidade de testes')
plt.ylabel('Tempo de execução em ms')
plt.plot(y, x)

plt.show()