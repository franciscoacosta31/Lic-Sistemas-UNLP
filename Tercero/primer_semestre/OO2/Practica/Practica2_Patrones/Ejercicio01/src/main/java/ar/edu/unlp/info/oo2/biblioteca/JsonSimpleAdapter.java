package ar.edu.unlp.info.oo2.biblioteca;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleAdapter extends VoorheesExporter {

	public String exportar(List<Socio> socios) {
		JSONArray jsonArray = new JSONArray();
        for (Socio socio : socios) {
            JSONObject json = new JSONObject();
            json.put("nombre", socio.getNombre());
            json.put("email", socio.getEmail());
            json.put("legajo", socio.getLegajo());
            jsonArray.add(json);
        }
        return jsonArray.toJSONString();
	}
}
