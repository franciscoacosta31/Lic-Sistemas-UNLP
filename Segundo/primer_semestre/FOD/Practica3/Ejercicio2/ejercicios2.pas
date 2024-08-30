program ejercicio2;
type
    registro = record
        nro_asistente:integer;
        apeynom:string;
        email:string;
        telefono:integer;
        dni:integer;
    end;

    archivo = file of registro;

var arch:archivo; reg:registro;

    procedure leer(var reg:registro);
    begin
        writeln('Ingrese el nro del asistente');
        readln(reg.nro_asistente);
        if(reg.nro_asistente <> -1) then
        begin
            writeln('Ingrese el nombre y apellido');
            readln(reg.apeynom);
            writeln('Ingrese el email');
            readln(reg.email);
            writeln('Ingrese el telefono');
            readln(reg.telefono);
            writeln('Ingrese el dni');
            readln(reg.dni);
        end;
    end;

    procedure cargarArchivo(var arch:archivo);
    begin
        assign(arch,'archivo.dat'); rewrite(arch);
        
        leer(reg);
        while(reg.nro_asistente <> -1)do
        begin
            write(arch,reg);
            leer(reg);    
        end;
        close(arch);

        writeln('Archivo cargado con exito');
    end;

    procedure bajaLogica(var arch:archivo);
    begin
        writeln('Eliminando asistentes con nro inferior a 1000...');
        reset(arch);

        while(not eof(arch))do
        begin
            read(arch,reg);
            if(reg.nro_asistente < 1000) then
            begin
                reg.apeynom:= '***' + reg.apeynom;
                seek(arch,filepos(arch)-1);
                write(arch,reg);
                writeln('Asistente con nro ',reg.nro_asistente,' eliminado con exito')
            end;
        end;
        close(arch);
        writeln('Asistentes eliminados con exito.');
    end;

begin
    cargarArchivo(arch);
    bajalogica(arch);
end.