	.data
cadmsg:		.asciiz	"Cadena con reemplazos: "
mayumsg:	.asciiz "Letras convertidas a mayuscul"
cadena:		.asciiz "Cadena MAYUminu"
mayu:		.asciiz "..............."
ctrl:	.word 0x10000
data:	.word 0x10008
	.code
	daddi $sp, $0, 0x400
	daddi $a0, $0, cadena
	daddi $a1, $0, mayu
	jal prcad
	daddi $a0, $0, cadmsg
	daddi $a1, $0, cadena
	jal imprim
	daddi $a0, $0, mayumsg
	daddi $a1, $0, mayu
	jal imprim
	halt

prcad:	daddi $sp, $sp, -8
	sd $ra, 0($sp)
	
	daddi $t0, $0, 15	;t0 = cant caract
loop:	lbu $a2, 0($a0)		; a2 = char
	jal esminu	
	beqz $v0, seguir	; salta si no es minu
	jal obten
	sb $v1, 0($a1)		; guardo mayu en mayu
	sb $v1, 0($a0)		; convierto a mayu
	daddi $a1, $a1, 1	; avanzo en mayu

seguir: daddi $t0, $t0, -1
	daddi $a0, $a0, 1 	;sig caracter
	bnez $t0, loop

	ld $ra, 0($sp)
	daddi $sp, $sp, 8
	jr $ra

esminu: slti $t1, $a2, 97
	bnez $t1, no
	slti $t1, $a2, 122
	beqz $t1, no
	daddi $v0, $0, 1
	j fin
no: 	daddi $v0, $0, 0
fin:	jr $ra

obten:	daddi $v1, $a2, -32
	jr $ra

imprim: ld $s0, ctrl($0)
	ld $s1, data($0)
	daddi $t2, $0, 4	; imprimir asciiz
	sd $a0, 0($s1)		; mando mensaje
	sd $t2, 0($s0)		; imprimo
	sd $a1, 0($s1)		; mando cadena
	sd $t2, 0($s0)		; imprimo
	jr $ra
	  