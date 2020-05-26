package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Command {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sReq", null);
		request.getSession().setAttribute("sSes", null);

		RequestDispatcher view =
		request.getRequestDispatcher("listaAtributos.jsp");
		view.forward(request, response);
	}

}
