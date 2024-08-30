program ejercicio4y5;
const valoralto = 9999;
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

    procedure leer2(var arch:tArchFlores; var reg:reg_flor);
    begin
        if(not eof(arch)) then
            read(arch,reg)
        else
            reg.codigo:= valoralto;
    end;


    procedure CrearArchivo(var arch:tArchFlores);
    var reg:reg_flor;
    begin
        assign(arch,'archivo');rewrite(arch);
        
        //Inicio el reg cabecera
        reg.codigo:= 0; reg.nombre:= '0';
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

    procedure eliminarFlor(var arch:tArchFlores;cod:integer);
    var pos:integer; reg,reg_cabecera:reg_flor;
    begin
        reset(arch);

        //Leo el registro cabecera 
        read(arch,reg_cabecera);
        
        //Busco el registro a eliminar
        leer2(arch,reg);
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
            reg.codigo:= pos*-1;
            write(arch,reg);

            writeln('Baja realizada con exito');
        end
        else
            writeln('No se encontro el registro a eliminar');
        
        close(arch);
    end;

    procedure listarFlores(var arch:tArchFlores);
    var reg:reg_flor;
    begin
        reset(arch);

        //Omito el registro cabecera
        read(arch,reg);

        leer2(arch,reg);
        while(reg.codigo <> valoralto)do
        begin
            if(reg.codigo >= 0)then
            begin
                with reg do 
                    writeln(codigo,' ',nombre);
            end;
            leer2(arch,reg);
        end;
            
        close(arch);
    end;


var nombre:string; codigo,cod,opcion:integer;
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
            2: begin
                writeln('Ingrese el codigo de la flor a borrar');
                readln(cod);    
                eliminarFlor(arch,cod);
                end;
            3: listarFlores(arch);
            4: break;
        end;
    end;
end.