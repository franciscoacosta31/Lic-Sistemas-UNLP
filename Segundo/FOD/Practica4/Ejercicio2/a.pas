program ej2;
const 
    M = ?;
type 
    alumno = record
        nomyape:string[50];
        dni:integer;
        legajo:string[15];
        anio:integer;
    end;

	nodo = record
	    cant_claves: integer;
        claves:array[1..M-1] of integer; { DNI }
        enlaces:array[1..M-1] of integer;
	    hijos:array[1..M] of integer;
	end;

    archivo_datos = file of alumno;
	archivo_indices = file of nodo;	
var
		arbolB: arbol;