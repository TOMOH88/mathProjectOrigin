package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.LoginManager;

/**
 * Servlet implementation class AdminLogoutServlet
 */
@WebServlet("/alogout")
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Cookie[] cookies = request.getCookies();
		LoginManager login = new LoginManager();
		if(session != null) {
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("adminid")) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);	
						System.out.println("쿠키 삭제");
					}
				}
			}
				String name = (String)session.getAttribute("admin");
				System.out.println("세션 네임 : "+ name);
				login.removeSession(name);
				System.out.println("세션삭제");
				response.sendRedirect("/math/admin.jsp");		
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
