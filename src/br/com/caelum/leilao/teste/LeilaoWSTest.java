package br.com.caelum.leilao.teste;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Leilao;
import br.com.caelum.leilao.modelo.Usuario;

public class LeilaoWSTest {
	
	@Test
	public void deveRetornarLeilaoPeloId() {
		JsonPath path = given()
							.header("Accept", "application/json")
							.queryParam("leilao.id", 1)
							.get("/leiloes/show")
							.andReturn()
							.jsonPath();
		
		
		Leilao leilao = path.getObject("leilao", Leilao.class);
		
		Leilao leilaoGeladeira = new Leilao(
					1L, "Geladeira", 800.0, 
					new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br"),
					false);
		
		assertEquals(leilaoGeladeira, leilao);
	}
	
	@Test
	public void deveRetornarTotalLeiloes() {
		
		int totalEsperado = 2;
		int total = 0;
		
		XmlPath path = 
					given()
					.header("Accept", "application/xml")
					.get("/leiloes/total")
					.andReturn().xmlPath();
		
		total = path.getInt("int");
		
		assertEquals(totalEsperado, total);
		
	}
	
	@Test
	public void deveAdicionarUmLeilao() {
		Leilao leilao = 
				new Leilao(3L, "Dell Inspiron", 2500.00
						, new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br")
						, false);
		
		XmlPath path = given()
			.header("Accept", "application/xml")
			.contentType("application/xml")
			.body(leilao)
		.expect()
			.statusCode(200)
		.when()
			.post("/leiloes")
		.andReturn()
			.xmlPath();
		
		Leilao resposta = path.getObject("leilao", Leilao.class);
		
		assertEquals("Dell Inspiron", resposta.getNome());
		
		given()
			.contentType("application/xml")
			.body(leilao)
		.expect()
			.statusCode(200)
		.when()
			.delete("/leiloes/deletar")
		.andReturn()
			.asString();
		
	}

}
