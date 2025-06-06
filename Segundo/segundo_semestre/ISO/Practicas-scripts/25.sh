#!/bin/bash
# Este script agrega en un arreglo todos los nombres de los
# usuarios del sistema.
# Adicionalmente, ante los siguientes parametros:
# - "-b n": Retorna un elemento de la posicion n del arreglo
# si el mismo existe. Caso contrario, un mensaje de error
# "-l": Devuelve la longitud del arreglo
# "-i": Imprime todos los elementos del arreglo en pantalla

arreglo=()
 
arreglo=($(cat /etc/group | grep -w users | cut -d : -f4 | tr "," " "))

case $1 in
	-b)
		if [ ${#arreglo[*]} -ge $2 ];then
			echo ${arreglo[$2]}
		fi
		;;
	-l)
		echo ${#arreglo[*]}
		;;
	-i)
		echo ${arreglo[*]}
		;;
	*)
		echo "Opcion inválida"
	;;
esac
