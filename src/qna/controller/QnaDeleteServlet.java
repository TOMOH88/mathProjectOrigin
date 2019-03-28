package qna.controller;

import java.io.IOException;
<<<<<<< HEAD
=======

import javax.servlet.RequestDispatcher;
>>>>>>> ysy2
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import qna.model.service.QnaService;

>>>>>>> ysy2
/**
 * Servlet implementation class QnaDeleteServlet
 */
@WebServlet("/qdelete")
public class QnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
		int qnaNo = Integer.parseInt(request.getParameter("no"));
		
		int result = new QnaService().qnaDelete(qnaNo);
		
		if(result > 0) {
			response.sendRedirect("/math/quslist");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/qna/qnaError.jsp");
			request.setAttribute("message", qnaNo + "번 글삭제 실패" );
			view.forward(request, response);
		}
>>>>>>> ysy2
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
