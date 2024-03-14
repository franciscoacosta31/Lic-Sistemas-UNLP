	.data
ctrl:	.word 0x10000
data:	.word 0x10008
error:  .asciiz "error"
cero:	.asciiz "cero"
uno:	.asciiz "uno"
dos:	.asciiz "dos"
tres:	.asciiz "tres"
cuatro:	.asciiz "cuatro"
cinco:	.asciiz "cinco"
seis:	.asciiz "seis"
siete:	.asciiz "siete"
ocho:	.asciiz "ocho"
nueve:	.asciiz "nueve"
	.code
	ld $a0, ctrl($0)
	ld $a1, data($0) 
	jal ingreso
	dadd $a3, $zero, $v0
	jal muestra
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

muestra:        daddi $t8, $t8, 8
                dmul $a3, $a3, $t8
                daddi $t7, $a3, cero
                sd $t7, 0($a1) 
                daddi $t2, $zero, 4
                sd $t2, 0($a0)
                jr $ra