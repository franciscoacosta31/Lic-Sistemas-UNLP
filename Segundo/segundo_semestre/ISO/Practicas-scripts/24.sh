#!/bin/bash
# Realiza la suma elemento a elemento de dos vectores y 
# lo imprime en pantalla

vector1=( 1 80 65 35 2 )
vector2=( 5 98 3 41 8 )

cantidad=${#vector1[*]}

for ((i=0; i<cantidad; i++));do
	echo "La suma de los elementos de la posicion $i de los vectores es de"$((${vector1[i]} + ${vector2[i]}))
done
