program ejercicio1;
Const 
    M = ?;
type
    alumno = record
        nomyape:string[50];
        dni:integer;
        legajo:string[15];
        anio:integer;
    end;

    nodo = record
        cant_claves:integer;
        claves: array[1..M] of alumno;
        hijos: array[1..M] of integer;
    end;

    arbol = file of nodo;

var
    arbolB:arbol;