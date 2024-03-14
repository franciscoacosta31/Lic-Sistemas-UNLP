;++++++++++++++++++++++++++++++++++++++
;++ Buscar un elemento en un arreglo ++
;++ de enteros. El resultado en R10. ++
;++++           WINMIPS            ++++
;+++  Arquitectura de Computadoras  +++
;++++++++++++++++++++++++++++++++++++++
	.data
busca:	.word 7
vect:	.word 1,4,8,10,7
largo:	.word 5

	.text
	dadd R10,R0,R0	  ; registro R10 puesto en '0'
	dadd R1,R0,R0	  ; registro R1 elegido como indice
	ld   R2,largo(R0) ; calculamos la dimension de vect
	dsll R2,R2,3 	  ; multiplico R2 x 8
	ld   R3,busca(R0) ; elemento buscado
loop:	ld   R4,vect(R1)  ; elemento del vector a comparar
	beq  R3,R4,found  ; salgo de loop si son iguales
	daddi R1,R1,8    ; R1++ (8 bytes)
	slt  R5,R1,R2    ; comparo (resultado en R5)    
	bnez R5,loop     ; continuo el ciclo?
	j    end         ; el valor buscado no se encontró
found:	daddi R10,R0,1   ; Coloco TRUE 		
end:	halt             ; comando winmips de cierre


