package mundo;

public class AreasProceso {

	private String codigo;

	private String nombre;

	private String proposito;

	public AreasProceso(String codigo, String nombre, String proposito) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.proposito = proposito;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	@Override
	public String toString() {
		return  codigo + " " + nombre;
	}
	


}
