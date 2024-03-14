	.data 
ctrl:	.word 0x10000 
data: 	.word 0x10008 
cad:	.asciiz "..........."	
	.code 
	ld $t0, data($0) 
	ld $t1, ctrl($0)
	ld $t2, cad($0)
	daddi $t3, $0, 9   ; leer mensaje
	daddi $t4, $0, 0   ; desplazamiento
	daddi $t6, $0, 11  ; dimF
loop:	sd $t3, 0($t1)	   ; leo mensaje 
	ld $t5, 0($t0)	   ; cargo en $t5 lo leido 
	sd $t5,cad($t4)	   ; guardo en la cadena lo leido
	daddi $t4, $t4, 1  ; avanzo en la cadena
	daddi $t6, $t6, -1 ; resto 1 a dimF
	bnez $t6, loop     ; mientras dimF>0
	halt