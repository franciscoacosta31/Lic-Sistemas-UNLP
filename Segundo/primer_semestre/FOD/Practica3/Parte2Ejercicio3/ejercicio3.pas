program ejercicio3;
const
    valoralto = 9999;
    cantDetalles = 3;
type
    indice = 1..cantDetalles;

    reg_det = record
        cod:integer;
        fecha:integer;
        tiempo:integer;
    end;

    reg_mae = record
        cod:integer;
        fecha:integer;
        tiempoTotal:integer;
    end;

    maestro = file of reg_mae;
    detalle = file of reg_det;

    vectorDetalle = record
        arch:detalle;
        reg:reg_det;
    end;

    vector = array [1..cantDetalles] of vectorDetalle;

var
    v:vector;

    procedure cargarDetalle(var det:detalle; var reg:reg_det);
    var carga:text; nom:string;
    begin
        writeln('Ingrese la ruta del detalle');
        readln(nom);
        assign(carga,nom);
        writeln('Ingrese el nombre del detalle');
        readln(nom);
        assign(det,nom);
        reset(carga); rewrite(det);

        while(not eof(carga))do
        begin
            with reg do readln(carga,cod,fecha,tiempo);
            write(det,reg);
        end;

        close(det); close(carga);
    end;

    procedure cargarDetalles(var v:vector);
    var i:indice;
    begin
        for i:= 1 to cantDetalles do cargarDetalle(v[i].arch,v[i].reg);
    end;

    procedure leer(var det:detalle; var reg:reg_det);
    begin
        if(not eof(det)) then
            read(det,reg)
        else
            reg.cod:= valoralto;
    end;

    procedure minimo(var v:vector; var min:reg_det);
    var i:indice; pos:indice;
    begin
        min.cod:= valoralto; min.fecha:= valoralto;
        for i:= 1 to cantDetalles do
        begin
            if(v[i].reg.cod < min.cod) or ((v[i].reg.cod = min.cod) and (v[i].reg.fecha < min.fecha)) then
            begin
                min:= v[i].reg;
                pos:= i;
            end;
        end;
        if(min.cod <> valoralto) then
            leer(v[pos].arch,v[pos].reg);
    end;

    procedure imprimirMaestro(var mae:maestro);
    var
        regm:reg_mae;
    begin
        reset(mae);
        while(not eof(mae))do
        begin
            read(mae,regm);
            writeln('cod:',regm.cod,'Tiempo',regm.tiempoTotal);
        end;
        close(mae);
    end;


    procedure crearMaestro(v:vector);
    var 
        i:indice; mae:maestro; regm:reg_mae; ok:boolean;
    begin
        //Asigno y creo el maestro
        assign(mae,'maestro');
        rewrite(mae);
        for i:= 1 to cantDetalles do
        begin
            //Abro los detalles
            reset(v[i].arch);
            while(not eof(v[i].arch))do
            begin
                //Leo registro detalle
                read(v[i].arch,v[i].reg);
                seek(mae,0);
                ok:= true;
                //Busco el registro en el archivo maestro
                while(not eof(mae) and (ok))do
                begin
                    read(mae,regm);
                    if(regm.cod = v[i].reg.cod) then
                        ok:= false;
                end;
                //Si existe, le agrego el tiempo
                if(not ok)then
                begin
                    seek(mae,filepos(mae)-1);
                    regm.tiempoTotal:= regm.tiempoTotal + v[i].reg.tiempo;
                    write(mae,regm);
                end
                else
                //Si no existe, lo creo
                begin
                    regm.cod:= v[i].reg.cod;
                    regm.fecha:= v[i].reg.fecha;
                    regm.tiempoTotal:= v[i].reg.tiempo;
                    write(mae,regm);
                end;            
            end;
            //Cierro los detalles
            close(v[i].arch);
        end;
        //Cierro el maestro e imprimo
        close(mae);
        imprimirMaestro(mae);
    end;

begin
    cargarDetalles(v);
    writeln('archivos detalle cargados con exito');
    crearMaestro(v);
end.