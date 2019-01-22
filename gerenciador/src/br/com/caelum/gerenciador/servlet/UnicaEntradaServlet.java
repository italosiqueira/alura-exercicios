package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.AlteraEmpresa;
import br.com.caelum.gerenciador.acao.ListaEmpresas;
import br.com.caelum.gerenciador.acao.MostraEmpresa;

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
		String paramAcao = request.getParameter("acao");
		
		if (paramAcao.equals("listaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(request, response);			
		} else if (paramAcao.equals("mostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);			
		} else if (paramAcao.equals("alteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			acao.executa(request, response);
		}
		
	}

}
