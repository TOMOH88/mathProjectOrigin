package member.model.service;

import javax.servlet.http.*;

public class KeepLogin {
	
	public void KeepLogin(String keeplogin, String userId,HttpServletResponse response) {
		if(keeplogin!=null && userId != null){
			if(keeplogin.equals("yes")){
				Cookie cookie = new Cookie("userId",userId);
				cookie.setMaxAge(60*60*24*14);//2주일
				response.addCookie(cookie);
			}else if(keeplogin.equals("no")){
				Cookie[] cookies = request.getCookies();
				if(cookies !=null){
					for(Cookie cookie: cookies){
						if(cookie.getName().equals(userId)){
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
			}
		}
	}
}
