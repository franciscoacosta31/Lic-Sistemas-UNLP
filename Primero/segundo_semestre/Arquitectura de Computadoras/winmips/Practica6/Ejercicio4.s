	.data
ctrl:	.word 0x10000
data: 	.word 0x10008
cad:	.asciiz "...."
clave: 	.asciiz "hola"
bien:	.asciiz "bienvenido"
error:	.asciiz "error"
	.code
	ld $a0, ctrl($0)
	ld $a1, data($0)
	

	daddi $t0, $0, 4	; t0= cant interaciones
	daddi $a3, $0, 0	; a3= desplazamiento
loop:	jal char		; llama 4 veces a la subrutina ingresar
	daddi $t0, $t0, -1
	daddi $a3, $a3, 1
	bnez $t0, loop

	jal res
	halt
char:	daddi  $t1, $0, 9	;t0= leer caracter
	sd $t1, 0($a0)		 
	lbu $t2, 0($a1)		;$t1= caracter leido
	sb $t2, cad($a3)
	jr $ra

res:	daddi $t3, $0, 4	;$t0=	cant iteraciones 
	daddi $t8,$0,0		;$t1= 	desplazamiento
loop2:	daddi $t4, $t8, cad 	;$t2=	cadena
	daddi $t5, $t8, clave	;t3=	clave
	lbu $t0,0($t4)
	lbu $t1,0($t5)
	beq $t0, $t1, seguir
	j no	
seguir: daddi $t3, $t3, -1
	daddi $t8, $t8, 1
	bnez $t3, loop2

	daddi $t7,$0,bien
	j fin
no:	daddi $t7, $0, error
fin:	sd $t7, 0($a1)
	daddi $t6, $0, 4	;$t4 = imprimir cadena
	sd $t6, 0($a0) 	
	jr $ra

