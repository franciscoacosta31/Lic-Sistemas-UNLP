#!/bin/bash
# Este script implementa las siguientes funciones
# inicializar: Crea un arreglo llamado array vacio
# agregar_elem <parametro1>: Agrega al final del arreglo el
#  parametro recibido
# eliminar_elem <parametro1>: Elimina del arreglo el elemento
#  que se encuentra en la posicion recibida como parametro.
# longitud: Imprime la longitud del arreglo en pantalla
# imprimir: Imprime todos los elementos del arreglo en pantalla
# inicializar_Con_Valores <parametro1><parametro2>: Crea un 
#  arreglo con longitud <parametro1> y en todas las posiciones
#  asigna el valor <parametro2>

inicializar(){
	array=()
	echo "Se inicializó un arreglo vacío"
}

agregar_elem(){
	array+=("$1")
}

eliminar_elem(){
	if [ ${#array[*]} -ge $1 ];then
	      unset array[$1]
	      array=(${array[*]})	      
	else
		echo "Posición inválida"
	fi
}

longitud(){
	echo "El arreglo tiene ${#array[*]} elementos"
}

imprimir(){
	echo ${array[*]}
}

inicializar_Con_Valores(){
	array=()
	for ((i=0; i<$1; i++))do
		array+=("$2")
	done
}

select opcion in inicializar agregar_elem eliminar_elem longitud imprimir inicializar_Con_Valores salir
do
	case $opcion in
		"inicializar")
			inicializar;;
		"agregar_elem")
			echo "Ingrese el parámetro"
			read param
			agregar_elem $param;;
		"eliminar_elem")
			echo "Ingrese el parámetro"
			read param
			eliminar_elem $param;;
		"longitud")
			longitud;;
		"imprimir")
			imprimir;;
		"inicializar_Con_Valores")
			echo "Ingrese dos valores"
			read param1 param2
			inicializar_Con_Valores $param1 $param2;;
		"salir")
			exit 0;;
		*)
			echo "Opción inválido";;
	esac
done
