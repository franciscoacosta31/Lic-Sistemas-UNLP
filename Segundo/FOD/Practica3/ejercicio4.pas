program ejercicio4;
type
    reg_flor = record
        nombre:String[45];
        codigo:integer;
    end;

    tArchFlores = file of reg_flor;

var arch:tArchFlores;

    procedure leer(var reg:reg_flor);
    begin
        writeln('Ingrese el codigo de la flor');
        readln(reg.codigo);
        if(reg.codigo <> -1) then 
        begin
            writeln('Ingrese el nombre de la flor');
            readln(reg.nombre);
        end;
    end;


    procedure CrearArchivo(var arch:tArchFlores);
    var reg:reg_flor;
    begin
        assign(arch,'archivo');rewrite(arch);
        
        //Inicio el reg cabecera
        reg.codigo:= 0;
        write(arch,reg);

        leer(reg);
        while(reg.codigo <> -1)do
        begin
            write(arch,reg);
            leer(reg);
        end;
        close(arch);
    end;

    procedure agregarFlor(var arch:tArchFlores;nombre:string;codigo:integer);
    var reg_cabecera,reg_vacio,reg_nuevo:reg_flor;
    begin
        reset(arch);

        reg_nuevo.codigo:= codigo; reg_nuevo.nombre:= nombre;
        read(arch,reg_cabecera);
        if(reg_cabecera.codigo <> 0)then
        begin
            //Me posiciono en el reg vacio y lo guardo en una variable
            seek(arch,reg_cabecera.codigo*-1);
            read(arch,reg_vacio);
            //Ocupo el espacio vacío
            seek(arch,filepos(arch)-1);
            write(arch,reg_nuevo);
            //Reescribo el reg cabecera
            seek(arch,0);
            write(arch,reg_vacio);
        end
        else
        begin
            //Me posiciono al final del archivo y guardo el registro
            seek(arch,filesize(arch));
            write(arch,reg_nuevo);
        end;

        close(arch);

        writeln('Alta realizada con exito');
    end;

    procedure realizarBaja(var arch:tArchFlores);
    var cod,pos:integer; reg,reg_cabecera:reg_flor;
    begin
        reset(arch);

        writeln('Ingrese el codigo de la flor a borrar');
        readln(cod);

        if(not eof(arch)) then read(arch,reg_cabecera);
        reg.codigo:= reg_cabecera.codigo;
        while(not eof(arch)) and (reg.codigo <> cod)do
            read(arch,reg);
        if(reg.codigo = cod) then
        begin
            //Guardo la posicion a eliminar y guardo el registro cabecera 
            pos:= filepos(arch)-1;
            seek(arch,pos);
            write(arch,reg_cabecera);
            //Actualizo el registro cabecera
            seek(arch,0);
            reg.codigo:= reg.codigo*-1;
            write(arch,reg);
        end
        else
            writeln('No se encontro el registro a eliminar');
        close(arch);

        writeln('Baja realizada con exito');
    end;

    procedure listarFlores(var arch:tArchFlores);
    var reg:reg_flor;
    begin
        reset(arch);

        //Omito el registro cabecera
        read(arch,reg);

        read(arch,reg);
        while(not eof(arch))do
        begin
            if(reg.codigo > 0)then
            begin
                with reg do 
                    writeln(codigo,' ',nombre);
            end;
            read(arch,reg);
        end;
            
        close(arch);
    end;


var nombre:string; codigo,opcion:integer;
begin
    CrearArchivo(arch);
    while(true)do
    begin
        writeln('Ingrese la operacion a realizar');
        writeln('1 = Realizar alta');
        writeln('2 = Realizar baja');
        writeln('3 = Listar flores');
        writeln('4 = Salir');
        readln(opcion);
        case opcion of
            1: begin
                writeln('Ingrese el nombre'); readln(nombre);
                writeln('Ingrese el codigo'); readln(codigo);
                agregarFlor(arch,nombre,codigo);
                end;
            2: realizarBaja(arch);
            3: listarFlores(arch);
            4: break;
        end;
    end;
end.