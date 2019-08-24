package mundo;

import java.util.ArrayList;

public class Constelaciones {
	
	private ArrayList<AreasProceso> areas;
	
	private ArrayList<MetasGenericas> metasGenericas;

	public ArrayList<AreasProceso> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<AreasProceso> areas) {
		this.areas = areas;
	}

	public Constelaciones(ArrayList<AreasProceso> areas) {
		super();
		this.areas = areas;
	}
	
	public  Constelaciones() {
		areas = new ArrayList<>();
		metasGenericas = new ArrayList<>();
	}

	public ArrayList<MetasGenericas> getMetasGenericas() {
		return metasGenericas;
	}

	public void setMetasGenericas(ArrayList<MetasGenericas> metasGenericas) {
		this.metasGenericas = metasGenericas;
	}
	
}
