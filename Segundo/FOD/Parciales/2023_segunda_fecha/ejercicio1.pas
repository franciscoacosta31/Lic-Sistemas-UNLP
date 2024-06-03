program parcial;
const
	valoralto = 9999;
type
	partido = record
		cod_equipo:integer;
		nom_equipo:string;
		año:integer;
		torneo:integer;
		rival:integer;
		goles_favor:integer;
		goles_contra:integer;
		puntos:integer;
	end;
	
	partidos = file of partido;
	
procedure leer(var A:partidos; var P:partido);
begin
	if(not EOF(A))then
		read(A,P)
	else
		P.año:= valoralto;
end;

procedure corteDeControl(var A:partidos);
var
	p:partido;
	año,torneo,cod_equipo,goles_favor,goles_contra,ganados,perdidos,empatados,puntos,maxpuntos:integer;
	nom_equipo,nom_campeon:string;
begin
	reset(A);
	leer(A,p);
	while(p.año <> valoralto)do
	begin
		año:= p.año;
		writeln('Año ',año);
		while(p.año = año)do
		begin
			torneo:= p.torneo;
			maxpuntos:= -1;
			writeln(torneo);
			while(p.año = año)and(p.torneo = torneo)do
			begin
				cod_equipo:= p.cod_equipo;
				nom_equipo:= p.nom_equipo;
				writeln(cod_equipo,' ',nom_equipo);
				goles_favor:= 0;goles_contra:= 0;ganados:= 0;perdidos:= 0;empatados:= 0;puntos:= 0;
				while(p.año = año)and(p.torneo = torneo)and(p.cod_equipo = cod_equipo)do
				begin
					goles_favor:= goles_favor + p.goles_favor;
					goles_contra:= goles_contra + p.goles_contra;
					case p.puntos of
						0: perdidos:= perdidos + 1;
						1: empatados:= empatados + 1;
						3: ganados:= ganados + 1;
					end;
					puntos:= puntos + p.puntos;
					leer(A,p);
				end;
				if(puntos > maxpuntos) then
				begin
					maxpuntos:= puntos;
					nom_campeon:= nom_equipo; 
				end;
				writeln(goles_favor); writeln(goles_contra); writeln(goles_favor-goles_contra);
				writeln(ganados); writeln(perdidos); writeln(empatados); writeln(puntos);	
			end;
			writeln('El equipo ',nom_campeon,' fue campeón del torneo ',torneo,' del año ',año);
		end;
	end;
	close(A);
end;
