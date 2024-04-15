program ejercicio5;
const
	valoralto = 9999;
	cantDetalles = 3;
type
	indice = 1..cantDetalles;
	reg_mae = record
		cod:integer;
		nom:string;
		desc:string;
		stock:integer;
		stock_min:integer;
		precio:real;
	end;
	
	reg_det = record
		cod:integer;
		cant_vendida:integer;
	end;
	
	
	maestro = file of reg_mae;
	detalle = file of reg_det;

	vector = record
		arch:detalle;
		reg:reg_det;
	end;

	vecDetalles = array [1..cantDetalles] of vector;

var 
	mae:maestro; v:vecDetalles;

	procedure crearMaestro(var mae:maestro);
	var carga:text; reg:reg_mae;
	begin
		assign(carga,'maestro.txt');
		assign(mae,'maestro');
		reset(carga);
		rewrite(mae);
		while(not eof(carga))do
		begin
			with reg do
			begin
				readln(carga,cod,stock,stock_min,precio,nom);
				readln(carga,desc);
			end;
			write(mae,reg);
		end;
		close(carga); close(mae);
	end;

	procedure crearDetalle(var det:detalle);
	var 
		carga:text; reg:reg_det; nom:string;
	begin
		writeln('Ingrese la ruta del detalle');
		readln(nom);
		assign(carga,nom);
		reset(carga);
		writeln('Ingrese el nombre del detalle');
		readln(nom);
		assign(det,nom);
		rewrite(det);
		while(not eof(carga))do
		begin
			with reg do readln(carga,cod,cant_vendida);
			write(det,reg);
		end;
		close(det); close(carga);
	end;

	procedure crearDetalles(var v:vecDetalles);
	var i:indice;
	begin
		for i:= 1 to cantDetalles do
			crearDetalle(v[i].arch);
	end;

	procedure leer(var det:detalle; var reg:reg_det);
	begin
		if(not eof(det)) then
			read(det,reg)
		else
			reg.cod:= valoralto;
	end;


	procedure minimo(var v:vecDetalles; var min:reg_det);
	var i:indice; pos:integer;
	begin
		min.cod:= valoralto;
		for i:= 1 to cantDetalles do
		begin	
			if(v[i].reg.cod < min.cod) then
			begin
				min:= v[i].reg;
				pos:= i;
			end; 
		end;
		if (min.cod <> valoralto) then
			leer(v[pos].arch,v[pos].reg);
	end;

	procedure imprimirTXT(var imprimir:text;regm:reg_mae);
	begin
		with regm do
		begin
			writeln(imprimir,nom,' ',desc,' ',stock,' ',precio:0:2);
			writeln(nom,' ',desc,' ',stock,' ',precio:0:2)
		end;
	end;

	procedure actualizarStock(var mae:maestro; var v:vecDetalles);
	var i:indice; regm:reg_mae; min:reg_det; imprimir:text;
	begin
		// creo el archivo detalle
		assign(imprimir,'imprimir.txt'); rewrite(imprimir);
		reset(mae);
		for i:= 1 to cantDetalles do
		begin
			reset(v[i].arch);
			leer(v[i].arch,v[i].reg);
		end;
		minimo(v,min);
		while(min.cod <> valoralto) do
		begin
			read(mae,regm);
			while(regm.cod <> min.cod) do
				read(mae,regm);
			while(min.cod = regm.cod) do
			begin
				regm.stock:= regm.stock - min.cant_vendida;
				minimo(v,min);
			end;
			if(regm.stock < regm.stock_min) then
				imprimirTXT(imprimir,regm);
			seek(mae,filepos(mae)-1);
			write(mae,regm);
		end;
		for i:= 1 to cantDetalles do close(v[i].arch);
		close(mae); close(imprimir);
	end;

BEGIN
	crearMaestro(mae);
	writeln('archivo maestro cargado');
	crearDetalles(v);
	writeln('archivos detalle cargados');
	actualizarStock(mae,v);
	writeln('programa terminado');
END.