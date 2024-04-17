	.data
num:	.word 7
num2:	.word 5
	.code
	ld $s1, num($0)
	ld $s2, num2($0)
	dadd $s3,$s1,$s2
	halt