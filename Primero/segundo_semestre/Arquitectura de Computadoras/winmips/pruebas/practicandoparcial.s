.data 
CONTROL:	.word32 0x10000 
DATA: 		.word32 0x10008 
	.code 
 	ld $s6, CONTROL($0) ; $s6 = dirección de CONTROL 
 	ld $s7, DATA($0) ; $s7 = dirección de DATA 
 
	daddi $t0, $zero, 7 ; $t0 = 7 -> función 7: limpiar pantalla gráfica 
 	sd $t0, 0($s6) ; CONTROL recibe 7 y limpia la pantalla gráfica 
 
	daddi $t1, $0, 8 ; 8 = leer num 

	sd $t1, 0($s6)
 	lbu $s0, 0($s7) ; $s0 = valor de coordenada X
	sd $t1, 0($s6)
	lbu $s1, 0($s7) ; $s1 = valor de coordenada Y 
	sd $t1, 0($s6)
	lbu $s2, 0($s7)	; s2 = data + 0
	sd $t1, 0($s6)
	lbu $s3, 0($s7)	; s3 = data + 1
	sd $t1, 0($s6)
	lbu $s4, 0($s7)	; s4 = data + 2
	sd $t1, 0($s6)
 	lbu $s5, 0($s7) ; s5 = data + 3
	
 	sb $s0, 5($s7) ; DATA+5 recibe el valor de coordenada X 
 	sb $s1, 4($s7) ; DATA+4 recibe el valor de coordenada Y 
	sb $s2, 0($s7) ; R
	sb $s3, 1($s7) ; G	
	sb $s4, 2($s7) ; B
	sb $s5, 3($s7) ; A

 	daddi $t0, $zero, 5 ; $t0 = 5 -> función 5: salida gráfica 
 	sd $t0, 0($s6) ; CONTROL recibe 5 y produce el dibujo del punto 
 	halt 