package com.testhub.classes;
 
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailSSL {
	
	public boolean sendRecoveryLink(String mailAddress, String linkTail){
		 String subject = "Recovery password link for TestHub";
		 String messageText = "Hello Dear! here is your link to recover your password:";
		 String linkHead = Container.getLinkHeadrecovery();
		 return this.send(subject, messageText, mailAddress, linkHead, linkTail);
			 
	};
	
    public boolean sendValidationLink(String mailAddress, String linkTail){
    	 String subject = "Account validation link for TestHub";
    	 String messageText = "Hello Dear! here is your link to validate your account:";
		 String linkHead = Container.getLinkHeadrecovery();
		 return this.send(subject, messageText, mailAddress, linkHead, linkTail);
	};
	
	
	private boolean send(String subject, String messageText,String mailAddress, String linkHead, String linkTail){
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		
		
		
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Container.getAppownmailaddress(),Container.getAppownmailpassword());
				}
			});
 
		try {
 
			
			
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Container.getAppownmailaddress()));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailAddress));
			message.setSubject(subject);
			message.setText(messageText+linkHead+linkTail );
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
	}
}