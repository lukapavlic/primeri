package si.um.feri.aiv.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

	private static String url = "http://localhost:28080/OsebeDemo/rest/osebe";

	public static void main(String[] args) {
		post();
		get();
	}
	
	public static void post() {

		String json = "{\"ime\":\"Peter\",\"priimek\":\"Klepec\",\"email\":\"nekdo23@nekaj.si\",\"kontakti\":[{\"tip\":\"neznan\",\"naziv\":\"Maribor\"}]}";

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url + "/oseba");

		Response response = target.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
		String value = response.readEntity(String.class);
		int status = response.getStatus();
		response.close();

		System.out.println(status);
		System.out.println(value);

	}

	public static void get() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url);

		Response response = target.request().get();
		String value = response.readEntity(String.class);
		int status = response.getStatus();
		response.close();

		System.out.println(status);
		System.out.println(value);
		
	}
}
