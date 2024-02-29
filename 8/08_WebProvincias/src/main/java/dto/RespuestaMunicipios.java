package dto;

import models.Municipio;

public class RespuestaMunicipios {
	private Municipio[] municipios;
	private int total;

	public RespuestaMunicipios(Municipio[] municipios, int total) {
		super();
		this.municipios = municipios;
		this.total = total;
	}

	public Municipio[] getMunicipios() {
		return municipios;
	}

	public void setMunicipios(Municipio[] municipios) {
		this.municipios = municipios;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
