import matplotlib.pyplot as plt

y = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
x = [0.038,0.01,0.006,0.039,0.018,0.014,0.055,0.039,0.009,0.047,0.02,0.014,0.062,0.039,0.01,0.017,0.011,
0.012,0.039,0.02,0.013,0.012,0.011,0.016,0.046,0.018,0.037,0.084,0.019,0.119]

plt.style.use('ggplot')
plt.title("Tempo de processamento de priorização do Binary Heap")
plt.xlabel('Quantidade de testes')
plt.ylabel('Tempo de execução em ms')
plt.plot(y, x)

plt.show()



