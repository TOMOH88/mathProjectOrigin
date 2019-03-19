package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.LoginManager;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session =request.getSession();
		String userId= request.getParameter("email");
		String userPwd = request.getParameter("password");
		LoginManager loginManager = LoginManager.getInstance(); 
		RequestDispatcher view=null;
		if(loginManager.isValid(userId, userPwd)) {
			response.setContentType("text/html; charset=utf-8"); 
			//접속자 아이디를 세션에 담는다.
	        session.setAttribute("userId", userId);    
	        //이미 접속한 아이디인지 체크한다.
	        loginManager.printloginUsers();
	        if(loginManager.isUsing(userId)){   
	        	if(userId != null){
	                view = request.getRequestDispatcher("/views/member/memberError.jsp");
	    			request.setAttribute("message", "이미 아이디가 사용중입니다.");
	    			view.forward(request, response);
	            }
	        }else{
	            loginManager.setSession(session, userId);
	            response.sendRedirect("/math/views/main/main.jsp");
	        }
		}else {
			view = request.getRequestDispatcher("/views/member/memberError.jsp");
			request.setAttribute("message", "로그인실패!");
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
