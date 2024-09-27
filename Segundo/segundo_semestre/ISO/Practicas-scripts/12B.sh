#!/bin/bash
# Este script recibe dos numeros por parámetro e
# imprime la multiplicacion, suma, resta y el mayor

# Compruebo que se hayan enviado dos parámetros
if [ $# -ne 2 ]; then
  echo "Se requieren dos parámetros"
  exit 1
fi

# Asigno los parámetros a las variables
num1=$1
num2=$2

# Realizo las operaciones e imprimo los resultados
echo "$num1 x $num2 =" $((num1*num2))
echo "$num1 + $num2 =" $((num1+num2))
echo "$num1 - $num2 =" $((num1-num2))
if [ $num1 -gt $num2 ]; then
  echo "$num1 es mayor a $num2"
else
  echo "$num2 es mayor a $num1"
fi 
