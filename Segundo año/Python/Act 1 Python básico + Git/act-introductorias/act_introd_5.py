lista = input("Ingrese una lista de numeros separadas por espacios:").split()
lista = [int(n) for n in lista]
for elem in lista:
    if elem >= 0:
        print(elem, end="-")
    else:
        break