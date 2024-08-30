program parcial;
const
	valoralto = 9999;
type
	acceso = record
		año:integer;
		mes:integer;
		dia:integer;
		id:integer;
		tiempo:integer;
	end;
	
	log = file of acceso;
	
procedure leer(var a:log; var r:acceso);
begin
	if(not eof(a))do
		read(a,r);
	else
		r.año:= valoralto;
end;	
	
procedure generarInforme(var a:log);
var
	año,mes,dia,id,totalUsuario,totalDia,totalMes,totalAño:integer;
	r:acceso;
begin
	reset(a);
	//Se ingresa el año a buscar
	writeln('Ingrese el año del cual quiere generar el log');
	readln(año);
	//Se busca el año en el archivo
	leer(a,r);
	while(r.año <> año)and(r.año <> valoralto)do
		read(a,r);
	if(r.año = valoralto) then
		writeln('año no encontrado')
	else
	begin
		writeln('Año: ',año);
		totalAño:= 0;
		while(r.año = año)do
		begin
			mes:= r.mes;
			totalMes:= 0;
			writeln('Mes :',r.mes);
			while(r.año = año)and(r.mes = mes)do
			begin
				dia:= r.dia;
				totalDia:= 0;
				writeln('Dia :',r.dia);
				while(r.año = año)and(r.mes = mes)and(r.dia=dia)do
				begin
					id:= r.id;
					totalUsuario:= 0;
					write('idUsuario ',id);
					while(r.año = año)and(r.mes = mes)and(r.dia=dia)and(r.id = id)do
					begin
						totalUsuario:= totalUsuario + r.tiempo;
						leer(a,r);
					end;
					writeln('Tiempo total de acceso en el dia ',dia,' mes',mes,' ',totalUsuario);
					totalDia:= totalDia + totalUsuario;
				end;
					writeln('Tiempo total acceso dia ',dia,' mes',mes.' ',totalDia);
					totalMes:= totalMes + totalDia);
			end;
			writeln('Total tiempo de acceso mes ',mes,' ',totalMes);
			totalAño:= totalAño + totalMes;
		end;
		writeln('Total tiempo de acceso año ',año,' ',totalAño);
	end;
	close(a);
end;
		
