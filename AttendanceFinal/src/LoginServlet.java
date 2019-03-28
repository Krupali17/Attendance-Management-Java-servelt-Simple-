

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String em = request.getParameter("mail");
		String ps = request.getParameter("pwd");
		out.println(em);
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java", "root", "root");
			out.println(ps);
			String display = "select * from Faculty where Mail=? and Password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(display);
			preparedStatement.setString(1, em);
			preparedStatement.setString(2, ps);
			ResultSet set = preparedStatement.executeQuery();
			if(set.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("ssn", em);
				response.sendRedirect("Home.jsp");
			}
			else
			{
				response.sendRedirect("Signup.html");
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			out.println("Error");
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
