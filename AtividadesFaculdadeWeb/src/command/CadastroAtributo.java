package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroAtributo implements Command {	
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pReq = request.getParameter("req");
		String pSes = request.getParameter("ses");
		String pApp = request.getParameter("app");
		
		request.setAttribute("sReq", pReq); // Setando no escopo de requisição
		request.getSession().setAttribute("sSes", pSes); // Setando no escopo de sessão.

		RequestDispatcher view =
				request.getRequestDispatcher("listaAtributos.jsp");
				view.forward(request, response);
	}

}
