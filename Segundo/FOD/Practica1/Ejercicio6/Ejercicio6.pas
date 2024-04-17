program Ejercicio6;
type
	celular = record
		codigo:integer;
		nombre:string;
		descripcion:string;
		marca:string;	
		precio:integer;
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
	writeln('- precio:',c.precio);
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
			readln(arc_texto,codigo,precio,marca);
			readln(arc_texto,stock,stockmin,descripcion);
			readln(arc_texto,nombre);
		end;
		writeln(c.descripcion);
		writeln(cadena);
		writeln(c.descripcion = cadena);
		if (c.descripcion = cadena) then 
		begin
			listar(c);
		end;
	end;
	close(arc_texto);
end;

procedure exportarBinario(var arc_logico:arch;var arc_texto_2:text);
var c:celular;
begin
	assign(arc_texto_2,'celulares.txt');
	rewrite(arc_texto_2);
	reset(arc_logico);
	while(not eof(arc_logico))do
	begin
		read(arc_logico,c);
		with c do begin
			writeln(arc_texto_2,codigo,' ',precio,marca);
			writeln(arc_texto_2,stock,' ',stockmin,descripcion);
			writeln(arc_texto_2,nombre);
		end;
	end;
	writeln('Archivo exportado con éxito');
	close(arc_texto_2);close(arc_logico);
end;

procedure leerTeclado(var c:celular);
begin
	writeln('Ingrese el codigo del celular');
	readln(c.codigo);
	writeln('Ingrese el precio');
	readln(c.precio);
	writeln('Ingrese la marca');
	readln(c.marca);
	writeln('Ingrese el stock disponible');
	readln(c.stock);
	writeln('Ingrese el stock minimo');
	readln(c.stockMin);
	writeln('Ingrese la descripcion');
	readln(c.descripcion);
	writeln('Ingrese el nombre');
	readln(c.nombre);
end;

procedure agregarAlFinal(var arc_logico:arch);
var ok:integer;c:celular;
begin
	ok:= 1;
	reset(arc_logico);
	seek(arc_logico,filesize(arc_logico));
	while(ok = 1) do
	begin
		leerTeclado(c);
		write(arc_logico,c);
		writeln('Ingrese 1 si quiere ingresar otro celular, sino ingrese 0');
		readln(ok);
	end;
	close(arc_logico);
end;

procedure modificarStock(var arc_logico:arch);
var c:celular; nombre:string; stock:integer;
begin
	reset(arc_logico);
	writeln('Ingrese el nombre del celular a modificar');
	readln(nombre);
	read(arc_logico,c);
	while(not eof(arc_logico)) and (c.nombre <> nombre) do
		read(arc_logico,c);
	if(c.nombre = nombre)then
	begin
		writeln('Ingrese el nuevo stock');
		readln(stock);
		c.stock:= stock;
		seek(arc_logico,filepos(arc_logico)-1);
		write(arc_logico,c);
		writeln('Stock actualizado');
	end
	else
		writeln('Celular no encontrado');
	close(arc_logico);
end;

procedure exportarSinStock(var arc_logico:arch;var arc_texto_3:text);
var c:celular;
begin
	reset(arc_logico);
	assign(arc_texto_3,'celularSinStock.txt');
	rewrite(arc_texto_3);
	while(not eof(arc_logico)) do
	begin
		read(arc_logico,c);
		if(c.stock = 0) then
		begin
			with c do begin
				writeln(arc_texto_3,codigo,' ',precio,marca);
				writeln(arc_texto_3,stock,' ',stockmin,descripcion);
				writeln(arc_texto_3,nombre);
				writeln('Celular '+nombre+' cargado con exito');
			end;
		end;
	end;
	close(arc_logico); close(arc_texto_3);
end;


var 
arc_texto:text;
arc_texto_2:text;
arc_texto_3:text;
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
		writeln('5 = Agregar mas celulares al final del archivo');
		writeln('6 = Modificar stock de un celular dado');
		writeln('7 = Exportar los celulares sin stock');
		writeln('8 = Finalizar programa');
		readln(opcion);
		case opcion of
			1: cargarArchivo(arc_logico,arc_texto);	
			2: listarMenor(arc_texto);
			3: listarCadena(arc_texto);
			4: exportarBinario(arc_logico,arc_texto_2);
			5: agregarAlFinal(arc_logico);
			6: modificarStock(arc_logico);
			7: exportarSinStock(arc_logico,arc_texto_3);
			8: ok:= false;
		end;
	end;
END.
