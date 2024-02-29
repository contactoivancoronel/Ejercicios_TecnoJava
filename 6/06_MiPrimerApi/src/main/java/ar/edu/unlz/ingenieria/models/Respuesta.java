package ar.edu.unlz.ingenieria.models;

public class Respuesta {

	private int status;
	private String mensaje;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Respuesta(int status, String mensaje) {
		super();
		this.status = status;
		this.mensaje = mensaje;
	}

}
