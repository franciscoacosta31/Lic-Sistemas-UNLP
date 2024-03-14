.data
	A: .word 3
	X: .word 5
	Y: .word 2
.code
	ld r1, A(r0)
	ld r3, Y(r0)
	ld r2, X(r0)
	
loop:	daddi r1, r1, -1
	bnez r1, loop
	dadd r2, r2, r3
	halt

; 23C 13I 1.76CPI
