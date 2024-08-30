program ejercicio8;
type
    linux = record
        cant:integer;
        nom:string;
        //año:integer;
        //kernel:integer;
        //desc:string;
    end;

    archivo = file of linux;

var arch:archivo;

    procedure cargarArchivo(var arch:archivo);
    var
        carga:text; reg:linux;
    begin
        //Asigno los archivos
        assign(carga,'carga.txt'); assign(arch,'archivo.dat');
        //Abro los archivos
        reset(carga); rewrite(arch);
        //Inicio el registro cabecera
        reg.cant:= 0;
        reg.nom:= '';
        write(arch,reg);
        //Copio los registros
        while(not eof (carga))do
        begin
            with reg do
                readln(carga,cant,nom);
            write(arch,reg);
        end;
        //Cierro los archivos
        close(carga);close(arch);
    end;

    procedure imprimirArchivo(var arch:archivo);
    var
        reg:linux;
    begin
        reset(arch);
        while(not eof(arch))do
        begin
            read(arch,reg);
            writeln('cant:',reg.cant,' nom:',reg.nom);
        end;
        close(arch);
    end;

    function ExisteDistribucion(var arch:archivo; nom:string):boolean;
    var reg:linux;
    begin
        //Abro el archivo
        reset(arch);
        //Busco el nombre
        read(arch,reg);
        while((not eof (arch))and(nom <> reg.nom))do
        begin
            read(arch,reg);
        end;
        //Cierro el archivo
        close(arch);
        if(nom = reg.nom) then
            ExisteDistribucion:= true
        else
            ExisteDistribucion:= false;
    end;

    procedure AltaDistribucion(var arch:archivo; nom:string; cant:integer);
    var
        reg,reg_cabecera,reg_nueva_cabecera:linux;
    begin
        if(not (ExisteDistribucion(arch,nom)))then
        begin
            reset(arch);
            read(arch,reg_cabecera);
            if(reg_cabecera.cant = 0)then
            begin
                seek(arch,filesize(arch));
                reg.nom:= nom;
                reg.cant:= cant;
                write(arch,reg);
            end
            else
            begin
                //Me posiciono en el ultimo registro eliminado y copio el registro
                seek(arch,reg_cabecera.cant*-1);
                read(arch,reg_nueva_cabecera);
                //Escribo el registro nuevo en el lugar libre
                seek(arch,filepos(arch)-1);
                reg.nom:= nom; reg.cant:= cant;
                write(arch,reg);
                //Sobreescribo el registro cabecera con el proximo espacio libre
                seek(arch,0);
                write(arch,reg_nueva_cabecera);
            end;
            //Cierro el archivo
            close(arch);
        end
        else
        begin
            writeln('ya existe la distribucion');
        end;
        imprimirArchivo(arch);
    end;

    procedure BajaDistribucion(var arch:archivo; nom:string);
    var
        reg,reg_cabecera,reg_nueva_cabecera:linux; ok:boolean; pos:integer;
    begin
        ok:= true;
        if(ExisteDistribucion(arch,nom))then
        begin
            //Abro el archivo
            reset(arch);
            //Me guardo el registro cabecera
            read(arch,reg_cabecera);
            //Busco el registro a eliminar
            while(ok)do
            begin
                read(arch,reg_nueva_cabecera);
                if(reg_nueva_cabecera.nom = nom) then
                    ok:= false;
            end;
            //Me posiciono en el registro a eliminar y escribo la cabecera
            pos:= filepos(arch)-1;
            seek(arch,pos);
            write(arch,reg_cabecera);
            //Me posiciono en la cabecera  y escribo la nueva cabecera
            seek(arch,0);
            reg_nueva_cabecera.cant:= pos*-1;
            write(arch,reg_nueva_cabecera);
            //Cierro el archivo
            close(arch);
        end
        else
            writeln('Distribucion no existente');
        imprimirArchivo(arch);
    end;

var opcion:integer; nom:string;cant:integer;
begin
    cargarArchivo(arch); //Se dispone
    while(True)do
    begin
        writeln('--------------------------------------------');
        writeln('Ingrese el numero de la operacion a realizar');
        writeln('1 = Buscar distribucion');
        writeln('2 = Agregar distribucion');
        writeln('3 = Borrar distribucion');
        writeln('4 = Salir');
        readln(opcion);
        case opcion of
            1: 
                begin
                    writeln('Ingrese el nombre de la distribucion');
                    readln(nom);
                    nom:= ' '+nom; //Fix para que se pueda leer bien
                    ExisteDistribucion(arch,nom);
                end;
            2:
                begin
                    writeln('Ingrese el nombre de la distribucion');
                    readln(nom);
                    nom:= ' '+nom;
                    writeln('Ingrese la cantidad de desarrolladores');
                    readln(cant);
                    AltaDistribucion(arch,nom,cant);
                end;
            3:
                begin
                    writeln('Ingrese el nombre de la distribucion');
                    readln(nom);
                    nom:= ' '+nom;
                    BajaDistribucion(arch,nom);
                end;
            4: break;
        end;
    end;
end.