program ejercicio17;
const
    valoralto = 9999;
    valorralto = 'zzz';
type
    str3 = string[3];
    reg_mae = record
        cod_localidad:integer;
        nom_localidad:str3;
        cod_municipio:integer;
        nom_municipio:str3;
        cod_hospital:integer;
        nom_hospital:str3;
        fecha:integer;
        cant_casos:integer;
    end;

    maestro = file of reg_mae;

var mae:maestro; regm:reg_mae;

    procedure cargarMaestro(var mae:maestro);
    var carga:text;
    begin
        assign(mae,'maestro'); assign(carga,'carga.txt');
        rewrite(mae); reset(carga);

        while(not eof (carga))do
        begin
            with regm do 
            begin
            readln(carga,cod_localidad,cod_municipio,cod_hospital,fecha,cant_casos);
            readln(carga,nom_localidad);
            readln(carga,nom_municipio);
            readln(carga,nom_hospital);
            write(mae,regm);
            end;
        end;

        close(mae); close(carga);
    end;

    procedure leer(var mae:maestro; var regm:reg_mae);
    begin
        if(not eof(mae)) then 
            read(mae,regm)
        else
        begin
            regm.cod_localidad:=valoralto;
            regm.nom_hospital:=valorralto;
            regm.nom_localidad:=valorralto;
            regm.nom_municipio:=valorralto;
        end;
    end;

    procedure imprimirMaestro(var mae:maestro);
    var local:str3; cant_local:integer; muni:str3; cant_muni:integer; hosp:str3; cant_hosp:integer; texto:text;
    begin
        assign(texto,'texto.txt'); rewrite(texto);
        reset(mae);
        leer(mae,regm);
        while(regm.cod_localidad <> valoralto) do
        begin
            local:= regm.nom_localidad;
            cant_local:= 0;
            while(local = regm.nom_localidad) do
            begin
                muni:= regm.nom_municipio;
                cant_muni:= 0;
                while(muni = regm.nom_municipio)do
                begin
                    hosp:= regm.nom_hospital;
                    cant_hosp:= 0;
                    while(hosp = regm.nom_hospital)do
                    begin
                        cant_hosp:= cant_hosp + regm.cant_casos;
                        leer(mae,regm);
                    end;
                    writeln('hospital:',hosp,' casos:',cant_hosp);
                    cant_muni:= cant_muni + cant_hosp;
                end;
                writeln('municipio:',muni,' casos:',cant_muni);
                cant_local:= cant_local + cant_muni;
                if(cant_muni > 1500) then
                begin
                    writeln(texto,' ',local,' ',muni,' ',cant_muni);
                end;
            end; 
            writeln('localidad:',local,' casos:',cant_local);
        end;
        close(mae); close(texto);
    end;

begin
    cargarMaestro(mae);    
    imprimirMaestro(mae);
end.