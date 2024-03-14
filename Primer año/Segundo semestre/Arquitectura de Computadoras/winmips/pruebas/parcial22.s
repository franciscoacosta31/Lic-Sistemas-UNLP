	.data
A:	.word 0
B: 	.word 0
C: 	.word 0
RES: 	.word 0
ctrl:	.word 0x10000
data: 	.word 0x10008
	.code
	ld $s0, ctrl($0)
	ld $s1, data($0)
	daddi $t0, $0, A
	
	daddi $t1, $0, 8
	daddi $t3, $0, 3
loop:	sd $t1, 0($s0)		; mando a ctrl leer
	ld $t2, 0($s1)		; tomo lo leido
	sd $t2, 0($t0)		; escribo en mem
	daddi $t0, $t0, 8	; paso a B luego a C
	daddi $t3, $t3, -1	; resto iteracion
	bnez $t3, loop

	ld $a0, A($0)		; a0 = A
	ld $a1, B($0)		; a1 = b
	ld $a2, C($0)		; a2 = c

	jal calcu

	sd $v0, RES($0)		; mando el resultado a res
	daddi $t6, $0, 2	; imprimir num
	sd $v0, 0($s1)
	sd $t6, 0($s0)	
	halt

calcu:	dsub $t4, $a0, $a1	; t4 = resta
	daddi $v0, $0, 1        ; v0 = t4
	dadd $t5, $0, $a2	; t5 = potencia
	beqz $a2, fin

bucle:	dmul $v0, $v0, $t4	; v0 = v0 x t4
	daddi $t5, $t5, -1	; resto 1 a la potencia
	bnez $t5, bucle		; hasta q sea 0
	j fin
	daddi $v0, $0, 1
fin:	jr $ra


