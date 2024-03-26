program Ejercicio5;
type
	celular = record
		codigo:integer;
		nombre:string;
		descripcion:string;
		marca:string;	
		precio:real;
		stockMin:integer;
		stock:integer;
	end;
	
	arch = file of celular;

procedure crearArchivo(var arc_logico:arch);
var nom:string;
begin
	writeln('Ingrese el nombre del archivo binario');
	readln(nom);
	assign(arc_logico,nom);
end;
	
procedure cargarArchivo(var arc_logico:arch; var arc_texto:Text);
var c:celular;	
begin
	crearArchivo(arc_logico);
	rewrite(arc_logico);
	reset(arc_texto);
	while (not eof (arc_texto))do
	begin
		with c do begin
			readln(arc_texto,codigo,precio,marca);
			readln(arc_texto,stock,stockMin,descripcion);
			readln(arc_texto,nombre);
		end;	
		write(arc_logico,c);
	end;
	writeln('Archivo cargado con exito');
	close(arc_logico); close(arc_texto);
end;

procedure listar(c:celular);
begin
	writeln('- nombre: ',c.nombre);
	writeln('- marca:',c.marca);
	writeln('- codigo:',c.codigo);
	writeln('- precio:',c.precio:0:2);
	writeln('- stock:',c.stock);
	writeln('- stockMin:',c.stockMin);
	writeln('- descripcion:',c.descripcion);
	writeln('---------------------------')
end;

procedure listarMenor(var arc_texto:text);
var c:celular;
begin
	reset(arc_texto);
	writeln('Lista de celulares con stock por debajo del minimo:');
	while(not eof(arc_texto))do
	begin
		with c do begin
			readln(arc_texto,codigo,precio,marca);
			readln(arc_texto,stock,stockmin,descripcion);
			readln(arc_texto,nombre);
		end;
		if (c.stock < c.stockmin) then listar(c);
	end;
	close(arc_texto);
end;

procedure listarCadena(var arc_texto:text);
var cadena,cadena2:string; c:celular;
begin
	writeln('Ingrese la descripcion del celular a buscar');
	cadena := ' ';
	readln(cadena2);
	cadena += cadena2;
	reset(arc_texto);
	writeln('Lista de celulares con dicha descripcion:');
	while(not eof(arc_texto))do
	begin
		with c do begin
			writeln('AAA');
			readln(arc_texto,codigo,precio,marca);
			readln(arc_texto,stock,stockmin,descripcion);
			readln(arc_texto,nombre);
		end;
		writeln(c.descripcion);
		writeln(cadena);
		writeln(c.descripcion = cadena);
		if (c.descripcion = cadena) then 
		begin
			writeln('BBBB');
			listar(c);
		end;
	end;
	close(arc_texto);
end;

procedure exportarBinario(var arc_logico:arch;var arc_texto_2:text);
var c:celular;
begin
	Assign(arc_texto_2,'celulares.txt');
	rewrite(arc_texto_2);
	reset(arc_logico);
	while(not eof(arc_logico))do
	begin
		read(arc_logico,c);
		with c do begin
			writeln(arc_texto_2,codigo,precio,marca);
			writeln(arc_texto_2,stock,stockmin,descripcion);
			writeln(arc_texto_2,'MODIFICADO');
		end;
	end;
	writeln('Archivo exportado con éxito');
	close(arc_texto_2);close(arc_logico);
end;

var 
arc_texto:text;
arc_texto_2:text;
arc_logico:arch;
ok:boolean;
opcion:integer;
BEGIN
	ok:= true;
	assign(arc_texto,'celulares.txt');
	while(ok) do
	begin
		writeln('Ingrese un numero:');
		writeln('1 = Crear un archivo binario con archivo txt');
		writeln('2 = Listar datos de celulares con stock menor al minimo');
		writeln('3 = Listar datos de celulares cuya descripcion contenga caracteres enviados por mi');
		writeln('4 = Exportar archivo binario a archivo txt');
		writeln('5 = Finalizar programa');
		readln(opcion);
		case opcion of
			1: cargarArchivo(arc_logico,arc_texto);	
			2: listarMenor(arc_texto);
			3: listarCadena(arc_texto);
			4: exportarBinario(arc_logico,arc_texto_2);
			5: ok:= false;
		end;
	end;
END.
