#!/bin/bash
# Este script solicita al usuario que ingrese dos numeros
# e imprime la multiplicacion, suma, resta y el mayor
echo "Introduzca dos numeros"
read num1 num2
echo "$num1 x $num2 =" $((num1*num2))
echo "$num1 + $num2 =" $((num1+num2))
echo "$num1 - $num2 =" $((num1-num2))
if [ $num1 -gt $num2 ]; then
  echo "$num1 es mayor a $num2"
else
  echo "$num2 es mayor a $num1"
fi
