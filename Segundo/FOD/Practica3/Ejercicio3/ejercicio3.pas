program ejercicio3;
type
    novela = record
        codigo:integer;
        genero:string;
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
        
        // creo el registro cabecera
        reg.codigo:= 0;
        write(arch,reg);

        // creo los demas registros
        while(reg.codigo <> -1) do
        begin
            leer(reg);
            write(arch,reg);
        end;

        close(arch);
    end;

    procedure RealizarAlta(var arch:archivo);
    var cabecera,reg_vacio:reg; 
    begin
        reset(arch);

        leer(reg);
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
            seek(arch,filesize(arch));
            write(arch,reg);
        end;

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

        //Si existe la novela con ese código, vuelve a leer los datos
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
            seek(arch,filepos(mae)-1);
            write(arch,reg);
            writeln('Novela modificada con exito');
        end
        else writeln('No existe la novela con ese codigo');

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
                4: break;
            end;
        end;
    end;

var opcion:integer;
begin
    while(true) do
    begin
        writeln('Ingrese la operacion a realizar');
        writeln('1 = Crear el archivo');
        writeln('2 = Abrir el archivo');
        writeln('9 = Cerrar programa');
        readln(opcion);
        case opcion of
            1: CrearArchivo(arch);
            2: AbrirArchivo(arch);
            3: ListarEmpleados(arch);
            9: break;
        end;
    end;
end.