package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/skjema")
public class SkjemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerEAO DeltakerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema_MAL.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			Skjema skjema = new Skjema(request);
		

		if (skjema.isAllInputGyldig()) {

			Deltaker deltaker = skjema.lagDeltaker();

			if (DeltakerEAO.hentAlleDeltakere() != null) {
				if (DeltakerEAO.hentDeltakerPaaPK(deltaker.getMobilnummer()) == null) {

					DeltakerEAO.leggTilDeltaker(deltaker);
					request.getSession().removeAttribute("skjema");
					request.getSession().removeAttribute("bruker");
					request.getSession().setAttribute("bruker", deltaker);
					response.sendRedirect("paameldingsbekreftelse");
				} else {
					skjema.alleredeRegistrert();
					request.getSession().setAttribute("skjema", skjema);
					response.sendRedirect("skjema");
				}
			}
		} else {

			skjema.genererFeilmeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("skjema");
		}
	}

}
