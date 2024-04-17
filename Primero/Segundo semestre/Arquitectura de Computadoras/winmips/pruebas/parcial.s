	.data
control:	.word 0x10000
data:		.word 0x10008
cad_msg:	.asciiz "Cadena con reemplazos: "
digi_msg:	.asciiz "Digitos convertidos a Dígito - 1: "
cadena:		.asciiz "3a?7eN 05 en1234a"
digitos:	.asciiz ""
	.code
	ld $s0, control($0)
	ld $s1, data($0)
	daddi $sp, $0, 0x400
	daddi $a0, $0, cadena
	daddi $a1, $0, digitos
	jal prcad
	daddi $a0, $0, cad_msg
	daddi $a1, $0, cadena
	jal imprimir
	daddi $a0, $0, digi_msg
	daddi $a1, $0, digitos
	jal imprimir
	halt

prcad:	daddi $sp, $sp, -8
	sd $ra, 0($sp)		;push $ra

	daddi $t1, $0, 17	;longitud cadena
	daddi $t0, $a0, 0	;Desplazamiento
	daddi $t2, $a1, 0	;dir cad dig
loop: 	lb $a2, 0($t0)
	jal es_dig
	beqz $v0, seguir
	jal ob_dig
	sb $v1, 0($t0)
	sb $v1, 0($t2)
	daddi $t2, $t2, 1

seguir: daddi $t0, $t0, 1
	daddi $t1, $t1, -1
	bnez $t1, loop

	ld $ra, 0($sp)		;pop $ra
	daddi $sp, $sp, 8
	
	jr $ra


es_dig:	slti $t3,$a2, 0x31
	bnez $t3,fin
	slti $t4,$a2, 0x3a
	beqz $t4, fin	
	daddi $v0, $0, 1
	j final
fin:	daddi $v0, $0, 0
final:	jr $ra

ob_dig:	daddi $v1, $a2, -1 
	jr $ra

imprimir: daddi $t5, $0, 4
	  sd $a0, 0($s1)
	  sd $t5, 0($s0)
	
	  sd $a1, 0($s1)
	  sd $t5, 0($s0)
	  jr $ra