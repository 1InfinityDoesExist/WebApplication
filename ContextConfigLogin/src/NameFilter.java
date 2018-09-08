import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameFilter implements Filter {
	public NameFilter() {

	}

	public void init(FilterConfig fconfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fchain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String pass = req.getParameter("password");
		if(pass.length() > 4)
		{
			fchain.doFilter(req, res);
		}
		else
		{
			out.println("Too SortPassword");
			RequestDispatcher rd = req.getRequestDispatcher("NewUserRegister.jsp");
			rd.include(req, res);
		}
	}

	public void destroy() {

	}

}
