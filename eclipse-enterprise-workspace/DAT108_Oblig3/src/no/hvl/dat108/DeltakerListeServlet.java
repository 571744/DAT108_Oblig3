package no.hvl.dat108;

import java.io.IOException;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeltakerListeServlet
 */
@WebServlet("/deltakerliste")
public class DeltakerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private DeltakerEAO deltakerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		if(sesjon == null || sesjon.getAttribute("bruker") == null) {
			response.sendRedirect("logginn" + "?nosession");
		}
		else {
			
			List<Deltaker> deltakerliste = deltakerEAO.hentAlleDeltakere();
			
			Deltaker.sorter(deltakerliste);
			
			request.getSession().setAttribute("deltakere", deltakerliste);
			
			request.getRequestDispatcher("WEB-INF/deltagerliste_MAL.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	

}
