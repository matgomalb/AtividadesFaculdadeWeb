package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

@WebServlet("/logout.do")
public class PaisLogoutController {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pNome = request.getParameter("nome");
		String pArea = request.getParameter("area");
		String pPopolacao = request.getParameter("populacao");
		
		Pais p = new Pais();
		p.setNome(pNome);
		p.setArea(Double.parseDouble(pArea));
		p.setPopulacao(Long.parseLong(pPopolacao));
		
		PaisService ps = new PaisService();
		ps.criar(p);
		ps.carregar(p);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"id: "+p.getId()+"<br>");
		out.println(	"nome: "+p.getNome()+"<br>");
		out.println(	"fone: "+p.getArea()+"<br>");
		out.println(	"e-mail: "+p.getPopulacao()+"<br>");
	    out.println("</body></html>");
		
		request.setAttribute("flu1", null);
		request.getSession().setAttribute("flu2", null);
		request.getServletContext().setAttribute("flu3", null);

		RequestDispatcher view =
		request.getRequestDispatcher("listaAtributos.jsp");
		view.forward(request, response);
		
	}	
}