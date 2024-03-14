.data
A: .word 1
B: .word 3
V: .word 0, 0, 0 ;vector
C: .word 0; contador
.code
ld r2, B(r0)
ld r1, A(r0)
ld r3, C(r0)

loop:	daddi r2, r2, -1
	dsll r1, r1, 1
	sd r1,V(r3)
	daddi r3, r3, 8
	bnez r2, loop
	halt
; A
; - Los atascos de tipo raw se generaron porque el ID requiere los operandos para ver si se debe ejecutar el salto, los cuales todavia no fueron dados por la etapa ex
; de la instruccion anterior
; - El atasco branch se genera porque el programa cargo la instruccion incorrercta ya que tenia que saltar y siguió. Ademas re retrasa un ciclo más ya que hay un
;  atasco raw anterior.
; - CPI = (12 + 4 + 5)/12 = 1.75 
; B
; - los atascos raw los genera la instrucción dsll r1,r1,1 ya que r1 no tiene valor hasta que el primer ciclo complete la etapa WB, queda trabado en ID (un ciclo).
;  La instruccion bnez r2, loop tambien genera un atasco raw por el mismo motivo. En este caso se atrasa dos ciclos hasta conseguir el valor.
; - En este caso se atrasa tres ciclos cada atasco ya que se produjo un atasco por raw en la instruccion de arriba lo que genera que se retrase dos ciclos la 
; informacion que precisa el if para determinar que debe saltar
; - CPI = (12 + 4 + 9)/12 = 2.08 mas atascos que con forwarding.
; D- los valores de las posiciones del vector representan el primer valor de R1 pero multiplicado por 2 en cada pasada