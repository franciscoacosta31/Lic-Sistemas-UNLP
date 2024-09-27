#!/bin/bash
# Este script recorre un arreglo e imprime solo los números
# pares y cuenta los numeros impares y los informa
# al finalizar el recorrido

array=(1 2 3 4 5 6 7 8 9 10)
impares=0

for elem in ${array[*]};do
  if (( elem  % 2 == 0 )); then
    echo $elem
  else
    ((impares++))
  fi
done

echo $impares

