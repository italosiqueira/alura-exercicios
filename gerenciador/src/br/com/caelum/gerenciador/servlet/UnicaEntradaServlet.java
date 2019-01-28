package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.IAcao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = null;
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.caelum.gerenciador.acao." + paramAcao;
		
		/*
		 * O mecanismo de instanciação das classes de ações agora está mais 
		 * genérico e deve seguir algumas convenções a fim de evitar alterar 
		 * o servlet a cada nova ação criada.
		 */
		try {
			Class classe = Class.forName(nomeDaClasse);
			IAcao acao = (IAcao) classe.newInstance();
			nome = acao.executa(request, response);			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String link[] = nome.split(":");
		
		if (link[0].equalsIgnoreCase("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/" + link[1]);
			rd.forward(request, response);
		} else if (link[0].equalsIgnoreCase("redirect")) {
			response.sendRedirect(link[1]);
		}
		
		
	}

}
