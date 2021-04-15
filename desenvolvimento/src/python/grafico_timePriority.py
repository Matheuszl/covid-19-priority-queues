#Importando o pyplot
import matplotlib.pyplot as plt

#Sapararai por 5 grupos 0-20, 20-35, 35-50, 50-60, 60-100
grupos = ['0 a 20', '20 a 35', '35 a 50', ' 50 e 60', '60 e 100' ]
valores = [21947, 14322, 12517, 5230, 5989]

fig1, ax1 = plt.subplots()

explode = (0, 0, 0, 0, 0)  # only "explode" the 2nd slice (i.e. 'Hogs')
ax1.pie(valores, explode=explode, labels=grupos, autopct='%1.1f%%',
        shadow=True, startangle=90)
ax1.axis('equal')  # Equal aspect ratio ensures that pie is drawn as a circle.


plt.show()