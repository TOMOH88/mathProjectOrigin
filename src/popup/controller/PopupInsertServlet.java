package popup.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import popup.model.service.PopupService;
import popup.model.vo.Popup;

/**
 * Servlet implementation class PopupInsertServlet
 */
@WebServlet("/pinsert")
public class PopupInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopupInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		request.setCharacterEncoding("utf-8");
		Popup popup = new Popup();
		
		popup.setPopupName(request.getParameter("ptitle"));
		popup.setPopupLink(request.getParameter("plink"));
		popup.setPopupDate(Date.valueOf(request.getParameter("startDate")));
		popup.setPopupEndDate(Date.valueOf(request.getParameter("endDate")));
		popup.setPopupImagePath(request.getParameter("imagelink"));
		popup.setPopupExplan(request.getParameter("discrip"));
		
		int result = new PopupService().insertPopup(popup);
		if(result > 0) {
			view = request.getRequestDispatcher("views/popup/popupWriteView.jsp");
			request.setAttribute("popup", popup);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/popup/popupError.jsp");
			request.setAttribute("message", "글등록 실패!");
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
