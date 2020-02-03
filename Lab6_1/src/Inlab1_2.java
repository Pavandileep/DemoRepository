

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inlab1_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Inlab1_2() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext app=getServletContext();
		ServletConfig config=getServletConfig();
		
		String question1,question2,answer1,answer2;
		int count=0;
		question1=app.getInitParameter("q1");
		question2=app.getInitParameter("q2");
		answer1=config.getInitParameter("q1");
		answer2=config.getInitParameter("q2");
		
		if(answer1.equals(question1))
		{
			count++;
	
		}
			
		if(answer2.equals(question2))
		{
			count++;
		}
		request.setAttribute("count", count);
		RequestDispatcher rd=request.getRequestDispatcher("Score");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
