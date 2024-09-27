#!/bin/bash
# Este script recibe como parámetro el nombre de un archivo
# e informa si el mismo existe o no, en caso de existir
# indica si es un directorio o un archivo. En caso de que
# no exista el archivo/directorio crea un directorio con el
# nombre recibido como parámetro

# Compruebo que se haya enviado el parámetro
if [ $# -ne 1 ]; then
  echo "Se requiere un parámetro"
  exit 1
fi

if [ -e $1 ];then
	if [ -d $1 ];then
		echo "Es un directorio"
	elif [ -f $1 ];then
		echo "Es un archivo"
	else
		echo "Existe y no es un archivo ni un directorio"
	fi
else
	echo "El archivo no existe"
	mkdir $1
fi
