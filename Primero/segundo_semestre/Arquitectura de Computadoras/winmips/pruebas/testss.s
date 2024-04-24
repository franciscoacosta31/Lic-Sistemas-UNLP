	.code
	daddi $t0, $0, 8
loop:	daddi $t1, $t1,1 	
	daddi $t0, $t0, -1
	bnez $t0, loop
	halt