package ar.edu.unlp.info.oo1.Ejercicio17;

import java.util.Collection;
import java.util.List;

public class DatabaseProxy implements DatabaseAccess{

	private DatabaseRealAccess realSubject;
	private String password;
	private boolean logged;
	
	public DatabaseProxy(String password) {
		this.realSubject = new DatabaseRealAccess();
		this.password = password;
		this.logged = false;
	}
	
	public void login(String password) {
		if (this.password.equals(password))
			this.logged = true;
	}
	
	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.logged) {
			return this.realSubject.getSearchResults(queryString);
		}
		return null;
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.logged) {
			return this.realSubject.insertNewRow(rowData);
		}
		return -1;
	}

	public boolean getLogged() {
		return this.logged;
	}
}
