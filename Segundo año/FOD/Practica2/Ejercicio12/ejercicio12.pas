program ejercicio12;
const valoralto = 9999;
type
    reg_mae = record
        nro_usuario:integer;
        nom_usuario:string;
        nombre:string;
        apellido:string;
        cantMails:integer;
    end;

    reg_det = record
        nro_usuario:integer;
        cuentaDestino:string;
        cuerpoMensaje:string;
    end;

    maestro = file of reg_mae;
    detalle = file of reg_det;
var
    mae:maestro; det:detalle; regm:reg_mae; regd:reg_det;
    
    procedure cargarMaestro(var mae:maestro);
    begin
        assign(mae,'maestro');
        rewrite(mae);

        with regm do begin
            nro_usuario:=1;
            nom_usuario:='uno';
            nombre:='nomuno';
            apellido:='apeuno';
            cantMails:=1;
        end;
        write(mae,regm);
        with regm do begin
            nro_usuario:=2;
            nom_usuario:='dos';
            nombre:='nomdos';
            apellido:='apedos';
            cantMails:=2;
        end;
        write(mae,regm);
        with regm do begin
            nro_usuario:= 3;
            nom_usuario:= 'tres';
            nombre:= 'nomtres';
            apellido:= 'apetres';
            cantMails:= 3;
        end;
        write(mae,regm);
        close(mae);
    end;

    procedure cargarDetalle(var det:detalle);
    begin
        assign(det,'detalle');
        rewrite(det);

        with regd do begin
            nro_usuario:= 1;
            cuentaDestino:= 'cuentaDos'; 
            cuerpoMensaje:= 'uno,dos';
        end;
        write(det,regd);
        with regd do begin
            nro_usuario:= 2;
            cuentaDestino:= 'cuentaTres'; 
            cuerpoMensaje:= 'dos,tres';
        end;
        write(det,regd);
        with regd do begin
            nro_usuario:= 3;
            cuentaDestino:= 'cuentaUno'; 
            cuerpoMensaje:= 'tres,uno';
        end;
        write(det,regd);
                with regd do begin
            nro_usuario:= 3;
            cuentaDestino:= 'cuentaUno'; 
            cuerpoMensaje:= 'tres,uno';
        end;
        write(det,regd);
        close(det);
    end;

    procedure leer(var det:detalle;var regd:reg_det);
    begin
        if(not eof(det)) then
            read(det,regd)
        else
            regd.nro_usuario:= valoralto;
    end;

    procedure actualizarMaestro(var mae:maestro; var det:detalle);
    var mails: integer;
    begin
        reset(mae); reset(det);
        leer(det,regd);
        while(regd.nro_usuario <> valoralto)do
        begin
            read(mae,regm);
            while(regm.nro_usuario <> regd.nro_usuario) do
                read(mae,regm);
            mails:= 1;
            while(regd.nro_usuario = regm.nro_usuario) do
            begin
                mails:=mails+1;
                leer(det,regd);
            end;
            writeln('Cant mails enviados por user ',regm.nro_usuario,' antes:',regm.cantMails);
            regm.cantMails:= regm.cantMails + mails;
            writeln('Cant mails enviados por user ',regm.nro_usuario,' ahora:',regm.cantMails);
            seek(mae,filepos(mae)-1);
            write(mae,regm);
        end;
        close(mae); close(det);
    end;

begin
    cargarMaestro(mae);
    cargarDetalle(det);
    actualizarMaestro(mae,det);
end.