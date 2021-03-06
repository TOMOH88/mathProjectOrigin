package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.LoginManager;
import member.model.service.MemberService;

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
		String keeplogin = request.getParameter("keeplogin");
		System.out.println(keeplogin);
		LoginManager loginManager = LoginManager.getInstance(); 
		RequestDispatcher view=null;
		int ckdId = new MemberService().checkId(userId);
		if(ckdId < 1) {
			view = request.getRequestDispatcher("/views/member/memberError.jsp");
			request.setAttribute("message", "회원 가입후 이용해주세요!");
			view.forward(request, response);
		}else {
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
	        	
	       	if(keeplogin!=null && userId != null){
	    			if(keeplogin.equals("yes")){
	    				Cookie cookie = new Cookie("userId",userId);
	    				cookie.setMaxAge(60*60*24*14);//2주일
	    				response.addCookie(cookie);
	    				System.out.println("쿠키아이디 생성"+cookie.getValue());
	    			}else if(keeplogin.equals("no")){
	    				Cookie[] cookies = request.getCookies();
	    				if(cookies !=null){
	    					for(Cookie cookie: cookies){
	    						if(cookie.getName().equals("userId")){
	    							cookie.setMaxAge(0);
	    							response.addCookie(cookie);
	    						}
	    					}
	    				}
	    			}
	    		}
	            loginManager.setSession(session, userId);
	            response.sendRedirect("/math/views/main/main.jsp");
	        }
		}else {
			view = request.getRequestDispatcher("/views/member/memberError.jsp");
			request.setAttribute("message", "비밀번호를 확인해주세요!");
			view.forward(request, response);
		}
/*		}else {
       	 view = request.getRequestDispatcher("/views/member/memberError.jsp");
   			request.setAttribute("message", "승인후 로그인 할수 있습니다.");
   			view.forward(request, response);
      		}*/
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
