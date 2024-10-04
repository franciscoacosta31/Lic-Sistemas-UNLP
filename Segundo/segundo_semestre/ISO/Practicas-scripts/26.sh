#!/bin/bash
# Recibe rutas absolutas de archivos o directorios (al menos una)
# Mientras itera sobre las mismas, en los parámetros en posiciones
# impares verifica si el archivo o directorio existe, imprimiendo
# en pantalla que tipo de objeto es (archivo o directorio) e 
# informa la cantidad de archivos o directorios inexistentes
# en el sistema.

if [ $# -lt 1 ]; then
  	echo "Se debe ingresar una ruta absoluta"
	exit 1
fi

i=1
inexistentes=0

for ruta in $*;do
  if (( i % 2 == 1 ));then
  	if [ -d $ruta ];then
      		echo "La ruta $ruta es un directorio"
	elif [ -f $ruta ]; then
		echo "La ruta $ruta es un archivo"
	else 
		echo "La ruta $ruta no existe"
		((inexistentes++))
	fi		
  fi
  ((i++))
done

echo "Se ingresaron $inexistentes rutas inexistentes"
