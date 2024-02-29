package apis;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;

import dto.RespuestaMunicipios;
import models.Municipio;

public class ArgentinaGeoApi {
	private String baseUrl;
	private Gson gson;

	public ArgentinaGeoApi() {
		this.baseUrl = "https://apis.datos.gob.ar/georef/api";
		this.gson = new Gson();
	}

	public Municipio getMunicipio(String id) throws ClientProtocolException, IOException {
		var url = this.baseUrl + "/municipios?id=" + id;

		System.out.println(url);
		var respuestaApi = Request.Get(url).execute();

		var jsonRespuesta = respuestaApi.returnContent().asString();

		var respuesta = gson.fromJson(jsonRespuesta, RespuestaMunicipios.class);

		return respuesta.getMunicipios()[0];

	}
	public List<Municipio> getMunicipios() throws ClientProtocolException, IOException{
		return getMunicipios(5000);
	}

	public List<Municipio> getMunicipios(int limit) throws ClientProtocolException, IOException {
		var url = this.baseUrl + "/municipios?max="+limit;

		System.out.println(url);
		var respuestaApi = Request.Get(url).execute();

		var jsonRespuesta = respuestaApi.returnContent().asString();

		var respuesta = gson.fromJson(jsonRespuesta, RespuestaMunicipios.class);
		
		return Stream.of(respuesta.getMunicipios()).toList();

	}

}