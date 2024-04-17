	.data
tabla:	.word 20, 1, 14, 3, 2, 58, 18, 7, 12, 11
num:	.word 7
long:	.word 10
	
	.code
	ld	r1, long(r0)	;	r1 = 10
	ld	r2, num(r0)	;	r2 = 7
	dadd	r3, r0, r0	; 	r3 = 0
	dadd	r10, r0, r0	;	r10 = 0
loop:	ld	r4, tabla(r3)	;	r4 = vector
	beq	r4, r2, listo	;	si vec[X] = 7 termina	
	daddi	r1, r1, -1	;	r1(contador) - 1
	daddi	r3, r3, 8	; 	avanza vector<
	bnez	r1, loop	; 	jnz seguir
	j	fin
listo:	daddi	r10, r0, 1	; 	si vec[x] = 7, r10 = 1
fin:	halt

; busca en el vector el valor 7 y finalizar el programa cuando se lo encuentre
; el resultado es 1 y queda guardado en el registro 10
; el BTB lo que hace es crear una tabla la cual guarda la ultima decision tomada de un salto (saltó/no saltó) y asume que va a hacer lo mismo en la proxima ejecución, lo cual ayuda a la hora de tener programas con muchos loops. Al activar esta opcion, siempre van a haber 4 atascos (2 por actualizar tabla y en la primera y la ultima iteracion)
;       ciclos | CPI | RAW | BTB 
; caso1   79    1.83   24    8
; caso2   75	1.74   24    4