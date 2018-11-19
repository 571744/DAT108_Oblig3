package no.hvl.dat108;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loggut")
public class LoggUtServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Inn noe kode her i forbindelse med utlogging av bruker?
        
    	HttpSession sesjon = request.getSession(false);
    	if(sesjon != null) {
    		sesjon.invalidate();
    	} 
    	request.getRequestDispatcher("WEB-INF/ferdig_MAL.jsp").forward(request, response);

    }
}
