#!/bin/bash
# Este script muestra al usuario 3 opciones de operaciones
# a realizar y devuelve un resultado en base a la opción 
# elegida

echo "Seleccione una opción:"
echo "1 = Listar"
echo "2 = DondeEstoy"
echo "3 = QuienEsta"
read option

case $option in
	1)
		ls;;
	2)
		pwd;;
	3) 
		users;;
	*)
		echo "Opción inválida";;
esac
