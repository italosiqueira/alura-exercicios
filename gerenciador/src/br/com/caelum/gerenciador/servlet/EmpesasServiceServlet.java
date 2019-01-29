package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.caelum.gerenciador.modelo.Banco;
import br.com.caelum.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EmpesasServiceServlet
 */
@WebServlet("/empresas")
public class EmpesasServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		
		List<Empresa> empresas = banco.getEmpresas();
		
		String content = null;
		
		String acceptParam = request.getHeader("Accept");
		
		if (acceptParam.endsWith("json")) {
			content = asJsonContent(empresas);
			response.setContentType("application/json");
		} else if (acceptParam.endsWith("xml")) {
			content = asXmlContent(empresas);
			response.setContentType("application/xml");
		} else {
			content = "{\"message\":\"no content\"}";
			response.setContentType("application/json");
		}
		
		response.getWriter().append(content);
	}

	private String asJsonContent(List<Empresa> empresas) {
		Gson gson = new Gson();
		
		String jsonContent = gson.toJson(empresas);
		return jsonContent;
	}

	private String asXmlContent(List<Empresa> empresas) {
		XStream stream = new XStream();
		
		stream.alias("empresas", List.class);
		stream.alias("empresa", Empresa.class);
		
		String xmlContent = stream.toXML(empresas);
		
		return xmlContent;
	}
}
