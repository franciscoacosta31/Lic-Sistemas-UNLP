lista = input("Ingrese una lista de numeros separada por espacios:").split()
lista = [int(n) for n in lista]

cadena = ""

for elem in lista:
    if not elem % 3 == 0:
        cadena += (f'-{elem}')
        
print(cadena)