program ejercicio4;
const
	valoralto = 'ZZZZ';
type
	reg_mae = record
		provincia:string[20];
		cant_alfabetizados:integer;
		cant_encuestados:integer;
	end;
	
	reg_det = record
		provincia:string[20];
		localidad:string[20];
		cant_alfabetizados:integer;
		cant_encuestados:integer;
	end;

	maestro = file of reg_mae;
	detalle = file of reg_det;
	
var
	mae:maestro; det:detalle; det2:detalle; regm:reg_mae; regd:reg_det; regd2:reg_det; min:reg_det;
	
	procedure cargarDetalles(var det:detalle; var det2:detalle; var regd:reg_det; var regd2:reg_det);
	begin
		rewrite(det);rewrite(det2);
		
		with regd do 
		begin
			provincia:= 'Buenos Aires';
			localidad:= 'San Isidro';
			cant_alfabetizados:= 5000;
			cant_encuestados:= 6000;
		end;
		write(det,regd);
		with regd do 
		begin
			provincia:= 'Cordoba';
			localidad:= 'Alta Gracia';
			cant_alfabetizados:= 3000;
			cant_encuestados:= 4000;
		end;
	    write(det,regd);
		with regd2 do 
		begin
			provincia:= 'Buenos Aires';
			localidad:= 'Tigre';
			cant_alfabetizados:= 3000;
			cant_encuestados:= 4000;
		end;
		write(det2,regd2);
		with regd2 do 
		begin
			provincia:= 'Santa fe';
			localidad:= 'Rafaela';
			cant_alfabetizados:= 3000;
			cant_encuestados:= 4000;
		end;
		write(det2,regd2);
		
		writeln('Archivos detalle cargados con exito');
		close(det); close(det2);
	end;
	
	procedure cargarMaestro(var mae:maestro; var regm:reg_mae);
	begin
		rewrite(mae);
		with regm do
		begin
			provincia:= 'Buenos Aires';
			cant_alfabetizados:= 1000;
			cant_encuestados:= 1500;
		end;
		write(mae,regm);
		with regm do
		begin
			provincia:= 'Catamarca';
			cant_alfabetizados:= 2000;
			cant_encuestados:= 2500;
		end;
		write(mae,regm);
		with regm do
		begin
			provincia:= 'Cordoba';
			cant_alfabetizados:= 3000;
			cant_encuestados:= 3500;
		end;
		write(mae,regm);
		with regm do
		begin
			provincia:= 'Santa fe';
			cant_alfabetizados:= 4000;
			cant_encuestados:= 4500;
		end;
		write(mae,regm);
		
		writeln('Archivo maestro cargado con exito');
		close(mae);
	end;
	
	procedure leer(var det:detalle; var regd:reg_det);
	begin
		if(not eof(det)) then
			read(det,regd)
		else
			regd.provincia:= valoralto;
	end;
	
	procedure minimo(var det:detalle; var det2:detalle; var regd:reg_det; var regd2:reg_det; var min:reg_det);
	begin
		if(regd.provincia <= regd2.provincia) then
		begin
			min:= regd;
			leer(det,regd);
		end
		else
		begin
			min:= regd2;
			leer(det2,regd2);
		end;
	end;
	
var prov:string[20]; 
BEGIN
	assign(mae,'maestro'); assign(det,'detalle'); assign(det2,'detalle2');
	
	// Se cargan los archivos
	cargarMaestro(mae,regm); cargarDetalles(det,det2,regd,regd2);
	writeln('----------------------------------------');
	reset(mae); reset(det); reset(det2);
	
	leer(det,regd); leer(det2,regd2);
	minimo(det,det2,regd,regd2,min);
	while(min.provincia <> valoralto) do
	begin
		// leo registros del archivo maestro hasta encontrar la provincia buscada
		read(mae,regm);
		while(regm.provincia <> min.provincia) do
			read(mae,regm);
		// Realizo un corte de control con la provincia actual
		writeln('Provincia:', min.provincia);
		prov:= min.provincia;
		while(min.provincia = prov) do
		begin
			regm.cant_alfabetizados:= regm.cant_alfabetizados + min.cant_alfabetizados;
			regm.cant_encuestados:= regm.cant_encuestados + min.cant_encuestados;
			minimo(det,det2,regd,regd2,min);
		end;
		writeln('Total alfabetizados en ',prov,':',regm.cant_alfabetizados);
		writeln('----------------------------------------');
		seek(mae,filepos(mae)-1);
		write(mae,regm);
	end;
	close(mae); close(det); close(det2);
END.

