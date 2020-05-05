package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ConnectionFactory;
import dao.PaisDAO;
import model.Pais;
import service.PaisService;

@WebServlet("/Pais.do")
public class PaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("pais");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		
		Pais pais = new Pais();
		Pais pais1 = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(Long.parseLong(pPopulacao));
		pais.setArea(Double.parseDouble(pArea));
		
		PaisService ps = new PaisService();
		ps.criar(pais);
		
		pais1 = ps.carregar(pais);
		System.out.println("PAIS: " + pais1);
		
        request.setAttribute("pais1", pais1);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Pais.jsp");
        view.forward(request, response);
	}
}
