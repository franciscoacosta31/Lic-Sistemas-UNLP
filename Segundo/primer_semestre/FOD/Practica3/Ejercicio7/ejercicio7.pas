program ejercicio7;

type
    especies = record
        cod:integer;
      //familia:string;
      //desc:string;
      //zona:string;
        nom:string;        
    end;

    archivo = file of especies;

var arch:archivo;

    procedure cargarArchivo(var arch:archivo);
    var carga:text; reg:especies;
    begin
        //Asigno los nombres a los archivos
        assign(carga,'carga.txt'); assign(arch,'archivo.dat');
        //Abro los archivos
        rewrite(arch);reset(carga);
        //Cargo los registros
        while(not eof (carga))do
        begin
            with reg do
            begin
                readln(carga,cod,nom);
                write(arch,reg);
            end;
        end;
        //Cierro los archivos
        close(arch);close(carga);
    end;

    procedure marcarRegistros(var arch:archivo);
    var cod:integer; reg:especies; ok:boolean;
    begin
        //Abro el archivo
        reset(arch);
        //Se ingresa el primer código
        writeln('Ingrese el codigo de la especie a eliminar');
        readln(cod);
        while(cod <> 5000)do
        begin
            seek(arch,0);
            ok:= true;
            while(not eof(arch) and (ok))do
            begin
                read(arch,reg);
                if(reg.cod = cod) then
                    ok:= false;
            end;
            if(ok) then
                writeln('No se encontro la especie')
            else
            begin
                reg.cod:= reg.cod*-1;
                seek(arch,filepos(arch)-1);
                write(arch,reg);
                writeln('Baja logica de la especie',reg.nom,' realizada con exito');
            end;
            writeln('Ingrese el codigo de la siguiente especie a buscar o 5000 para finalizar');
            readln(cod);
        end;
        //Cierro el archivo
        close(arch);
    end;

    procedure eliminarRegistros(var arch:archivo);
    var reg_arch,reg_ult:especies; pos_eliminar:integer;
    begin
        reset(arch);
        while(not eof(arch))do
        begin
            read(arch,reg_arch);
            if(reg_arch.cod < 0) then
            begin
                //Guardo la posicion del registro a eliminar
                pos_eliminar:= filepos(arch)-1;
                //Me ubico al final del archivo y leo el registro
                seek(arch,filesize(arch)-1);
                read(arch,reg_ult);
                //Me ubico en la pos del registro a eliminar y escribo el ult registro
                seek(arch,pos_eliminar);
                write(arch,reg_ult);
                //Me posiciono en el ultimo registro y realizo el truncate
                seek(arch,filesize(arch)-1);
                Truncate(arch);
                //Me posiciono en la posicion del registro que elimine
                seek(arch,pos_eliminar);
            end;
        end;
        close(arch);
    end;

    procedure imprimirArchivo(var arch:archivo);
    var reg:especies;
    begin
	reset(arch);
	while(not eof(arch)) do
		begin
			read(arch, reg);
			writeln('cod:',reg.cod,' especie:',reg.nom);
		end;
	close(arch);
end;

begin
    cargarArchivo(arch); //SE DISPONE
    marcarRegistros(arch);
    eliminarRegistros(arch);
    imprimirArchivo(arch);
end.