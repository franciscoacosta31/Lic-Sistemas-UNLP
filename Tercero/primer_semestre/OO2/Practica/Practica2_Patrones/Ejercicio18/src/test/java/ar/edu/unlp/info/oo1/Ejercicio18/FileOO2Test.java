package ar.edu.unlp.info.oo1.Ejercicio18;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileOO2Test {

	private FileOO2Interface fileOO2;
	private FileOO2Interface extensionDecorator;
	private FileOO2Interface tamañoDecorator;
	private FileOO2Interface fechaCreacionDecorator; 
	private FileOO2Interface fechaModificacionDecorator;
	private FileOO2Interface permisosDecorator;
	private FileOO2Interface todosLosDecorator;
	
	@BeforeEach
	void setUp() throws Exception {
		this.fileOO2 = new FileOO2("file", ".exe", "50MB", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 2, 2), "User");
		this.extensionDecorator = new ExtensionDecorator(this.fileOO2);
		this.tamañoDecorator = new TamañoDecorator(this.fileOO2);
		this.fechaCreacionDecorator = new FechaCreacionDecorator(this.fileOO2);
		this.fechaModificacionDecorator = new FechaModificacionDecorator(this.fileOO2);
		this.permisosDecorator = new PermisosDecorator(this.fileOO2);
		this.todosLosDecorator = new PermisosDecorator(new FechaModificacionDecorator(new FechaCreacionDecorator(new TamañoDecorator(new ExtensionDecorator(fileOO2)))));
	}

	@Test
	void testPrettyPrint() {
		assertEquals(this.fileOO2.prettyPrint(), "file");
		assertEquals(this.extensionDecorator.prettyPrint(), "file - .exe");
		assertEquals(this.tamañoDecorator.prettyPrint(), "file - 50MB");
		assertEquals(this.fechaCreacionDecorator.prettyPrint(), "file - 2025-01-01");
		assertEquals(this.fechaModificacionDecorator.prettyPrint(), "file - 2025-02-02");
		assertEquals(this.permisosDecorator.prettyPrint(), "file - User");
		assertEquals(this.todosLosDecorator.prettyPrint(), "file - .exe - 50MB - 2025-01-01 - 2025-02-02 - User");
	}


}
