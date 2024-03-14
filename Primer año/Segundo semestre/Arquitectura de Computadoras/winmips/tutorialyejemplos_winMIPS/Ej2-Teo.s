;++++++++++++++++++++++++++++++++
;+++    for I:=1 to 100 do    +++
;+++      A[i]:=B[i]+5;       +++
;+++        WINMIPS64         +++
;+ Arquitectura de Computadoras +
;++++++++++++++++++++++++++++++++

	.data
base_B:	.word	1,2,3,4,5,6,7,8,9,0
	.word	0,9,8,7,6,5,4,3,2,1
	.word	2,3,4,5,6,7,8,9,0,1
	.word	0,9,8,7,6,5,4,3,2,1
	.word	2,3,4,5,6,7,8,9,0,1
	.word	0,9,8,7,6,5,4,3,2,1
	.word	2,3,4,5,6,7,8,9,0,1
	.word	0,9,8,7,6,5,4,3,2,1
	.word	2,3,4,5,6,7,8,9,0,1
	.word	0,9,8,7,6,5,4,3,2,1
base_A:	.space	100
;18
	.text
 	DADDI	r2, r0, 1	; variable I = 1 (en R2)
        DADDI	r5, r0, 5	; R5 = 5
        DADDI	r10, r0, 101	; límite del FOR (en R10)
ciclo:	LD 	r1, base_B(r2)	; R1 = B[I]
        DADD	r1, r1, r5	; R1 = B[I] + 5
        SD	r1, base_A(r2)	; A[I] = R1
        DADDI	r2, r2, 1	; I = I + 1
        BNE	r2, r10, ciclo	; I != 101 => goto ciclo
	HALT	