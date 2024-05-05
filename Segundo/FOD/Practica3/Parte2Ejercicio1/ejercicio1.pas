program ejercicio1;
type
    producto = record
        codigo:integer;
        //nombre:string;
        //precio:real;
        stock:integer;
        stock_min:integer;
    end;

    venta = record
        codigo:integer;
        cant_vendido:integer;
    end;

    maestro = file of producto;
    detalle = file of venta;

var mae:maestro; det:detalle;

    procedure cargarMaestro(var mae:maestro);
    var
        carga:text;reg:producto;
    begin
        assign(carga,'cargaMaestro.txt');assign(mae,'maestro');
        reset(carga);rewrite(mae);
        while(not eof(carga))do
        begin
            with reg do
                readln(carga,codigo,stock,stock_min);
            write(mae,reg);
        end;
        close(carga);close(mae);
    end;

    procedure cargarDetalle(var det:detalle);
    var
        carga:text;reg:venta;
    begin
        assign(carga,'cargaDetalle.txt');assign(det,'detalle');
        reset(carga);rewrite(det);
        while(not eof(carga))do
        begin
            with reg do
                readln(carga,codigo,cant_vendido);
            write(det,reg);
        end;
        close(carga);close(det);
    end;

    procedure imprimirArchivo(var mae:maestro);
    var
        reg:producto;
    begin
        reset(mae);
        while(not eof(mae))do
        begin
            read(mae,reg);
            writeln('cod:',reg.codigo,' stock:',reg.stock);
        end;
        close(mae);
    end;

    procedure actualizarMaestro(var mae:maestro; var det:detalle);
    var reg_mae:producto; reg_det:venta;
    begin
        //Abro los archivos
        reset(mae);reset(det);
        while(not eof(det))do
        begin
            read(det,reg_det);
            read(mae,reg_mae);
            //Busco en el archivo maestro la venta
            while(reg_det.codigo <> reg_mae.codigo)do
                read(mae,reg_mae);
            //Actualizo el maestro con el stock nuevo
            reg_mae.stock:= reg_mae.stock - reg_det.cant_vendido;
            seek(mae,filepos(mae)-1);
            write(mae,reg_mae);
            //Reubico el puntero del archivo maestro
            seek(mae,0);
        end;
        //Cierro los archivos
        close(mae);close(det);
    end;

begin
    cargarMaestro(mae); //se dispone
    cargarDetalle(det); //se dispone
    imprimirArchivo(mae);
    writeln('---------------');
    actualizarMaestro(mae,det);
    imprimirArchivo(mae);
end.