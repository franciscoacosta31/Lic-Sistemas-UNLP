procedure claveEncontrada(nodo:nodo; clave:integer; var pos:integer; var clave_encontrada:boolean);
begin
    for(pos:= 1; pos++; pos<M-1)do
    begin
        if(nodo.claves[pos] = clave) then
        begin
            clave_encontrada:= True;
            break;
        end;
    end;
end;

{ Recorre el vector de claves de un nodo buscando la clave indicada. Devuelve un boolean y la posicion en el vector }