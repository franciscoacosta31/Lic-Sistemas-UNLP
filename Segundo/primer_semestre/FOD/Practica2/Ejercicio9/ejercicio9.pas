program ejercicio9;
const
    valoralto = 9999;
type
    registro = record
        prov:integer;
        local:integer;
        num:integer;
        votos:integer;
    end;
    
    archivo = file of registro;

    procedure cargarArchivo(var arch:archivo);
    var carga:text; reg:registro;
    begin
        assign(carga,'archivo.txt');
        assign(arch,'archivo');
        
        reset(carga);rewrite(arch);

        while(not eof (carga))do
        begin
            with reg do readln(carga, prov, local, num, votos);
            write(arch,reg);
        end;

        close(arch); close(carga);
        writeln('Archivo cargado con exito');
    end;

    procedure leer(var arch:archivo;var reg:registro);
    begin
        if(not eof(arch)) then
            read(arch,reg)
        else
        begin
            reg.prov:= valoralto;
            reg.local:= valoralto;
        end;
    end;

    procedure imprimirArchivo(var arch:archivo);
    var 
    reg:registro; 
    prov:integer; cantProv:integer;
    local:integer; cantLocal:integer;
    begin
        reset(arch);
        leer(arch,reg);
        while(reg.prov <> valoralto) do
        begin
            prov:= reg.prov; cantProv:= 0;
            writeln('Codigo de provincia:',prov);
            while(prov = reg.prov) do
            begin
                local:= reg.local; cantLocal:= 0;
                writeln('Codigo de localidad:',local);
                while(local = reg.local) do
                begin
                    cantLocal:= cantLocal + reg.votos;
                    leer(arch,reg);
                end;
                writeln('Total de votos localidad:',cantLocal);
                writeln('-----------------------------');
                cantProv:= cantProv + cantLocal;
            end;
            writeln('Total de votos provincia:',cantProv);
            writeln('-----------------------------');
        end;
        close(arch);
    end;

var arch: archivo;
begin
    cargarArchivo(arch);
    imprimirArchivo(arch);
end.