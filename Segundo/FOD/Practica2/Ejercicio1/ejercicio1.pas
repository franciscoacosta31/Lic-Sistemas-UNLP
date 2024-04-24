program untitled;
const
	valoralto = '9999';
type
	reg_ingresos = record
		codigo: string[4];
		nombre: string[30];
		monto_comision: real;
	end;
	
	reg_total = record
		codigo: string[4];
		nombre: string[30];
		total: real;
	end;
	
	detalle = file of reg_ingresos;
	
	maestro = file of reg_total;
	
	// Se realiza la carga del archivo detalle una vez para poder recorrerlo
	procedure cargarDetalle(var det:detalle;regd:reg_ingresos);
	begin
		with regd do begin
			codigo:= '0001';
			nombre:= 'primero';
			monto_comision:= 1.0;
		end;
		rewrite(det);
		write(det,regd);
		with regd do begin
			codigo:= '0001';
			nombre:= 'primero';
			monto_comision:= 5.0;
		end;
		write(det,regd);
		with regd do begin
			codigo:= '0002';
			nombre:= 'segundo';
			monto_comision:= 1.0;
		end;
		write(det,regd);
		with regd do begin
			codigo:= '0002';
			nombre:= 'segundo';
			monto_comision:= 7.0;
		end;
		write(det,regd);
		with regd do begin
			codigo:= '0005';
			nombre:= 'quinto';
			monto_comision:= 5.0;
		end;
		write(det,regd);
		with regd do begin
			codigo:= '0005';
			nombre:= 'quinto';
			monto_comision:= 50.0;
		end;
		write(det,regd);
		close(det);
	end;
	
	procedure leer(var det:detalle; var regd:reg_ingresos);
	begin
		if (not eof(det)) then begin
			read(det,regd);
			writeln('codigo:',regd.codigo,' monto:',regd.monto_comision:0:2);
		end
		else begin
			regd.codigo:= valoralto;
			writeln('Se leyo valor alto, finalizando lectura...');
		end;
	end;
		
var
	regd:reg_ingresos;
	det: detalle;
	mae: maestro;
	regm: reg_total;
BEGIN
	assign(det,'detalle'); assign(mae,'maestro');
	// cargarDetalle(det,regd);
	reset(det);
	rewrite(mae);
	leer(det,regd);
	while(regd.codigo <> valoralto) do
	begin
		regm.codigo:= regd.codigo;
		regm.total:= 0.0;
		
		while(regm.codigo = regd.codigo) do
		begin
			regm.total:= regm.total + regd.monto_comision;
			leer(det,regd);
		end;
		writeln('codigo nuevo, cargando archivo...');
		writeln('-------------------------------------------');
		writeln('codigo:',regm.codigo,' cargado con exito, monto:',regm.total:0:2);
		writeln('-------------------------------------------');
		write(mae,regm);
	end;
END.

