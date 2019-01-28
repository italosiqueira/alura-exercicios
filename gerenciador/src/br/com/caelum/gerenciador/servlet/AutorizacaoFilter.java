package br.com.caelum.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filtering user...");
		
		String paramAcao = request.getParameter("acao");
		boolean ehAcaoProtegida = !("LoginForm".equals(paramAcao) || "Login".equals(paramAcao));
		boolean usuarioNaoEstaLogado = ((HttpServletRequest) request).getSession().getAttribute("usuarioLogado") == null;
		
		if (usuarioNaoEstaLogado && ehAcaoProtegida) {
			((HttpServletResponse) response).sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
