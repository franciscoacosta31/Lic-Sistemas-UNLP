program Hello;
type

autos = record
    patente:string;
    anio:integer;
    marca:string;
    modelo:string;
end;

arbol = ^nodo;

nodo = record
    dato:autos;
    HI:arbol;
    HD:arbol;
end;

lista = ^nodo3;

nodo3 = record
    dato3:autos;
    sig:lista;
end;


arbol2 = ^nodo2;

nodo2 = record
    dato2:lista;
    marca:string;
    HI:arbol2;
    HD:arbol2;
end;


lista2 = ^nodo5;

nodo5 = record
	dato:autos;
	sig:lista2;
end;


procedure leer(var au:autos);
begin
    writeln('ingrese el anio de fabricacion');
    readln(au.anio);
    if (au.anio >= 2010) and (au.anio <= 2018) then begin         
        writeln('ingrese la patente del auto');
        readln(au.patente);
        writeln('ingrese la marca');
        readln(au.marca);
        writeln('ingrese el modelo');
        readln(au.modelo);
    end;
end;

procedure cargarArbol(var a:arbol;au:autos);
begin
    if (a = nil) then begin
    new (a); a^.dato:= au; a^.HI:= nil; a^.HD:= nil;
    end
    else if (au.patente <= a^.dato.patente) then cargarArbol(a^.HI,au)
    else cargarArbol(a^.HD,au);
end;

procedure crearLista(var L:lista;au:autos);
var
aux:lista;
begin
    new(aux); aux^.dato3:=au; aux^.sig:= nil;
    if (L = nil) then begin
        L:= aux;
    end
    else begin
        aux^.sig:= L;
        L:= aux;
    end;
end;


procedure buscarNodo(var a2:arbol2;var nodo:arbol2;au:autos);
begin
	if (a2 <> nil) then begin 
		if (a2^.marca = au.marca) then 
			nodo:= a2
		else 
			if (au.marca < a2^.marca) then 
				buscarNodo(a2^.HI,nodo,au)
			else 
				if (au.marca > a2^.marca) then
					buscarNodo(a2^.HD,nodo,au)
	end
	else begin
		new(a2); 
		a2^.HD:= nil; a2^.HI:=nil; 
		a2^.dato2:=nil;
		a2^.marca:= au.marca; 
		nodo:= a2;
	end;
end;

procedure imprimirlista(L:lista);
begin
    if (L <> nil) then begin
        writeln(L^.dato3.marca);
        imprimirlista(L^.sig);
    end;
end;

procedure imprimir(a2:arbol2);
begin
    if (a2 <> nil) then begin
        imprimirlista(a2^.dato2);
        imprimir(a2^.HI);
        imprimir(a2^.HD);
    end;
end;

procedure cargarArboles(var a:arbol; var a2:arbol2);
var
au:autos;
nodo:arbol2;
begin
	leer(au); nodo:= nil;
	if (au.anio >= 2010) and (au.anio <= 2018) then begin
		cargarArbol(a,au);
		buscarNodo(a2,nodo,au);
		if (a2 <> nil) then crearLista(a2^.dato2,au);
		cargarArboles(a,a2);
	end;
end;

procedure buscarMarca(a:arbol;marca:string;var cant:integer);
begin
	if (a <> nil) then begin
		if (a^.dato.marca = marca) then cant:= cant + 1;
		buscarMarca(a^.HI,marca,cant);
		buscarMarca(a^.HD,marca,cant);
	end;
end;

procedure contarLista(var L:lista;var cant2:integer);
begin
	if (L <> nil) then begin
		cant2:= cant2 + 1;
		if (L^.sig <> nil) then contarLista(L^.sig,cant2);
	end;
end;

procedure buscarMarca2(a2:arbol2;marca2:string; var cant2:integer);
begin
	if (a2 <> nil) then begin
		if (a2^.marca = marca2) then 
			contarLista(a2^.dato2,cant2)
		else if (a2^.marca < marca2) and (a2^.HD <> nil) then
			buscarMarca2(a2^.HD,marca2,cant2)
		else if (a2^.HI <> nil) then 
			buscarMarca2(a2^.HI,marca2,cant2);	
	end;
end;

procedure nuevoNodo(var a4:arbol4; var nodo4:arbol4; a:arbol);
begin
	if (

end;

procedure nuevaLista(a:arbol;);
var

begin
	if (a <> nil) then begin
		


	end;
end;

var
a:arbol;a2:arbol2; marca,marca2:string; cant,cant2:integer;
begin
    a:= nil; a2:= nil; cant:= 0; cant2:=0;
    {inciso a} cargarArboles(a,a2);
    {inciso b} writeln('ingrese una marca');readln(marca); buscarMarca(a,marca,cant); writeln('hay ',cant,' autos de esa marca');
    {inciso c} writeln('ingrese otra marca'); readln(marca2); buscarMarca2(a2,marca2,cant2); writeln ('hay ',cant,' autos de esa marca');
    {inciso d} 
    
    // imprimir(a2);
    





end.


