# !/bin/bash
# Este script recibe dos numeros por parámetro y una
# operación a realizar e imprime el resultado

# Compruebo que se hayan enviado dos parámetros
if [ $# -ne 3 ]; then
  echo "Se requieren tres parámetros, dos números y una operación"
  exit 1
fi

# Asigno los parámetros a las variables
num1=$1
num2=$2
op=$3

# Realizo la operación correspondiente e imprimo
case $op in
  "*")
    echo "$num1 x $num2 =" $((num1*num2));;
  "+")
    echo "$num1 + $num2 =" $((num1+num2));;
  "-")
    echo "$num1 - $num2 =" $((num1-num2));;
  "/")
    echo "$num1 / $num2 =" $((num1/num2));;
  *)
    echo "Operación no válida, utilize +, -, '*', /"    
esac
