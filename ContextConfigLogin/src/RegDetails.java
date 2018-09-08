import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegDetails extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String n = request.getParameter("uname");
		String p = request.getParameter("password");
		request.setAttribute("un", n);
		request.setAttribute("ps", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("rej");
		rd.forward(request, response);
	}
}
