#!/bin/bash
# Este script imprime en pantalla los nombres de los archivos que se encuentran
# en el directorio actual, intercambiando minúsculas por mayúsculas, además y
# viceversa, además de eliminar la letra a (minúscula o mayúscula)

for file in *; do
	if [ -f $file ]; then
		echo $file | tr -d 'aA' | tr 'a-z A-Z' 'A-Z a-z' 
	fi
done
