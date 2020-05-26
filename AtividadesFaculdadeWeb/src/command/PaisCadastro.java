package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaisCadastro implements Command {
					
		@Override
		public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pReq = request.getParameter("req");
			String pSes = request.getParameter("ses");
			String pApp = request.getParameter("app");
	
			request.setAttribute("flu1", pReq); // Setando no escopo de requisi��o
			request.getSession().setAttribute("flu2", pSes); // Setando no escopo de sess�o.
			
			RequestDispatcher view = 
				request.getRequestDispatcher("listaAtributos.jsp");
					view.forward(request, response);

		}
}
