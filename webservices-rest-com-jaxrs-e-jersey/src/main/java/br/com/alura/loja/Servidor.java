package br.com.alura.loja;

import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static HttpServer startaServidor() throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/");
		ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config );
		
		return server;
	}
	
	public static void main(String[] args) {
		try {
			HttpServer servidor = startaServidor();
			System.out.println("Servidor iniciado...");
			System.in.read();
			servidor.stop();
			System.out.println("Servidor parado");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
