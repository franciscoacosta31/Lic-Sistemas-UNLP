		.data 
valor:		.word 10
result: 	.word 0
		.code 
		daddi $sp, $zero, 0x400  
		ld $a0, valor($zero) 
		jal   factorial 
		sd  $v0, result($zero) 
		halt 
factorial:	dadd $t0, $a0, $0        
		daddi $v0, $0, 1 
	
loop:		dmul $v0, $v0, $t0
		daddi $t0, $t0, -1
		bnez $t0, loop
		jr $ra
		