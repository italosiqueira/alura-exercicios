package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.gerenciador.acao.IAcao;

@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String nome = null;
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.caelum.gerenciador.acao." + paramAcao;
		
		/*
		 * O mecanismo de instanciação das classes de ações agora está mais 
		 * genérico e deve seguir algumas convenções a fim de evitar alterar 
		 * o servlet a cada nova ação criada.
		 */
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletReponse = (HttpServletResponse) response;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			IAcao acao = (IAcao) classe.newInstance();
			nome = acao.executa(httpServletRequest, httpServletReponse);			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String link[] = nome.split(":");
		
		if (link[0].equalsIgnoreCase("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/" + link[1]);
			rd.forward(request, httpServletReponse);
		} else if (link[0].equalsIgnoreCase("redirect")) {
			httpServletReponse.sendRedirect(link[1]);
		}

	}

}
