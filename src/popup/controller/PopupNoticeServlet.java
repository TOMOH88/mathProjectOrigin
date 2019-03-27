package popup.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import popup.model.vo.Popup;

/**
 * Servlet implementation class PopupNoticeServlet
 */
@WebServlet("/npopup")
public class PopupNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopupNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Popup> plist = new ArrayList<Popup>();
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(plist.size() > 0) {
			view = request.getRequestDispatcher("views/main/main.jsp");
			request.setAttribute("plist", plist);
			view.forward(request, response);
			System.out.println("plist" + plist);
		}else {
			view = request.getRequestDispatcher("views/popup/popupError.jsp");
			request.setAttribute("message", "조회 불가");
			view.forward(request, response);
			System.out.println("0");
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
