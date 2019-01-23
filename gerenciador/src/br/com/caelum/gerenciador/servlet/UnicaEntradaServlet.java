package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.AlteraEmpresa;
import br.com.caelum.gerenciador.acao.ListaEmpresas;
import br.com.caelum.gerenciador.acao.MostraEmpresa;
import br.com.caelum.gerenciador.acao.NovaEmpresa;
import br.com.caelum.gerenciador.acao.NovaEmpresaForm;
import br.com.caelum.gerenciador.acao.RemoveEmpresa;

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
		String nome = null;
		
		
		if (paramAcao.equals("listaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);			
		} else if (paramAcao.equals("mostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);			
		} else if (paramAcao.equals("alteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("removeEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("novaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("novaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			nome = acao.executa(request, response);
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
