package practica3.ejercicio10;
import java.util.*;

public class Maximo {
	private int max_count = -1;
	private List<Integer> max_list;
	
	public Maximo() {
		this.max_count = 0;
		this.max_list = new LinkedList<Integer>();
	}

	public int getMax_count() {
		return max_count;
	}

	public void setMax_count(int max_count) {
		this.max_count = max_count;
	}

	public List<Integer> getMax_list() {
		return max_list;
	}
}
