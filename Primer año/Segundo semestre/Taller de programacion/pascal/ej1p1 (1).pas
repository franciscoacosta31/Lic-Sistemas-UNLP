program ej1;
const 
dimf = 50;
type
dias = 0..31;
codProducto = 1..15;
cantVendida = 0..99;

ventas = record	
	dia: dias;
	codigo: codProducto;
	vendido: cantVendida;
end;

vector = array [1..dimf] of ventas;


	
Procedure leer (var regVentas:ventas; var dimL:integer);
Begin
	 Readln(regVentas.dia);
	 if (regVentas.dia <> 0) then begin
		Readln(regVentas.vendido);
		regVentas.codigo:= Random(15) + 1;
	end;
end; 

Procedure cargarVector (var v:vector);
var
	regVentas:ventas; dimL:integer;
begin
	dimL:= 1;
	Randomize;
	leer(regVentas,dimL);
	while (regVentas.dia <> 0) and (dimL <= dimF) do begin
			v[dimL] := regVentas;
			leer(regVentas,dimL);
			dimL:=dimL+1;
	end;
end;


var
v:vector;

BEGIN
	cargarVector(v)

END.

