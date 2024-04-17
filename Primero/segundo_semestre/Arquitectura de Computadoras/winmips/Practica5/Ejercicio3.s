	.data
b: 	.double 5.85
h:	.double 13.47
res:	.double 0.0
	.code
	l.d f1, b($0)
	l.d f2, h($0)
	
	mul.d f3, f1, f2

	daddi r2,$0,2
	mtc1 r2,f4
	cvt.d.l f4,f4

	div.d f3,f3,f4
	s.d f3, res($0)
	halt
