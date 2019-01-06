package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		
		Banco banco = new Banco();
		
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		
		banco.adiciona(empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresa.jsp");
		request.setAttribute("nomeEmpresa", nome);
		rd.forward(request, response);
		
	}

}
