#!/bin/bash
# Muestra un menú con la selección de diversos scripts.
# Debe permanecer activo hasta que se seleccione salir

while true;do
	echo "MENU DE COMANDOS"
	echo "12: Calculadora"
	echo "13: Evaluar expresiones"
	echo "14: Renombrando archivos"
	echo "16: Reporte usuario archivo"
	echo "17: Imprimir archivos en directorio actual"
	echo "18: Verificador usuario logeado"
	echo "Ingrese la opción a ejecutar:"
	read option
	
	case $option in
		12)
			echo "1: calculadora básica"
			echo "2: calculadora con parámetros"
			echo "3: calculadora completa con parametros"
			echo "Seleccione una opción:"
			read option2
			case $option2 in
				1)
					./12A.sh;;
				2)
					echo "Ingrese dos números"
					read num1 num2
					./12B.sh $num1 $num2;;
				3)
					echo "Ingrese dos números y la operación a realizar, en caso de multiplicación, ingresar '*' entre comillas"
                                        read num3 num4 op1
					if [ $op1 = "'*'" ] || [ $op1 = '"*"' ]; then
						./12C.sh $num3 $num4 "*"
					else
                                        	./12C.sh $num3 $num4 $op1
					fi;;
			esac;;
		13)
		  echo "1: Visualizar números del 1 al 100"
		  echo "2: Listar, DondeEstoy y QuienEsta"
		  echo "3: Existe? es un directorio o archivo?"
		  read option3
		  case $option3 in
                                1)
                                        ./13a.sh;;
                                2)
                                        ./13b.sh;;
                                3)
                                        echo "Ingrese el nombre de un archivo/directorio"
					read op133
					./13c.sh $op133;;
                  esac;;
		  
		14)
			echo "Ingrese un directorio, una cadena de caracteres y la operación -a o -b"
			read direc cadena opp
			./14.sh $direc $cadena $opp;;
		16)
			echo "Ingrese una extensión"
			read op16
			./16.sh $op16;;
		17)
			./17.sh;;
		18)
			echo "Ingrese el nombre de usuario"
			read op18
			./18.sh $op18;;
		*)
			echo "Opción inválida";;
	esac
done	
