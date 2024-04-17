program ejercicio2;
const
	valoralto = '9999';
type
	str4 = string[4];
	reg_mae = record
		cod:str4;
		ape:string[20];
		nom:string[20];
		aprobadas:integer;
		cursadas:integer;
	end;
	
	reg_det = record
		cod:str4;
		aprobada:boolean;
	end;
	
	maestro = file of reg_mae;
	detalle = file of reg_det;
	
	var 	
		mae: maestro; det: detalle;
		regm: reg_mae; regd: reg_det;
	
	procedure cargarMae(var mae:maestro);
	var regm: reg_mae;
	begin
		rewrite(mae);
		with regm do begin
			regm.cod:= '0001';
			regm.ape:= 'ape1';
			regm.nom:= 'nom1';
			regm.cursadas:= 2;
			regm.aprobadas:= 3;
		end;
		write(mae,regm);
		with regm do begin
			regm.cod:= '0002';
			regm.ape:= 'ape2';
			regm.nom:= 'nom2';
			regm.cursadas:= 3;
			regm.aprobadas:= 8;
		end;
		write(mae,regm);
		with regm do begin
			regm.cod:= '0003';
			regm.ape:= 'ape3';
			regm.nom:= 'nom3';
			regm.cursadas:= 5;
			regm.aprobadas:= 1;
		end;
		write(mae,regm);
		close(mae);
	end;
	
	procedure cargarDet(var det:detalle);
	var regd:reg_det;
	begin
		rewrite(det);
		with regd do begin
			regd.cod:= '0001';
			aprobada:= true;
		end;
		write(det,regd);
				with regd do begin
			regd.cod:= '0001';
			aprobada:= true;
		end;
		write(det,regd);
		with regd do begin
			regd.cod:= '0002';
			aprobada:= false;
		end;
		write(det,regd);
		with regd do begin
			regd.cod:= '0003';
			aprobada:= true;
		end;
		write(det,regd);
		close(det);
	end;
	
	procedure leer(var det:detalle;var regd:reg_det);
	begin
		if (not eof(det)) then
			read(det,regd)
		else
			regd.cod:= valoralto;
	end;
	
	procedure actualizarMaestro(var mae:maestro;var det:detalle; var regd:reg_det; var regm:reg_mae);
	begin
		reset(det); reset(mae);
		leer(det,regd);
		while(regd.cod <> valoralto) do
		begin
			read(mae,regm);
			while(regm.cod <> regd.cod) do
				read(mae,regm);
		
			while(regm.cod = regd.cod) do
			begin
				if (regd.aprobada) then 
				begin 
					writeln('El alumno ',regm.nom,' aprobo con final');
					writeln('antes: aprobadas:',regm.aprobadas, ' cursadas:',regm.cursadas);
					regm.aprobadas:= regm.aprobadas + 1;
					regm.cursadas:= regm.cursadas - 1;
					writeln('ahora: aprobadas:',regm.aprobadas, ' cursadas:',regm.cursadas);
					writeln('--------------------------------');
				end
				else begin
					writeln('El alumno ',regm.nom,' aprobo la cursada');
					writeln('antes: aprobadas:',regm.aprobadas, ' cursadas:',regm.cursadas);
					regm.cursadas:= regm.cursadas + 1;
					writeln('ahora: aprobadas:',regm.aprobadas, ' cursadas:',regm.cursadas);
					writeln('--------------------------------');
				end;
				leer(det,regd);
			end;
			seek(mae, filepos(mae)-1);
			write(mae,regm);
		end;
		close(det); close(mae);
	end;
	
	procedure listarAlumnos(var mae:maestro; var regm:reg_mae; var texto:text);
	begin
		reset(mae); rewrite(texto);
		
		while(not eof(mae)) do
		begin
			read(mae,regm);
			if(regm.aprobadas > regm.cursadas) then
			begin
				with regm do begin
					writeln(cod,' ',ape,' ',nom,' ',aprobadas,' ',cursadas);
					writeln(texto,' ',cod,' ',ape,' ',nom,' ',aprobadas,' ',cursadas);
				end;
			end;
		end;
		close(mae); close(texto);
	end;
	
var 
	opcion:integer; texto:text;
BEGIN
	assign(mae,'maestro'); assign(det,'detalle'); assign(texto,'lista.txt');
	cargarMae(mae); cargarDet(det);
	while(true) do
	begin
		writeln('Ingrese la operacion que quiere realizar');
		writeln('1 = Actualizar archivo maestro');
		writeln('2 = Listar alumnos con mas materias aprobadas que cursadas');
		writeln('3 = Finalizar programa');
		readln(opcion);
		case opcion of
			1: actualizarMaestro(mae,det,regd,regm);
			2: listarAlumnos(mae,regm,texto);
			3: break;
		end;
	end;
END.
