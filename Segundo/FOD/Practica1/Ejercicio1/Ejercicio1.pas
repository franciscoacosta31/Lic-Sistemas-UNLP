program Ejercicio1;
type
arch = file of integer;
var 
	arc_logico:arch;
	arc_nombre:string;
	num:integer;
BEGIN
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
END.
