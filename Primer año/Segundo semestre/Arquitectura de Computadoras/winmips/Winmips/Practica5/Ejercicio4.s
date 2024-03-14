	.data
peso:	.double 75.0
altura:	.double 1.75
imc:	.double 0.0
estado:	.double 0.0
unoo:	.double 18.5
doss:	.double 25.0
tress:	.double 30.0
uno:	.double 1.0
dos:	.double 2.0
tres:	.double 3.0
cuatro:	.double 4.0
	.code
	l.d 	f1, peso($0)
	l.d 	f2, altura($0)
	l.d 	f4, unoo($0)
	l.d 	f5, doss($0)
	l.d 	f6, tress($0)
	l.d	f7, uno($0)
	l.d	f8, dos($0)
	l.d	f9, tres($0)
	l.d	f10, cuatro($0)
	mul.d 	f3,f2,f2
	div.d	f3,f1,f3
	
	s.d 	f3,imc($0)

	c.lt.d 	f3, f4
	bc1f seg
	s.d 	f7, estado($0)
	j fin
seg:	c.lt.d f3, f5
	bc1f seg2
	s.d	f8, estado($0)
	j fin
seg2:	c.lt.d f3, f6
	bc1f seg3
	s.d 	f9, estado($0)
	j fin
seg3:   s.d 	f10, estado($0)
	
fin:	halt
		
	
	
	