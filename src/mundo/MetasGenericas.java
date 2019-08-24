package mundo;

import java.util.ArrayList;

public class MetasGenericas {

	private String codigo;

	private String descripcion;

	private String nivel;

	private ArrayList<GP> practicasGenericas;

	private GP gg;

	public MetasGenericas(String codigo, String descripcion, String nivel, ArrayList<GP> practicasGenericas) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.practicasGenericas = practicasGenericas;
	}

	public MetasGenericas(String codigo, String descripcion, String nivel) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nivel = nivel;
	}

	public MetasGenericas() {
		practicasGenericas = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public ArrayList<GP> getPracticasGenericas() {
		return practicasGenericas;
	}

	public void setPracticasGenericas(ArrayList<GP> practicasGenericas) {
		this.practicasGenericas = practicasGenericas;
	}

	public GP getGg() {
		return gg;
	}

	public void setGg(GP gg) {
		this.gg = gg;
	}

	@Override
	public String toString() {
		return "MetasGenericas [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

}
