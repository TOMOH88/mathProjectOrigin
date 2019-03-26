package popup.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import popup.model.service.PopupService;

/**
 * Servlet implementation class PopupBackServlet
 */
@WebServlet("/pback")
public class PopupBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopupBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int popupNo = Integer.parseInt(request.getParameter("no"));
		
		int popupBack = new PopupService().popupBack(popupNo);

		if(popupBack < popupNo) {
			response.sendRedirect("/math/ndetail?no="+popupBack);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/popup/popupError.jsp");
			request.setAttribute("message", "페이지 이동 불가");
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
