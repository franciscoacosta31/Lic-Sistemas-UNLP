.data
	A: .word 2
	B: .word 4
	C: .word 0

.code
	ld r1,A(r0) 	;	A = 2
	ld r2,B(r0) 	; 	B = 4
	dadd r3, r0, r0
	

loop:	beqz r2, fin	;
	daddi r2,r2,-1	;	
	j loop
	dadd r3,r3,r1
fin:	sd r3,C(r0)
	halt	
