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

public class IDFilter implements Filter {
	public IDFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fchain) throws IOException, ServletException 
	{
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String un = req.getParameter("uname");
		if(un.length() > 4)
		{
			fchain.doFilter(request, response);
		}
		else
		{
			out.println("UserName Not Suitable");
			RequestDispatcher rd = request.getRequestDispatcher("NewUserRegister.jsp");
			rd.include(request, response);
		}
	}

	public void destroy() {

	}

}
