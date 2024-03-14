program ejercicio2;
type
arch = file of integer;
procedure cargarArchivo(var arc_logico:arch);
var
	arc_nombre:String;
	num:integer;
begin
	writeln('Ingrese el nombre del archivo');
	read(arc_nombre);				{leo el nombre}
	assign(arc_logico, arc_nombre); {asigno el nombre}
	rewrite(arc_logico); 			{creo el archivo}
	writeln('Ingrese un numero');
	read(num);						{leo un numero}
	while(num <> 30000) do
	begin
		write(arc_logico,num); {escribo el num en el archivo}
		writeln('Ingrese un numero');
		read(num);
	end;
	close(arc_logico); {cierro el archivo}
end;

procedure recorrerArchivo(var arc_logico:arch;var cant:integer; var promedio:real);
var
	num,suma,cantTotal:integer;
begin
	cant:= 0; suma:= 0; cantTotal:= 0;
	reset(arc_logico);
	writeln('Lista de numeros: ');
	while not eof (arc_logico) do
	begin
		read(arc_logico,num);
		writeln('- ',num);
		suma:= suma + num;
		cantTotal:= cantTotal + 1;
		if (num<1500) then cant:= cant + 1;
	end;
	promedio:= suma/cantTotal;
	close(arc_logico);
end;

var 
	arc_logico:arch;
	cant:integer;
	promedio:real;
BEGIN
	cargarArchivo(arc_logico);
	recorrerArchivo(arc_logico,cant,promedio);
	writeln('La cantidad de numeros menores a 1500 es: ',cant);
	writeln('El promedio de todos los numeros es: ',promedio);
END.
