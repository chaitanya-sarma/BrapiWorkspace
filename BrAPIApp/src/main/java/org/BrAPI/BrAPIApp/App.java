package org.BrAPI.BrAPIApp;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hellooooooooooo World!" );
        Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://bms.icrisat.ac.in:48080/bmsapi/authenticate");
								//	.queryParam("username", "arathore")
								//	.queryParam("password", "abcd@1234");
		Form formData = new Form();
		formData.param("username", "arathore");
		formData.param("password", "abcd@1234");
		Response response =	webTarget.request().post(Entity.form(formData));
		System.out.println(response.getStatus());
		String res = response.readEntity(String.class);
		System.out.println(res);
		
		JsonParser parser = new JsonParser(); 
		JsonObject json = (JsonObject) parser.parse(res);
		System.out.println(json.get("token"));
		System.out.println(json.get("expires"));
		String token = json.get("token").getAsString();
		System.out.println(token);
		
		WebTarget webTarget1 = client.target("http://bms.icrisat.ac.in:48080/bmsapi/program/list");
		Response response1 =	webTarget1.request().header("X-Auth-Token", token).get();
		System.out.println(response1.getStatus());
		String res1 = response1.readEntity(String.class);
		System.out.println(res1);
    }
}
