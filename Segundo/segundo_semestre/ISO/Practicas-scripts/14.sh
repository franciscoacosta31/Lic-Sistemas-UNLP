#!/bin/bash
# Este script recibe como parámetro un directorio, una
# cadena de caracteres y una operación (-a o -b) y renombra
# los archivos en el directorio pasado como parámetro

# Compruebo que se reciban 3 parámetros
if [ $# -ne 3 ];then
	echo "Se deben ingresar 3 parámetros"
	exit 1
fi

cd $1
if [ $3 = "-a" ];then
	for file in *; do	
		mv --  "$file" "$2$file"
	done
elif [ $3 = "-b" ];then
	for file in *; do
		mv --  "$file" "$file$2"
	done
fi
