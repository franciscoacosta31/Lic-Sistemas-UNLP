#!/bin/bash
# Recibe un nombre de usuario y verifica cada 10
# segundos si se ha logueado en el sistema. Cuando
# se loguee, muestra un mensaje

if [ $# -ne 1 ]; then
	echo "Ingrese el nombre de usuario"
	exit 1
fi

while true;do
	if who | grep -q "^$1 "; then
		echo "Usuario $1 logueado en el sistema"
		exit 0
	fi
	sleep 10
done
