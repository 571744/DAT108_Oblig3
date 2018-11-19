package no.hvl.dat108;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerEAO deltakerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().removeAttribute("nosession");
		HttpSession sesjon = request.getSession(false);

		if (sesjon != null && sesjon.getAttribute("bruker") != null) {
			response.sendRedirect("deltakerliste" + "?alreadyLoggedIn");
		} else {
			if (request.getParameter("nosession") != null) {
				String noSession = "Du må logge inn eller registrere deg for å se denne siden.";
				request.getSession().setAttribute("nosession", noSession);
			} 
			request.getRequestDispatcher("WEB-INF/logginn_MAL.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Logginn logginn = new Logginn(request, deltakerEAO);

		if (logginn.sjekkLogginn()) {

			Deltaker deltaker = logginn.hentDeltaker();

			HttpSession sesjon = request.getSession(false);

			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			
			sesjon.setMaxInactiveInterval(100);

			sesjon.setAttribute("bruker", deltaker);

			response.sendRedirect("deltakerliste");

		} else {
			
			logginn.genererFeilmelding();
			request.getSession().removeAttribute("nosessionfeil");
			request.getSession().setAttribute("logginn", logginn);
			response.sendRedirect("logginn");
			
		}

	}
}
