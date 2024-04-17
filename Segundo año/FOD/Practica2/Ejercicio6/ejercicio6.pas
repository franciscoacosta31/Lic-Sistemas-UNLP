program ejercicio6;
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

    procedure crearMaestro(v:vector);
    var i:indice; min:reg_det; actual:reg_mae; mae:maestro;
    begin
        assign(mae,'maestro');
        rewrite(mae);
        for i:= 1 to cantDetalles do
        begin
            reset(v[i].arch);
            leer(v[i].arch,v[i].reg);
        end;

        minimo(v,min);
        while(min.cod <>valoralto) do
        begin
            actual.cod:= min.cod; 
            while(actual.cod = min.cod)do
            begin
                actual.fecha:= min.fecha; actual.tiempoTotal:= 0;
                writeln('COD ACTUAL',actual.cod,'Fecha actual',actual.fecha);
                while((min.cod = actual.cod)and(min.fecha = actual.fecha))do
                begin
                    writeln(min.tiempo);
                    actual.tiempoTotal:= actual.tiempoTotal + min.tiempo;
                    minimo(v,min);
                end;
                writeln('Tiempo total',actual.tiempoTotal);
                writeln('--------------------------');
                write(mae,actual);
            end;
        end;

        for i:= 1 to cantDetalles do
            close(v[i].arch);
        close(mae);
    end;


begin
    cargarDetalles(v);
    crearMaestro(v);
    writeln('archivos detalle cargados con exito');
end.