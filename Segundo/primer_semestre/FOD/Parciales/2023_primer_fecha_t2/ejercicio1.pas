program parcial;
const
	valoralto = 9999;
type
	empleado = record
		dni:integer;
		nombre:string;
		apellido:string;
		edad:integer;
		domicilio:string;
		nacimiento:integer;
	end;
	
	archivo = file of empleado;
	
procedure agregarEmpleado(var a:archivo);
var
	reg,cabecera,nueva_cabecera:empleado;
	dni:integer;
begin
	writeln('Ingrese el dni del empleado');
	readln(dni);
	if(existeEmpleado(dni,a))then
		writeln('El empleado con ese dni ya existe')
	else
	begin
		leerEmpleado(reg);
		reset(a);
		//Guardo el reg cabecera
		read(a,cabecera);
		if(cabecera.dni = 0) then
		begin
			//Si la cabecera tiene 0, agrego al final
			seek(a,filesize(a));
			write(a,reg)
		end
		else
		begin
			//Me posiciono en el lugar libre
			seek(a,cabecera.dni*-1);
			//Me guardo la nueva cabecera
			read(a,nueva_cabecera);
			seek(a,filepos(a)-1);
			//Ocupo el lugar libre
			write(a,reg);
			//Guardo la nueva cabecera
			seek(a,0);
			write(a,nueva_cabecera);
		end;
		close(a);
	end;
end;	

procedure quitarEmpleado(var a:archivo);
var
	dni:integer;
	reg,cabecera,nueva_cabecera:empleado;
begin
	writeln('Ingrese un dni');
	readln(dni);
	if(existeEmpleado(dni,a))then
	begin
		reset(a);
		
		//Guardo el reg cabecera
		read(a,cabecera);
		//Busco el reg a eliminar
		read(a,reg);
		while(reg.dni <> dni) do
			read(a,reg);
		//Creo la nueva cabecera con la pos correspondiente
		nueva_cabecera.dni:= (filepos(a)-1)*-1;
		//Guardo la anterior cabecera en la posicion eliminada
		seek(a,filepos(a)-1);
		write(a,cabecera);
		//Actualizo la cabecera con la nueva cabecera
		seek(a,0);
		write(a,nueva_cabecera);
		
		close(a);
	end;
end;
	
