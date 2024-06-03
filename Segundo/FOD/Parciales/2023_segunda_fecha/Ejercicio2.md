Árbol B+ orden 4 política de resolución de underflows a derecha.
+58, -403, +260, -550

                    4:0(240)1(403)2(500)3

0:(3)(45)(60)1  1:(240)(255)(360)2  2:(409)(420)3   3:(550)-1


+58: Intento insertar la clave 58 en el nodo 0, se produce overflow en un nodo terminal por lo que divido y promociono una copia de la clave del medio a la derecha (58). Al promocionar la copia 58 se produce overflow en el nodo 4, como es un nodo interno lo trato como un árbol B, asi que divido y promociono la clave del medio a la derecha (403).
L4,L0,E0,E5,E4,E6,E7.

                            7:4(403)6

        4:0(58)5(240)1                              6:2(500)3

0:(3)(45)5   5:(58)(60)1  1:(240)(255)(360)2  2:(409)(420)3   3:(550)-1


-403: No puedo eliminar la clave 403 porque no se encuentra en un nodo terminal (no existe en el archivo).
L7,L6,L2.


+260: Intento insertar la clave 260 en el nodo 1, se produce overflow en un nodo terminal, por lo que divido y promociono una copia de la clave del medio a la derecha (260).
L7,L4,L1,E1,E8,E4.

                                        7:4(403)6

                4:0(58)5(240)1(260)8                           6:2(500)3

0:(3)(45)5   5:(58)(60)1  1:(240)(255)8  8:(260)(360)2  2:(409)(420)3   3:(550)-1


-550: Intento eliminar la clave 550 del nodo 3, se produce underflow así que intento redistribuir con el hermano adyacente derecho, como no tiene, intento con el hermano adyacente izquierdo, no tiene el minimo de elementos asi que puedo redistribuir. 
Como el 500 no me sirve más como separador, subo una copia del 420.
L7,L6,L3,L2,E2,E3,E6.

                                        7:4(403)6

                4:0(58)5(240)1(260)8                        6:2(420)3

0:(3)(45)5   5:(58)(60)1  1:(240)(255)8  8:(260)(360)2  2:(409)3   3:(420)-1