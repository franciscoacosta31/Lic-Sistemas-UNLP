.data 
coorX: 		.byte 0		 ; coordenada X de un punto 
coorY: 		.byte 0 		 ; coordenada Y de un punto 
color: 		.byte 0, 0, 0, 0	 ; color: máximo rojo + máximo azul => magenta 
CONTROL:	.word32 0x10000 
DATA: .word32 0x10008 
 
.text 
	lwu $s6, CONTROL($zero) ; $s6 = dirección de CONTROL 
	lwu $s7, DATA($zero) 	; $s7 = dirección de DATA
	daddi $t9, $0, color 
	daddi $t0, $zero, 7 	; $t0 = 7 -> función 7: limpiar pantalla gráfica 
	daddi $t1, $0, 8	; $t1 = leer num
	sd $t0, 0($s6)		; CONTROL recibe 7 y limpia la pantalla gráfica 

	sd $t1, 0($s6)		; mandar leer num 
	lbu $s0, 0($s7) 	; $s0 = valor de coordenada X 
	sb $s0, coorX($0) 
	
	sd $t1, 0($s6)
	lbu $s1, 0($s7) 	; $s1 = valor de coordenada Y 
	sb $s1, coorY($0) 	; DATA+4 recibe el valor de coordenada Y
	
	sd $t1, 0($s6)		 
	lbu $t2, 0($s7) 	
	sb $t2, 0($t9) 		;t2 = color + 0

	sd $t1, 0($s6)		 
	lbu $t3, 0($s7) 	
	sb $t3, 1($t9) 		;t3 = color + 1
	
	sd $t1, 0($s6)		 
	lbu $t4, 0($s7) 	
	sb $t4, 2($t9) 		;t4 = color + 2

	sd $t1, 0($s6)		
	lbu $t5, 0($s7) 
	sb $t5, 3($t9) 		;t5 = color + 3
	
	lbu $t7, coorX($0)
	lbu $t8, coorY($0)
	sb $t7, 5($s7)
	sb $t8, 4($s7)
	lwu $s2, color($zero) 	; $s2 = valor de color a pintar 
	sw $s2, 0($s7) 		; DATA recibe el valor del color a pintar 
	daddi $t6, $zero, 5 	; $t0 = 5 -> función 5: salida gráfica 
	sd $t6, 0($s6) 		; CONTROL recibe 5 y produce el dibujo del punto 
	halt 
