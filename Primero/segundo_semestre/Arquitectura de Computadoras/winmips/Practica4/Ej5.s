	.data
cant:	.word 8
datos: 	.word 1, 2, 3, 4, 5, 6, 7, 8
res:	.word 0
	
	.code
	dadd	r1, r0, r0	;	r1 = 0
	ld 	r2, cant(r0)	;	r2 = dimF
loop:	ld	r3, datos(r1) 	; 	r3 = vector
	daddi	r2, r2, -1	; 	dec dimF
	dsll	r3, r3, 1	;	vec[x] * 2
	sd	r3, res(r1)	;	vec[x] = vec[x] * 2
	bnez 	r2, loop	;	mientras dimF>0 loop
	daddi	r1, r1, 8	; 	sig pos vec
	halt
 
; A- al habilitar la opción delay slot, se eliminan los atascos por BTB
; B- se incluye la instruccion nop para que el programa no finalize, ya que el delay slot hace que el programa salte luego de ejecutar la siguiente instrucción al salto, 
; si no estuviese el nop, se ejecutaria el halt y el programa terminaria.
; C- 88 ciclos 59 instrucciones cpi 1.49
; D- 94 ciclos 51 instrucciones cpi 1.84
	