import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Login extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("name");
		String pass = request.getParameter("password");
		LoginDao d = new LoginDao();
		if(d.validte(uname, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("userName", uname);
			
			response.sendRedirect("Welcome.jsp");
		}
		else
		{
			out.println("Your Have Entered Wrong Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("SignIn.jsp");
			rd.include(request, response);
		}
		
	}
}
