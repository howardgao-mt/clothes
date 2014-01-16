package com.clothes.util;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
//會員認證	
	public static void sendEmail(String userAddress, String userId, String userName) {
		String host = "smtp.gmail.com";
		int port = 587;
		final String username = "howard.gao@metrics.com.tw";
		final String password = "k7594e68";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("howard.gao@metrics.com.tw"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userAddress));
			
			message.setSubject("Clothes 會員認證信");
			message.setContent("Dear.&nbsp;" + userName + "你好!<br>請點選此連結進行認證&nbsp;&nbsp;&nbsp;<a href=http://localhost:8080/clothes/user_validate.action?userId=" + userId + ">點此進行email認證</a>", "text/html;charset=utf-8");
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);
			
			Transport.send(message);
			
		} catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
//忘記密碼	
	public static void sendResetPwdMail(String userAddress, String userName, String userNewPassword) {
		String host = "smtp.gmail.com";
		int port = 587;
		final String username = "howard.gao@metrics.com.tw";
		final String password = "k7594e68";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("howard.gao@metrics.com.tw"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userAddress));
			
			message.setSubject("Clothes 會員重置密碼。");
			message.setContent("Dear.&nbsp;" + userName + "你好!<br><br>" +
					"您的新密碼為: " +  userNewPassword +
					"<br><br>" +
					"&nbsp;&nbsp;&nbsp;<a href=http://localhost:8080/clothes/user_loginPage.action target=_parent >登入帳號</a>", "text/html;charset=utf-8");
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);
			
			Transport.send(message);
			
		} catch(MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
