package ar.edu.unlp.info.oo1.Ejercicio17;

import java.util.Collection;
import java.util.List;

public interface DatabaseAccess {

	/**
	    * Realiza la inserción de nueva información en la base de datos y 
	    * retorna el id que recibe la nueva inserción
	    *
	    * @param rowData
	    * @return
	*/
    public Collection<String> getSearchResults(String queryString);

    /**
     * Retorna una colección de acuerdo al texto que posee "queryString"
     *
     * @param queryString
     * @return
     */
    public int insertNewRow(List<String> rowData);
}