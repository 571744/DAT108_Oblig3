package no.hvl.dat108;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BekreftelseServlet
 */
@WebServlet("/paameldingsbekreftelse")
public class BekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		if(sesjon == null || sesjon.getAttribute("bruker") == null) {
			response.sendRedirect("logginn" + "?noSession");
		}
		else {
		request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse_MAL.jsp").forward(request, response);
		
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
