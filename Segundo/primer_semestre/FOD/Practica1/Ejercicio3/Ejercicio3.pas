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

procedure cargarArchivo(var arc_logico:arch);
var
	nom:String;
	e:empleado;
begin
	writeln('Ingrese un nombre para el archivo');
	readln(nom);
	Assign(arc_logico,nom);
	rewrite(arc_logico);
	writeln('Ingrese el apellido');
	readln(e.apellido);
	while(e.apellido <> 'fin') do
	begin
		writeln('Ingrese el nombre');
		readln(e.nombre);
		writeln('Ingrese el numero de empleado');
		readln(e.numEmpleado); 
		writeln('Ingrese la edad');
		readln(e.edad);
		writeln('Ingrese el dni');
		readln(e.dni);
		write(arc_logico,e);
		writeln('Ingrese el apellido');
		readln(e.apellido);
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

procedure menu(var arc_logico:arch);
var
num:integer;
ok:boolean;
begin
	ok:= true;
	while (ok) do
	begin
		writeln('Ingrese la operacion a realizar');
		writeln('1 = Buscar un empleado');
		writeln('2 = Lista de empleados');
		writeln('3 = Lista de empleados proximo a jubilarse');
		writeln('4 = Cerrar programa');
		read(num);
		case num of
			1: buscar(arc_logico);
			2: listaCompleta(arc_logico);
			3: listaMayores(arc_logico);
			4: ok:= false
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

