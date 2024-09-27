#!/bin/bash
# Implementa una función productoria que multiplica todos
# los números de un arreglo

num=(10 3 5 7 9 3 5 4)
total=1

productoria() {
  for elem in ${num[*]}; do
	total=$((total * elem))		  
  done
}

productoria

echo $total
