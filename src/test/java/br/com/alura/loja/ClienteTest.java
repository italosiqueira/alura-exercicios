package br.com.alura.loja;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.modelo.Projeto;

public class ClienteTest {
	
	private HttpServer servidor;
	private Client client;
	private WebTarget target;

	@Before
	public void inicializarServidor() throws URISyntaxException {
		this.servidor = Servidor.startaServidor();
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		client = ClientBuilder.newClient(config);
		target = client.target("http://localhost:8080");
	}
	
	@After
	public void fecharServidor() {
		this.servidor.stop();
	}
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		String conteudo = target.path("/carrinhos/1").request().get(String.class);
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		System.out.println(carrinho.getRua());
		assertTrue(carrinho.getRua().contains("Rua Vergueiro 3185"));
	}
	
	@Test
	public void testaQueBuscarUmProjetoTrazOProjetoEsperado() {
		String conteudo = target.path("/projetos/1").request().get(String.class);
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		System.out.println(projeto.getNome());
		assertEquals("Minha loja", projeto.getNome());
	}
	
	@Test
	public void testaQueGravarUmCarrinhoRetornaSucesso() {
		
		Carrinho carrinho = new Carrinho();
		carrinho.adiciona(new Produto(314L, "XBox One S", 1499.00, 1));
		String xml = carrinho.toXML();
		
		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);
		Response response = target.path("/carrinhos").request().post(entity );
		assertEquals(201, response.getStatus());
		
		String location = response.getHeaderString("Location");
		System.out.println(location);
		String conteudo = client.target(location).request().get(String.class);
		assertTrue(conteudo.contains("XBox"));
		
	}
}
