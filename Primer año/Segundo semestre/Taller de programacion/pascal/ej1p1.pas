program untitled;
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

Procedure random2(var num:integer);
begin
	Randomize;
	num:= 15;
	Random(num);
	num:= num + 1;
end;
	
procedure leer ( var regVentas: ventas ; var dimL: integer);
var
begin
	readl
	
Procedure leer (var regVentas:ventas; var dimL:integer);
var
	num:integer;
Begin
	 Readln(regVentas.dia); 
		Readln(regVentas.vendido);
		regVentas.codigo:= Random(15) + 1;
		dimL:= dimL + 1;
	end;
end; 

Procedure cargarVector(var v:vector; regVentas: ventas; i:integer);
begin
	v[i].dia := regVentas.dia;
	v[i].vendido := regVentas.vendido;
	v[i].codigo := regVentas.codigo;
end;
	

var
v:vector; regVentas:ventas;dimL,i:integer;

BEGIN
	dimL:= 0;
	Randomize;
	leer(regVentas,dimL);
	for i := 1 to dimL do begin
		cargarVector(v,regVentas,i);
		leer(regVentas,dimL);

	end;
	
END.

