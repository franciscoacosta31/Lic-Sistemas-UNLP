program ejercicio6;
type
    prenda = record
        cod_prenda:integer;
        descripcion:string;
        colores:string;
        tipo_prenda:string;
        stock:integer;
        precio_unitario:real;
    end;

    maestro = file of prenda;
    codigo = file of integer;

var mae:maestro; cod:codigo;

    procedure cargarMaestro(var mae:maestro);
    var regm:prenda;
    begin
        //Creo y abro el archivo
        assign(mae,'maestro.dat');
        rewrite(mae);

        with regm do
        begin
            cod_prenda:=10;
            descripcion:='10'; 
            colores:='10';
            tipo_prenda:='10';
            stock:=10;
            precio_unitario:=10.0;
        end;
        with regm do
        begin
            cod_prenda:=30;
            descripcion:='30'; 
            colores:='30';
            tipo_prenda:='30';
            stock:=30;
            precio_unitario:=30.0;
        end;
        write(mae,regm);    
        write(mae,regm);
        with regm do
        begin
            cod_prenda:=20;
            descripcion:='20'; 
            colores:='20';
            tipo_prenda:='20';
            stock:=20;
            precio_unitario:=20.0;
        end;
        write(mae,regm);

        close(mae);
    end;

    procedure cargarCodigo(var cod:codigo);
    begin
        //Creo y abro el archivo
        assign(cod,'codigo.dat');
        rewrite(cod);
        //Agrego dato
        write(cod,30);
        //Cierro archivo
        close(cod);
    end;

    procedure modificarStock(var mae:maestro;var cod:codigo);
    var regm:prenda; num:integer;
    begin
        //Abro los archivos
        reset(mae);reset(cod);

        while(not eof(cod))do
        begin
            //Leo el codigo a eliminar
            read(cod,num);

            //Busco en el archivo maestro la prenda con ese codigo
            while(not eof(mae))and(cod <> regm.cod_prenda)do
                read(mae,regm);
            if(cod = regm.cod_prenda) then
            begin
                regm.stock:= regm.stock*-1;
                seek(mae,filepos(mae)-1);          
                write(mae,regm);
            end;
        end;
        //Cierro los archivos
        close(mae);close(cod);
        
    end;

begin
    //Se dispone
    cargarMaestro(mae);
    cargarCodigos(cod);
    //
    modificarStock(mae,cod);

end.