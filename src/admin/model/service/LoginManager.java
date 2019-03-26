package admin.model.service;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import admin.model.vo.Admin;

public class LoginManager implements HttpSessionBindingListener {
	private static LoginManager loginManager = null;
	private static Hashtable<HttpSession, String> adminUsers = new Hashtable<HttpSession, String>();
	
	public static synchronized LoginManager getInstance(){
        if(loginManager == null){
            loginManager = new LoginManager();
        }
        return loginManager;
    }
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		adminUsers.put(event.getSession(), event.getName());
	    System.out.println(event.getName() + "님이 로그인 하셨습니다.");
	    System.out.println("현재 접속자 수 : " +  getUserCount());		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		adminUsers.remove(event.getSession());
	    System.out.println("  " + event.getName() + "님이 로그아웃 하셨습니다.");
	    System.out.println("현재 접속자 수 : " +  getUserCount());
	}
	public void removeSession(String userId){
         Enumeration<HttpSession> e = adminUsers.keys();
         HttpSession session = null;
         while(e.hasMoreElements()){
              session = (HttpSession)e.nextElement();
              if(adminUsers.get(session).equals(userId)){
                  //세션이 invalidate될때 HttpSessionBindingListener를 
                  //구현하는 클레스의 valueUnbound()함수가 호출된다.
                  session.invalidate();
              }
         }
    }

	public boolean isValid(String userId, String userPwd) {
		boolean ckd = false;
		 Admin admin = new AdminService().loginAdmin(userId, userPwd);
        System.out.println(admin);
		 if(admin != null) {
       	 ckd= true;
        }
        System.out.println(ckd);
        return ckd;
	}
	public boolean isUsing(String userID){
	        return adminUsers.containsValue(userID);
	}
	
	public void setSession(HttpSession session, String admin){
        //이순간에 Session Binding이벤트가 일어나는 시점
        //name값으로 userId, value값으로 자기자신(HttpSessionBindingListener를 구현하는 Object)
        session.setAttribute(admin, this);//login에 자기자신을 집어넣는다.
    }
	
	public String getUserID(HttpSession session){
	        return (String)adminUsers.get(session);
	}
	
	public int getUserCount(){
        return adminUsers.size();
    }
	
	public void printloginUsers(){
	        Enumeration<HttpSession> e = adminUsers.keys();
	        HttpSession session = null;
	        System.out.println("===========================================");
	        int i = 0;
	        while(e.hasMoreElements()){
	            session = (HttpSession)e.nextElement();
	            System.out.println((++i) + ". 접속자 : " +  adminUsers.get(session));
	        }
	        System.out.println("===========================================");
	}
	
	public Collection<String> getUsers(){
	        Collection<String> collection = adminUsers.values();
	        return collection;
    }

}
