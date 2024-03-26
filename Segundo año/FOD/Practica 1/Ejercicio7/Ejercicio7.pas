program Ejercicio7;
type
	novela = record
		codigo:integer;
		precio:integer;
		genero:string;
		nombre:string;
	end;

arch = file of novela;

procedure crearArchivo(var arc_logico:arch; var arc_texto:text);
var 
	nom:string; n:novela;
begin
	writeln('Ingrese el nombre del archivo');
	readln(nom);
	assign(arc_logico,nom);
	rewrite(arc_logico);
	reset(arc_texto);
	while(not eof(arc_texto))do
	begin
		with n do 
		begin
			readln(arc_texto,codigo,precio,genero);
			readln(arc_texto,nombre);
		end;
		write(arc_logico,n);
	end;
	close(arc_logico); close(arc_texto);
end;

procedure agregarNovela(var arc_logico:arch);
var n:novela;
begin
	reset(arc_logico);
	seek(arc_logico,filesize(arc_logico));
	with n do
	begin
		writeln('Ingrese el codigo de la novela');
		readln(codigo);
		writeln('Ingrese el precio de la novela');
		readln(precio);
		writeln('Ingrese el genero de la novela');
		readln(genero);
		writeln('Ingrese el nombre de la novela ');
		readln(nombre);
	end;
	write(arc_logico,n);
	close(arc_logico);
end;

procedure modificarNovela(var arc_logico:arch);
var opcion:integer; n:novela;
	nomNovela:string;
	seguir:integer;
begin
	reset(arc_logico);
	seguir:= 1;
	while(seguir = 1)do
	begin
		writeln('Ingrese el nombre de la novela a modificar');
		readln(nomNovela);
		// busco la novela
		if(not eof(arc_logico)) then read(arc_logico,n);
		while(not eof(arc_logico)) and (n.nombre <> nomNovela) do 
			read(arc_logico,n);
		if (n.nombre = nomNovela) then
		begin
			writeln('Indique el campo a modificar');
			writeln('1 = codigo');
			writeln('2 = precio');
			writeln('3 = genero');
			writeln('4 = nombre');
			readln(opcion);
			writeln('Ingrese el nuevo valor');
			case opcion of
				1: readln(n.codigo);
				2: readln(n.precio);
				3: readln(n.genero);
				4: readln(n.nombre);
			end;
			seek(arc_logico,filesize(arc_logico)-1);
			write(arc_logico,n);
			writeln('Modificacion realizada con exito');
			writeln('Si desea realizar otra modificacion ingrese 1, sino ingrese 0');
			readln(seguir);
			if (seguir = 1) then seek(arc_logico,0);
		end
		else
			writeln('La novela '+nomNovela+' no se encuentra en el archivo');
	end;	
	close(arc_logico);
end;

procedure menu(var arc_logico:arch);
var opcion:integer; ok:boolean;
begin
	ok:= true;
	while(ok) do
	begin
		writeln('Ingrese la operacion a realizar');
		writeln('1 = Agregar una novela');
		writeln('2 = Modificar una novela');
		writeln('3 = Finalizar');
		readln(opcion);
		case opcion of
			1: agregarNovela(arc_logico);
			2: modificarNovela(arc_logico);
			3: ok:= false;
		end;
	end;
end;

var 
arc_logico:arch;
arc_texto:text;
BEGIN
	Assign(arc_texto,'novelas.txt');
	crearArchivo(arc_logico,arc_texto);
	menu(arc_logico);
END.

