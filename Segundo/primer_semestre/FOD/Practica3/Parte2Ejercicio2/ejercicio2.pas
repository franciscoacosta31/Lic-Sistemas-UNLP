program ejercicio2;
type
    mesa = record
        localidad:integer;
        mesa:integer;
        votos:integer;
    end;

    archivo = file of mesa;
    archivo_localidades = file of integer;

var arch:archivo;

    procedure cargarArchivo(var arch:archivo);
    var
        reg:mesa;carga:text;
    begin
        assign(carga,'carga.txt');assign(arch,'archivo.dat');
        reset(carga);rewrite(arch);
        while(not eof(carga))do
        begin
            with reg do
                readln(carga,localidad,mesa,votos);
            write(arch,reg);
        end;
        close(carga);close(arch);
    end;

    function encontre(var arch:archivo_localidades; localidad:integer):boolean;
    var
        ok:boolean; reg_local:integer;
    begin
        ok:= false;
        seek(arch,0);
        while((not eof(arch))and(not ok)) do
        begin
            read(arch,reg_local);
            if(reg_local = localidad) then
                ok:= true;
        end;
        encontre:= ok;
    end;

    procedure listado(var arch:archivo);
    var
        total,total_localidad,localidad,pos:integer;
        reg:mesa;
        ok:boolean;
        arch_localidades:archivo_localidades;
    begin
        assign(arch_localidades,'arch_localidades.dat');
        reset(arch); rewrite(arch_localidades);
        total:= 0;
        ok:= false;
        while(not eof(arch))do
        begin
            //Leo un registro del archivo
            read(arch,reg);
            //Si no imprimí esa localidad, la imprimo
            if(not encontre(arch_localidades,reg.localidad))then
            begin
                //Guardo la posicion siguiente del registro que acabo de leer
                pos:= filepos(arch);
                ok:= true;
                //Inicio las variables
                localidad:= reg.localidad;
                total_localidad:= reg.votos;
                writeln('Codigo de localidad:',localidad);
                //Sumo los votos de la localidad
                while(not eof(arch))do
                begin
                    read(arch,reg);
                    if(reg.localidad = localidad) then
                    begin
                        total_localidad:= total_localidad + reg.votos;
                    end;
                end;
                writeln('Total de votos:',total_localidad);
                writeln('---------------------');
                total:= total + total_localidad;
                //Agrego la localidad a las localidades impresas
                seek(arch_localidades,filesize(arch_localidades));
                write(arch_localidades,localidad);
            end;
            //Si entre al if, me vuelvo a posicionar donde corresponde
            if(ok) then
                seek(arch,pos);
            ok:= false;
        end;
        writeln('Total general de votos:',total);
        close(arch);
    end;

begin
    writeln('---------------------');
    cargarArchivo(arch);
    listado(arch);
end.