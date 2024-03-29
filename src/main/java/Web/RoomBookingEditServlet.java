package Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.RoomsBookingDao;
import Model.RoomBooking;

/**
 * Servlet implementation class RoomBookingEditServlet
 */
@WebServlet("/editRoomBook")
public class RoomBookingEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomsBookingDao RoomsBookingDao;

	public void init() {
		RoomsBookingDao = new RoomsBookingDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomBookingEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();

		int id = Integer.parseInt(request.getParameter("id"));
		RoomBooking existingUser = RoomsBookingDao.selectRoomBooking(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NewRoomBook.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
