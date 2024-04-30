program ejercicio3;

type
    novela = record
        codigo:integer;
        genero:integer;
        nombre:string;
        duracion:integer;
        director:string;
        precio:real;
    end;

    archivo = file of novela;

var arch:archivo; reg:novela;
    procedure leer(var reg:novela);
    begin
        writeln('Ingrese el codigo de la novela');
        readln(reg.codigo);
        if(reg.codigo <> -1)then
        begin
            writeln('Ingrese el genero');
            readln(reg.genero);
            writeln('Ingrese el nombre');
            readln(reg.nombre);
            writeln('Ingrese la duracion');
            readln(reg.duracion);
            writeln('Ingrese el director');
            readln(reg.director);
            writeln('Ingrese el precio');
            readln(reg.precio);
        end;
    end;

    procedure CrearArchivo(var arch:archivo);
    var nom:string;
    begin
        writeln('Ingrese el nombre del archivo');
        readln(nom);
        Assign(arch,nom);
        rewrite(arch);
        
        // inicio el registro cabecera
        reg.codigo:= 0;
        // creo los demas registros
        while(reg.codigo <> -1) do
        begin
            write(arch,reg);
            leer(reg);
        end;

        close(arch);
    end;

    procedure RealizarAlta(var arch:archivo);
    var cabecera,reg_vacio:novela; 
    begin
        reset(arch);

        leer(reg);
        if (not eof(arch)) then
        begin
            read(arch,cabecera);
            if(cabecera.codigo <> 0) then
            begin
                //accedo a la primera posición vacía
                seek(arch,cabecera.codigo*-1);

                //guardo el registro vacio y sobreescribo el nuevo 
                read(arch,reg_vacio);
                seek(arch,filepos(arch)-1);
                write(arch,reg);

                //actualizo el reg cabecera con el proximo vacío
                seek(arch,0);
                write(arch,reg_vacio);
            end
            else
            begin
                //si no hay registros vacíos, agrego al final
                seek(arch,filesize(arch));
                write(arch,reg);
            end;
        end    
        else
            writeln('El archivo esta vacio');
        close(arch);
    end;

    procedure ModificarNovela(var arch:archivo);
    var reg_buscar:novela;
    begin
        reset(arch);

        //Ingresa el código de la novela y lo busca
        read(reg_buscar.codigo);
        while(not eof(arch)and(reg.codigo <> reg_buscar.codigo)) do
        begin
            read(arch,reg);
        end;

        //Si existe la novela con ese código, leer los datos restantes
        if(reg.codigo = reg_buscar.codigo) then
        begin
            writeln('Ingrese el genero');
            readln(reg.genero);
            writeln('Ingrese el nombre');
            readln(reg.nombre);
            writeln('Ingrese la duracion');
            readln(reg.duracion);
            writeln('Ingrese el director');
            readln(reg.director);
            writeln('Ingrese el precio');
            readln(reg.precio);

            //Guardo los cambios
            seek(arch,filepos(arch)-1);
            write(arch,reg);
            writeln('Novela modificada con exito');
        end
        else writeln('No existe la novela con ese codigo');

        close(arch);
    end;

    procedure EliminarNovela(var arch:archivo);
    var cod:integer; reg_cabecera:novela; reg:novela; pos:integer;
    begin
        reset(arch);
        //Se ingresa el cod de la novela a eliminar
        writeln('Ingrese el codigo de la novela a eliminar');    
        readln(cod);

        //Guardo el reg cabecera
        read(arch,reg_cabecera);
        
        reg.codigo:= reg_cabecera.codigo;
        //Busco la novela a eliminar
        while(not eof(arch))and(cod <> reg.codigo) do
            read(arch,reg);
        if(cod = reg.codigo) then
        begin
            //Guardo en la pos eliminada el reg cabecera
            pos:= filepos(arch)-1;
            seek(arch,pos);
            write(arch,reg_cabecera);

            //Actualizo el reg cabecera con el nuevo espacio libre
            reg_cabecera.codigo:= pos*-1;
            seek(arch,0);
            write(arch,reg_cabecera);
        end
        else
            writeln('No se encontro la novela con el codigo ',cod);
        close(arch);
    end;

    procedure AbrirArchivo(var arch:archivo);
    var opcion:integer;
    begin
        while(true) do
        begin
            writeln('Ingrese el mantenimiento a realizar');
            writeln('1 = Dar de alta una novela');
            writeln('2 = Modificar los datos de una novela');
            writeln('3 = Eliminar una novela');
            writeln('4 = Volver');
            readln(opcion);
            case opcion of
                1: RealizarAlta(arch);
                2: ModificarNovela(arch);
                3: EliminarNovela(arch);
                4: break;
            end;
        end;
    end;

    procedure ListarEmpleados(var arch:archivo);
    var texto:text; reg:novela;
    begin
        assign(texto,'novelas.txt');
        rewrite(texto);reset(arch);
        
        //Salteo reg cabecera
        read(arch,reg);

        while(not eof(arch))do
        begin
            read(arch,reg);
            if(reg.codigo > 0)then
            begin
                with reg do begin
                    writeln(texto,codigo,' ',duracion,' ',precio:0:2,' ',genero,nombre);
                    writeln(texto,director);
                end;
            end
            else
                //Si es una posición vacía, carga el código
                with reg do writeln(texto,codigo);
        end;
        close(arch); close(texto);
    end;

var
    opcion:integer;
begin
    while(true) do
    begin
        writeln('Ingrese la operacion a realizar');
        writeln('1 = Crear el archivo');
        writeln('2 = Abrir el archivo');
        writeln('3 = Listar empleados');
        writeln('4 = Cerrar programa');
        readln(opcion);
        case opcion of
            1: CrearArchivo(arch);
            2: AbrirArchivo(arch);
            3: ListarEmpleados(arch);
            4: break;
        end;
    end;
end.
