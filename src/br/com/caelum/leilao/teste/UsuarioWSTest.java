package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Usuario;

public class UsuarioWSTest {
	
	private static Usuario usuarioAniche;
	private static Usuario usuarioSilveira;

	@Before
	public static void init() {
		usuarioAniche = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		usuarioSilveira = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
		
		// Exemplo de configuração da biblioteca
		/*
		 * RestAssured.baseURI = "http://www.meuendereco.com.br";
		 * RestAssured.port = 80;
		 */
	}
	
	@Test
	public void deveRetornarListaDeUsuarios() {
		XmlPath path = given().header("Accept", "application/xml").get("/usuarios").andReturn().xmlPath();
		
		List<Usuario> usuarios = path.getList("list.usuario", Usuario.class);
		
		assertEquals(usuarioAniche, usuarios.get(0));
		assertEquals(usuarioSilveira, usuarios.get(1));
	}
	
	@Test
	public void deveRetornarUsuarioPeloId() {
		JsonPath path = 
				given()
				.header("Accept", "application/json")
				.parameter("usuario.id", 1)
				.get("/usuarios/show")
				.andReturn().jsonPath();
		
		assertEquals(usuarioAniche, path.getObject("usuario", Usuario.class));
	}
	
	@Test
	public void deveAdicionarUsuario() {
		Usuario usuario = new Usuario("Italo Siqueira Lima", "italo.lima@siqueira.com.br");
		
		XmlPath path = 
					given()
						.header("Accept", "application/xml")
						.contentType("application/xml")
						// Objeto serializado de acordo com o formato indicado em "Content-Type" (cortesia do REST-Assured)
						.body(usuario)
					.expect()
						.statusCode(200)
					.when()
						.post("/usuarios")
					.andReturn()
						.xmlPath();
		
		Usuario resposta = path.getObject("usuario", Usuario.class);
		
		assertEquals("Italo Siqueira Lima", resposta.getNome());
		assertEquals("italo.lima@siqueira.com.br", resposta.getEmail());
	}

}
