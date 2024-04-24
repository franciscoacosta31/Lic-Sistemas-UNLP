.data
cadena:	.asciiz "adbdcdedfdgdhdid"
car:	.asciiz "d"
cant:	.word 0

.code
	dadd r5,r0,r0   ;     r5 recorre cad
	lbu r1, car(r0)	;	r1=d
	ld r2, cant(r0) ; 	r2=cant	

loop:	lbu r3,cadena(r5)
	bne r1,r3, nosuma
	daddi r2, r2, 1	
nosuma: daddi r5, r5, 1
	bnez r3, loop

	sd r2,cant(r0)
	halt	