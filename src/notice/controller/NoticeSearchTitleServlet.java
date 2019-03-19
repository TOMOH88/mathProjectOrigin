package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeSearchTitleServlet
 */
@WebServlet("/nsearcht")
public class NoticeSearchTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String searchTitle = request.getParameter("title");
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 5;
		NoticeService nservice = new NoticeService();
		int titleListCount = nservice.titleListCount(searchTitle);
		
		ArrayList<Notice> nList = nservice.searchTitleNotice(searchTitle, currentPage, limit);
		
		int maxPage = (int)((double)titleListCount / limit + 0.9);
		int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(nList.size() > 0) {
			view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
			request.setAttribute("nList", nList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", titleListCount);
			request.setAttribute("searchTitle", searchTitle);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", "검색이 불가능합니다.");
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
