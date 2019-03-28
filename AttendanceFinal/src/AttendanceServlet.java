

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class AttendanceServlet
 */
@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String combo = request.getParameter("box");
		int rollNo = Integer.parseInt(combo);
		String P = request.getParameter("p");
		String A = request.getParameter("a");
		out.println(combo);
		out.println(P);
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java","root","root");
			String update="update Attendance set Present=?, Absent=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, P);
			preparedStatement.setString(2, A);
			preparedStatement.setInt(3, rollNo);
			int set = preparedStatement.executeUpdate();
			if(set>0)
			{
				response.sendRedirect("Home.jsp");
			}
			else
			{
				response.sendRedirect("Login.html");
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
