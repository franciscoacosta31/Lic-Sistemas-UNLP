.data
	T: .word 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	X: .word 5
	C: .word 0
	R: .word 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
.code
	ld r3,X(r0)	;	r3 = X
	ld r4,C(r0)	;	r4 = res
	dadd r11, r0, r0 ;	r11 = dimAr
	daddi r6,r0,10	;	r6 para recorrer arreglo
loop:	ld r1,T(r11)
	ld r2,R(r11)
	daddi r1,r1,-1		; resto para comparar bien
	slt r5,r1,r3    	; r5 = 1 si r1<= 5
	bnez r5, no		; salta si r5=1
	daddi r2,r0,1		; manda 1 al vector de ceros
	daddi r4, r4, 1		; SI ES MAYOR, aumenta res
	sd r2,R(r11)		; 
no:	daddi r6,r6,-1
 	daddi r11, r11, 8
 	bnez r6, loop
 	sd r4,C(r0)
	halt
	
	
; RECORRER VECTOR
; SI ES MENOR: no hace nada
; SI ES MAYOR: aumento RES y pongo 1 en el vector
; 196, 192, 182