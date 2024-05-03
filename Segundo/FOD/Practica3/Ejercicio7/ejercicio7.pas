program ejercicio7;

type
    especies = record
        cod:integer;
        familia:integer;
        desc:integer;
        zona:integer;
        nom:string;        
    end;

    archivo = file of especies;

var arch:archivo;

    procedure cargarArchivo(var arch:archivo);
    var carga:text; reg:especies;
    begin
        //Asigno los nombres a los archivos
        assign(carga,'carga.txt'); assign(arch,'archivo.dat');
        //Abro los archivos
        rewrite(arch);reset(carga);
        //Cargo los registros
        while(not eof (carga))do
        begin
            with reg do
            begin
                readln(carga,cod,familia,desc,zona,nom);
                write(arch,reg);
            end;
        end;
        //Cierro los archivos
        close(arch);close(carga);
    end;


begin
    //Se dispone
    cargarArchivo(arch);
    marcarRegistros(arch);
    



end.