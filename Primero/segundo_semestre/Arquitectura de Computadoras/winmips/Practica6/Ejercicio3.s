	.data
ctrl:	.word 0x10000
data:	.word 0x10008
	.code
	ld $a0, ctrl($0)
	ld $a1, data($0)
	jal ingreso
	dadd $v1, $v0, $0
	jal ingreso
	jal res
	halt

ingreso: daddi $t0, $0, 8    ;ingresar caracter
	 sd $t0, 0($a0)
	 ld $t3, 0($a1)
         slti $t1, $t3, 10
	 bnez $t1, fin
         daddi $v0, $0, -1
         jr $ra     
fin: dadd $v0,$t3,$0	 
	 jr $ra	

res: 	dadd $t1,$v0,$v1
	sd $t1, 0($a1)
	daddi $t0, $0, 2
	sd $t0, 0($a0)
	jr $ra