program ejercicio3;
type
	empleado = record
		numEmpleado:integer;
		apellido:string;
		nombre:string;
		edad:integer;
		dni:integer;
	end;
	arch = file of empleado;

procedure leerEmpleado(var e:empleado);
begin
	writeln('Ingrese el apellido');
	readln(e.apellido);
	if(e.apellido <> 'fin') then
	begin
		writeln('Ingrese el nombre');
		readln(e.nombre);
		writeln('Ingrese el numero de empleado');
		readln(e.numEmpleado); 
		writeln('Ingrese la edad');
		readln(e.edad);
		writeln('Ingrese el dni');
		readln(e.dni);
	end;
end;

procedure cargarArchivo(var arc_logico:arch);
var
	nom:String; e:empleado;
begin
	writeln('Ingrese un nombre para el archivo');
	readln(nom);
	Assign(arc_logico,nom);
	rewrite(arc_logico);
	leerEmpleado(e);
	while (e.apellido <> 'fin') do
	begin
		write(arc_logico,e);
		leerEmpleado(e);
	end;
	close(arc_logico);
end;

procedure imprimirEmpleado(e:empleado);
begin
	writeln(
	' Numero: '	 ,e.numEmpleado,
	' Nombre: '	 ,e.nombre,
	' Apellido: ' ,e.apellido,
	' Edad: '	 ,e.edad,
	' DNI: '		 ,e.dni
	)
end;

procedure buscar(var arc_logico:arch);
var
nom:string;
e:empleado;
begin
	reset(arc_logico);
	writeln('Ingrese un nombre o apellido');
	readln(nom);
	while not eof(arc_logico) do
	begin
		read(arc_logico,e);
		if ((e.nombre = nom) or (e.apellido = nom)) then
			imprimirEmpleado(e)
	end;
	close(arc_logico);
end;

procedure listaCompleta(var arc_logico:arch);
var
e:empleado;
begin
	reset(arc_logico);
	writeln('Lista completa de empleados: ');
	while not eof(arc_logico) do
	begin
		read(arc_logico,e);
		imprimirEmpleado(e);
	end;
	close(arc_logico);
end;

procedure listaMayores(var arc_logico:arch);
var
e:empleado;
begin
	reset(arc_logico);
	writeln('Lista de empleados a punto de jubilarse');
	while not eof(arc_logico) do
	begin
		read(arc_logico,e);
		if(e.edad > 70) then
			imprimirEmpleado(e);
	end;
	close(arc_logico);
end;

procedure aniadirAlFinal(var arc_logico:arch);
var e:empleado;
begin
	reset(arc_logico);
	leerEmpleado(e);
	seek(arc_logico,filesize(arc_logico));
	while(e.apellido <> 'fin') do
	begin
		write(arc_logico,e);
		leerEmpleado(e);
	end;
	close(arc_logico);
end;

procedure modificarEdad(var arc_logico:arch);
var edadd,dnii:integer; e:empleado;
begin
	reset(arc_logico);
	writeln('Ingrese el dni del empleado');
	readln(dnii);
	read(arc_logico,e);
	while (not eof(arc_logico)) and (e.dni <> dnii) do
	begin
		read(arc_logico,e);
	end;
	if (e.dni = dnii) then
	begin
		writeln('Ingrese la edad del empleado');
		readln(edadd);
		e.edad := edadd;
		Seek(arc_logico, filepos(arc_logico)-1 );
		write(arc_logico,e);
	end
	else
		writeln('No existe empleado con ese DNI');
	close(arc_logico);
end;

procedure exportarATexto(var arc_logico:arch; var arc_texto:text);
var e:empleado;
begin
	assign(arc_texto,'todos_empleados.txt');
	reset(arc_logico);
	rewrite(arc_texto);
	while(not eof(arc_logico)) do
	begin
		read(arc_logico,e);
		with e do
			writeln(arc_texto,' ',numEmpleado,' ',apellido,' ',nombre,' ',edad,' ',dni);
	end;
	writeln('Archivos agregados con exito');
	close(arc_logico);
	close(arc_texto);
end;

procedure exportarDNI(var arc_logico:arch;var arc_texto_2:text);
var	e:empleado;
begin
	assign(arc_texto_2,'faltaDNIEmpleado.txt');
	rewrite(arc_texto_2);
	reset(arc_logico);
	while (not eof(arc_logico)) do
	begin
		read(arc_logico,e);
		if (e.dni = 00) then
		begin
			with e do 
				writeln(arc_texto_2,numEmpleado,' ',apellido,' ',nombre,' ',edad,' ',dni);
		end;
	end;
	close(arc_logico); close(arc_texto_2);
end;

procedure menu(var arc_logico:arch);
var
num:integer;
ok:boolean;
arc_texto:text;
arc_texto_2:text;
begin
	ok:= true;
	while (ok) do
	begin
		writeln('Ingrese la operacion a realizar');
		writeln('1 = Buscar un empleado');
		writeln('2 = Lista de empleados');
		writeln('3 = Lista de empleados proximo a jubilarse');
		writeln('4 = Aniadir uno o mas empleados al final');
		writeln('5 = Modificar edad de uno o mas empleados');
		writeln('6 = Exportar contenido a archivo txt de todos los empleados');
		writeln('7 = Exportar a un archivo faltaDNIEmpleado');
		writeln('8 = Cerrar programa');
		read(num);
		case num of
			1: buscar(arc_logico);
			2: listaCompleta(arc_logico);
			3: listaMayores(arc_logico);
			4: aniadirAlFinal(arc_logico);
			5: modificarEdad(arc_logico);
			6: exportarATexto(arc_logico,arc_texto);
			7: exportarDNI(arc_logico,arc_texto_2);
			8: ok:= false
		else
			writeln('Opcion invalida');
		end;
	end;
end;

var 
	arc_logico:arch;
BEGIN
	cargarArchivo(arc_logico);
	menu(arc_logico);
END.
