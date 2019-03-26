package admin.model.service;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	public void SendMails(){
	String subject = "비밀번호 초기화 안내2"; 
	String from = "aftersay2@gmail.com";
	String to = "sapirin@naver.com";
	String content = "냉무";

	Properties prop = new Properties();// 정보를 담을 객체
	prop.put("mail.smtp.starttls.enable", "true");     // gmail은 무조건 true 고정
	prop.put("mail.smtp.host", "smtp.gmail.com");      // smtp 서버 주소
	prop.put("mail.smtp.auth","true");                 // gmail은 무조건 true 고정
	prop.put("mail.smtp.port", "587");  
    Authenticator auth = new SMTPAuthenticatior();
    Session ses = Session.getInstance(prop, auth);
    ses.setDebug(true);
    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체 
    try{
	      
	 
	    msg.setSubject(subject); //  제목
	 
	    StringBuffer buffer = new StringBuffer();
	    buffer.append("내용 : ");
	    buffer.append(content+"<br>");
	    Address fromAddr = new InternetAddress(from);
	    msg.setFrom(fromAddr); 
	 
	    Address toAddr = new InternetAddress(to);
	    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
	     
	    msg.setContent(buffer.toString(), "text/html;charset=UTF-8"); // 내용
	    Transport.send(msg); 
	 
	} catch(Exception e){
	    e.printStackTrace();
	    return;
	}
}
}