#!/bin/bash
# Recibe como parámetro un directorio. Valida que exista, en caso de no existir
# termina con código 4. Si existe, cuenta poro separado la cantidad de archivos
# que en él se encuentran para los cuales el usuario que ejecuta tiene permiso
# de lectura y escritura, e informa dichos valores en pantalla. En caso de 
# encontrar subdirectorios, no los procesa y tampoco son tenidos en cuenta 
# para la suma a informar

# Si no se recibe un parámetro o el parámetro no es un directorio -> error 4
if [ $# -ne 1 ] || [ ! -d $1 ]; then
	echo "Error 4"
	exit 4
fi

countR=0
countW=0

for i in $1/*
do
	if [ -f $i ];then
		if [ -r $i ]; then
			countR=$((countR+1))
		fi
		if [ -w $i ]; then
			countW=$((countW+1))
		fi
	fi
done
echo "Cantidad de archivos con permisos de lectura = $countR"
echo "Cantidad de archivos con permisos de escritura = $countW"

