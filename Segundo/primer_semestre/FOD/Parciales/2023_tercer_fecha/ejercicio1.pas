program parcial;
const
	valoralto = 9999;
	cant_sucursales = 20;
type
	producto = record
		codigo:integer;
		stock:integer;
		stock_min:integer;
		precio:real;
		nombre:string;
	end;
	
	venta = record
		codigo:integer;
		cant:integer;
	end;
	
	maestro = file of producto;
	detalle = file of venta;
	
	vdet = array [1..cant_sucursales] of detalle;
	vreg = array [1..cant_sucursales] of venta;
	
procedure leer(var d:detalle; var r:venta);
begin
	if(not EOF(d)) then
		read(d,r)
	else
		r.codigo:= valoralto;
end;

procedure minimo(VD: vdet; var VR:vreg; var min:venta);
var
	i,pos:integer;
begin
	min.codigo:= valoralto;
	for i:= 1 to cant_sucursales do
	begin
		if(VR[i].codigo < min.codigo) then
		begin
			min.codigo:= VR[i].codigo;
			pos:= i;
		end;
	end;
	
	if(min.codigo <> valoralto) then
		read(VD[pos],VR[pos]);
end;

procedure actualizarMaestro(var mae:maestro; VD:vdet; var texto:text);
var
	min:venta;
	regm:producto;
	i:integer;
	total:real;
	VR:vreg;
begin
	//Asigno el archivo de texto y abro los archivos maestro y detalle
	assign(texto,'exportar.txt');
	rewrite(texto);
	reset(mae);
	for i:= 1 to cant_sucursales do
	begin
		reset(VD[i]);
		leer(VD[i],VR[i]);
	end;
	
	minimo(VD,VR,min);
	while(min.codigo <> valoralto)do
	begin
		//Busco en el maestro el producto
		read(mae,regm);
		while(min.codigo <> regm.codigo) do
			read(mae,regm);
		//Una vez encontrado el producto, actualizo el maestro con todas las ocurrencias del producto en los archivos detalle
		total:= 0.0;
		while(min.codigo = regm.codigo) do
		begin
			total:= total + min.cant;
			regm.stock:= regm.stock - min.cant;
			minimo(VD,VR,min);
		end;
		//Guardo los cambios en el archivo maestro
		seek(mae,filepos(mae)-1);
		write(mae,regm);
		//Cargo al archivo de texto si la compra de ese producto superó los $10000
		total:= total * regm.precio;
		if(total > 10000.0) then
		begin
			with regm do
				writeln(texto,' ',codigo,' ',stock,' ',stock_min,' ',precio:0:2,' ',nombre);
		end;
	end;
	//Cierro todos los archivos
	close(mae);
	close(texto);
	for i:= 1 to cant_sucursales do
		close(VD[i]);
end;
	
	
