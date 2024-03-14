.data
A: .word 1
B: .word 2

.code
ld r1,A(r0)
ld r2,B(r0)
sd r2,A(r0)
sd r1,B(r0)

; a)
; - sd r2, A(r0) genera el atasco
; - es un atasco RAW
; - CPI = (4+4+2)/4 = 2.5
; b)
; - no se presenta ningun atasco ahora porque al activar el forwarding, no se requiere el resultado de la operacion en ID, sino que se la pide cuando es necesaria. Además, el resultado se manda por un registro temporal a la mem de la siguiente inst (donde se lo requiere)
; - el color verde del registro indica que el dato ya se encuentra disponible en memoria
- CPI = (4 + 4 + 0)/4 = 2