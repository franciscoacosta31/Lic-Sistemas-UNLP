#!/bin/bash
# Simula el comportamiento de una pila, operaciones: push, pop, lenght, print
# push: recibe un parametro y lo agrega a la pila
# pop: saca un elemento de la pila
# length: devuelve la longitud de la pila
# print: imprime todos los elementos de la pila

stack=()

while true;do
  echo
  echo "Ingrese la operación a realizar..."
  echo "1 = push: agregar a la pila"
  echo "2 = pop: sacar elemento de la pila"
  echo "3 = lenght: imprimir longitud de la pila"
  echo "4 = print: imprimir todos los elementos de la pila"
  echo "5 = Salir"
  read -p "Operación: " op
  case $op in
	  1)
		 echo "Ingrese un elemento"
		 read new
		 stack+=("$new")
		 echo "Elemento $new agregado con éxito";;
	  2)
		  unset stack[-1];;
	  3)
		  echo ${#stack[@]};;
	  4)
		  echo ${stack[@]};;
	  5)
		  exit 0;;
	  *)
		  echo "Opción invalida";;
  esac
done
