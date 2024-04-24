program ejercicio3;
const
	valoralto = 9999;
type
	reg_mae = record
		cod:integer;
		nom:string[20];
		precio:real;
		stock_actual:integer;
		stock_min:integer;
	end;
	
	reg_det = record
		cod:integer;
		cant:integer;
	end;
	
	maestro = file of reg_mae;
	detalle = file of reg_det;
var 
	mae: maestro; det:detalle; regm:reg_mae; regd:reg_det;

	procedure leer(var det:detalle; var regd:reg_det);
	begin
		if(not eof(det)) then
			read(det,regd)
		else
			regd.cod:= valoralto;
	end;

	procedure cargarMae(var mae:maestro; var regm:reg_mae);
	begin
		rewrite(mae);
		with regm do begin
			cod:= 0;
			nom:= 'cero';
			precio:= 10.0;
			stock_actual:= 10; stock_min:= 5;
		end;
		write(mae,regm);
		with regm do begin
			cod:= 1;
			nom:= 'uno';
			precio:= 25.0;
			stock_actual:= 25; stock_min:= 10;
		end;
		write(mae,regm);
		with regm do begin
			cod:= 2;
			nom:= 'dos';
			precio:= 300.0;
			stock_actual:= 30; stock_min:= 50;
		end;
		write(mae,regm);
		
		close(mae);
	end;

	procedure cargarDet(var det:detalle; var regd:reg_det);
	begin
		rewrite(det);
		with regd do begin
			cod:= 0; cant:= 8; // 0 = stock insuficiente
		end;
		write(det,regd);
		with regd do begin
			cod:= 1; cant:= 4; // 1 = stock suficiente
		end;
		write(det,regd);
		with regd do begin
			cod:= 2; cant:= 20; // 2 = stock suficiente
		end;
		write(det,regd);
		with regd do begin
			cod:= 2; cant:= 10; // 2 = stock insuficiente
		end;
		write(det,regd);

		close(det);
	end;

	procedure ActualizarMaestro(var mae:maestro; var det:detalle; var regm:reg_mae; var regd:reg_det);
	begin
		reset(mae);reset(det);
		
		leer(det,regd);
		while(regd.cod <> valoralto) do
		begin
			// leo el archivo maestro hasta que el codigo coincida con el detalle
			read(mae,regm);
			while (regm.cod <> regd.cod) do
				read(mae,regm);
			// resto el stock del maestro con la cant vendida en el detalle
			while (regm.cod = regd.cod) do
			begin
				writeln('codigo:',regm.cod,' stock anterior:',regm.stock_actual);
				regm.stock_actual:= regm.stock_actual - regd.cant;
				leer(det,regd);
				writeln('Stock actualizado con exito, stock actual:',regm.stock_actual);
			end;
			// actualizo los registros en el maestro
			seek(mae,filepos(mae)-1);
			write(mae,regm);
			writeln('Archivo maestro actualizado con exito');
			writeln('---------------------------------------------');
		end;
		// cierro los archivos
		close(mae); close(det);
	end;
	
	procedure ListarFueraDeStock(var mae:maestro; var regm:reg_mae; var texto:text);
	begin
		// creo el archivo txt y abro el archivo maestro
		rewrite(texto); reset(mae);
		while(not eof(mae))do
		begin
			read(mae,regm);
			// si el stock actual se encuentra por debajo del minimo, lo agrego al txt
			if(regm.stock_actual < regm.stock_min) then
			begin
				with regm do
				begin
					writeln(' ',cod,' ',nom,' ',precio:0:2,' ',stock_actual,' ',stock_min);	
					writeln(texto,' ',cod,' ',nom,' ',precio:0:2,' ',stock_actual,' ',stock_min);		
				end;
			end;
		end;
		// cierro los archivos
		close(mae); close(texto);
	end;

var opcion:integer; texto:text;
BEGIN
	assign(mae,'maestro'); assign(det,'detalle'); assign(texto,'stock_minimo.txt');
	cargarMae(mae,regm); cargarDet(det,regd); // cargo los archivos
	while(true) do
	begin
		writeln('Ingrese la operacion a realizar');
		writeln('1 = Actualizar archivo maestro con archivo detalle');
		writeln('2 = Listar en un archivo txt productos cuyo stock este por debajo del minimo');
		writeln('3 = Finalizar programa');
		readln(opcion);
		case opcion of
			1: ActualizarMaestro(mae,det,regm,regd);
			2: ListarFueraDeStock(mae,regm,texto);
			3: break;
		end;
	end;
END.

