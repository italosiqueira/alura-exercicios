package br.com.caelum.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OiMundo
 */
@WebServlet("/oi")
public class OiMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OiMundo() {
        super();
    }
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter response = res.getWriter();
		
		response.println("<!DOCTYPE html>");
		response.println("<html>");
		response.println("<head>");
		response.println("<meta charset=\"ISO-8859-1\">");
		response.println("<title>Oi - Curso Servlet Parte 1: Fundamentos da programação web Java</title>");
		response.println("</head>");
		response.println("<body>");
		response.println("<h1>Olá Servlet!");		
		response.println("</body>");
		response.println("</html>");
	}

}
