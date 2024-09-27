#!/bin/bash
# Este script muestra en pantalla los numeros del 1 al 100
# y sus cuadrados

for ((i=1; i <= 100; i++));do
  echo "$i" $((i*i))
done
