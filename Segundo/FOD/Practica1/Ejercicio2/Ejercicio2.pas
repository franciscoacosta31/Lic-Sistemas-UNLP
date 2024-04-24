program ejercicio2;
type
arch = file of integer;

procedure AsignarArchivo(var arc_logico:arch);
var
	archivo:string;
begin
	writeln('Ingrese el nombre del archivo');
	readln(archivo);
	assign(arc_logico,archivo);
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
	AsignarArchivo(arc_logico);
	recorrerArchivo(arc_logico,cant,promedio);
	writeln('La cantidad de numeros menores a 1500 es: ',cant);
	writeln('El promedio de todos los numeros es: ',promedio);
END.
