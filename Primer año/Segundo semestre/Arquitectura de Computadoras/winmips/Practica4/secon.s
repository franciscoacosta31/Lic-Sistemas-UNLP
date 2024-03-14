.data
A: .word 1
B: .word 2
C: .word 2
.code
	ld r6, A(r0)
	dadd r4, r0, r0
	daddi r3, r0, 2
	dadd r1, r0, r0
loop: 	ld r5, A(r4)
	daddi r4, r0, 8
	beqz r3, ultimo
	ld r2, A(r4)
	daddi r3, r3, -1
	bne r5, r2, loop
	daddi r1, r1, 2
	j loop
ultimo:	bne r6, r5, fin
	daddi r1, r1, 1
fin: halt
	