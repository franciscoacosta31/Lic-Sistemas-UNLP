lista = [1,2,3,4,5,6,7,8,9,10]
lista_pares = []
lista_impares = []

for elem in lista:
    if elem % 2 == 0:
        lista_pares.append(elem)
    else:
        lista_impares.append(elem)
print("Lista pares:")
for elem in lista_pares:
    print(elem,end="-")
print("\nLista impares: ")
for elem in lista_impares:
    print(elem,end="-")