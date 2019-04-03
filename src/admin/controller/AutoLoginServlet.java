package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.LoginManager;

/**
 * Servlet implementation class AutoLoginServlet
 */
@WebServlet("/autologin")
public class AutoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String path = "admin.jsp";
		LoginManager lm = new LoginManager();
		HttpSession session =request.getSession();
		if(cookies != null) {
			
			for(Cookie cookie : cookies) {
				String userid = cookie.getName();
				if(userid.equals("adminid")) {
					
					if(lm.isUsing(cookie.getValue())) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);	
						path="views/memberError.jsp";
						request.setAttribute("message", "이미 아이디가 사용중입니다.");
						break;
					}else {
						lm.setSession(session,cookie.getValue());
						path= "views/main/adminmain.jsp";
						break;
					}
					
				}else {
					path="admin.jsp";
				}
			}
		}else {
			path="admin.jsp";
		}
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
