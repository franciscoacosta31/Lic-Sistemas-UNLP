program untitled;
const
	dimF = 10;
type

vector = array [1..dimF] of char;

lista = ^nodo;

nodo = record
	dato:char;
	sig:lista;
end;


Procedure cargarVector(var v:vector;var dimL:integer);
var
car:char;
begin
	readln(car);
	if (car <> '.') and (dimL < dimF)then begin
		dimL:= dimL + 1;
		v[dimL] := car;
		cargarVector(v,dimL);
    end;
end;

Procedure imprimir(v:vector;dimL:integer);
var
i: integer;
begin
	for i:= 1 to dimL do begin
		writeln(v[i]);
	end;
end;

Procedure imprimirR(v:vector;dimL:integer;i:integer);
begin
	if (i <= dimL) then begin
		writeln(v[i]);		
		imprimirR(v,dimL,i+1);
	end;
end;

Procedure incisoD(var cant:integer);
var
car:char;
begin
	readln(car);
	if (car <> '.') then begin
		cant:=cant+1;
		incisoD(cant);
	end;
end;

Procedure agregarAtras(var L,ULT:lista;car:char);
var
nuevo:lista;
begin
	new(nuevo); nuevo^.dato:=car;nuevo^.sig:=nil;
	if (L = nil) then begin
		L:=nuevo;
		ULT:=nuevo;
	end
	else begin
		ULT^.sig:=nuevo;
		ULT:=nuevo;
	end;
end;


Procedure crearLista (var L:lista;ULT:lista);
var
car:char;
begin
	read(car);
	if (car <> '.') then begin
		agregarAtras(L,ULT,car);
		crearLista(L,ULT);
	end;
end;

Procedure imprimirLista(L:lista);
begin
	if (L <> nil) then begin
		write(L^.dato);
		imprimirLista(L^.sig);
	end;
end;

Procedure imprimirInverso(L:lista);
begin
	if (L <> nil) then begin
		imprimirInverso(L^.sig);
		write(L^.dato);
	end;
end;

var	
v:vector; L,ULT:lista;
dimL,i,cant:integer;
BEGIN
	L:=nil; ULT:=nil;
	cant:=0;
	dimL:=0;
	i:=1;
	cargarVector(v,dimL);
	imprimir(v,dimL);
	imprimirR(v,dimL,i);
	incisoD(cant); writeln(cant);
	crearLista(L,ULT);
	imprimirLista(L);
	imprimirInverso(L);
END.

