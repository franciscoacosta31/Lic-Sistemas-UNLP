package ar.edu.unlp.info.oo2.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Socio> socios;
	private VoorheesExporter exporter;

	public Biblioteca() {
		socios = new ArrayList<>();
		exporter= new VoorheesExporter(); 
	}

	public void agregarSocio(Socio socio) {
		socios.add(socio);
	}

	/**
	 * Retorna la representación JSON de la colección de socios.
	 */
	public String exportarSocios() {
		return exporter.exportar(socios);
	}

	public VoorheesExporter getExporter() {
		return exporter;
	}

	public void setExporter(VoorheesExporter exporter) {
		this.exporter = exporter;
	}
	
	public static void main (String args[]) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
		biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
		biblioteca.setExporter(new JsonSimpleAdapter());
		System.out.println(biblioteca.exportarSocios());
	}
}
