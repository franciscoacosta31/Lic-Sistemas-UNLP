procedure PosicionarYLeerNodo(var A: archivo_indices; var nodo: nodo; NRR: integer);
begin
    reset(A);
    seek(A,NRR);
    read(A,nodo);
    close(A);
end;

{Se posiciona en un nodo del archivo de indices, lo lee y lo devuelve}