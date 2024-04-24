	.data
n1:	.double 9.13
n2:	.double 6.58
res1:	.double 0.0
res2:	.double 0.0

	.code
	l.d	f1, n1(r0)
	l.d	f2, n2(r0)
	nop
	add.d	f3, f2, f1
	mul.d 	f1, f2, f1
	mul.d	f4, f2, f1
	s.d	f3,res1(r0)
	s.d	f4,res2(r0)
	halt
; a) ciclos:16 instrucciones:7 cpi:2.286
; b) 4 atascos por dependencia de datos, en sd f3 y en sd f4
; c) el atasco estructural se generó porque ambas instrucciones de s.d quieren acceder a mem a la misma vez que la instrucción add y mul respectivamente.
; d) aparece un atasco de tipo war ya que la instrucción mul.d f1, f2, f1 quiere modificar el registro f1 el cual es leido en la instrucción anterior, lo que podria generar problemas.
; e) se elimina el raw ya que cuando llega la instrucción add, los registros ya se encuentran con los datos cargados y se elimina el war ya que para cuando la instrucion mul.d llegó al id, el add ya leyó f2
