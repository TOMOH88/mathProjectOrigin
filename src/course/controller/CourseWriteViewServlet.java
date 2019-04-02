package course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.service.CourseService;
import course.model.vo.Book;
import course.model.vo.Semester;

/**
 * Servlet implementation class CourseWriteViewServlet
 */
@WebServlet("/cwview")
public class CourseWriteViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseWriteViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseService cservice = new CourseService();
		ArrayList<Semester> semList = cservice.semList();
		ArrayList<Book> bList = cservice.bookList();
		
		RequestDispatcher view = null;
		if(semList.size() > 0 && bList.size() > 0) {
			view = request.getRequestDispatcher("views/course/courseWriteView.jsp");
			request.setAttribute("semList", semList);
			request.setAttribute("bList", bList);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/course/courseError.jsp");
			request.setAttribute("message", "페이지오류");
			view.forward(request, response);
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
