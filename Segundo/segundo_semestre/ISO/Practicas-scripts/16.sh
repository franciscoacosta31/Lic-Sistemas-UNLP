#!/bin/bash
# Este script recibe como parámetro una extensión y realiza 
# un reporte con dos columnas, el nombre de usuario y la 
# cantidad de archivos que posee con esa extensión. 
# Guardando el resultado en un archivo llamado reporte.txt

# Comprobar que se reciba el parámetro
if [ $# -ne 1 ]; then
	echo "Se debe ingresar un parámetro"
	exit 1
fi

echo \n > reporte.txt

echo -e "Usuario\tCantidad de Archivos" > reporte.txt

# Iterar sobre los usuarios del sistema
for linea in $(cat /etc/passwd | cut -d: -f 1,6); do
	user=$(echo $linea | cut -d: -f1)
	home=$(echo $linea | cut -d: -f2)
	
	# Contabiliza solo si el usuario tiene un directorio personal
	if [ -d $home ]; then
		cantidad=$(find $home -name "*.$1" | wc -l)
	fi
	if [ $cantidad -gt 0 ]; then
		echo "$user $cantidad" >> reporte.txt
	fi


done

echo "Reporte generado en reporte.txt"
