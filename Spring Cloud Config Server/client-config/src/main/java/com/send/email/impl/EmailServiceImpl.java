package com.send.email.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.send.email.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	/*
    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
      String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("noreply@baeldung.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);

    }
    
    
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        
        mailSender.setUsername("my.gmail@gmail.com");
        mailSender.setPassword("password");
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        
        return mailSender;
    }
    
    
	public void sendMail(String auth, String ttls, String host, String myEmail, String myPassword, String toEmail) throws AddressException, MessagingException, IOException {
    	   
    	  Properties props = new Properties();
    	   props.put("mail.smtp.auth", auth);
    	   props.put("mail.smtp.starttls.enable", ttls);
    	   props.put("mail.smtp.host", host);
    	   props.put("mail.smtp.port", "587");
    	   
    	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    	      protected PasswordAuthentication getPasswordAuthentication() {
    	         return new PasswordAuthentication(myEmail, myPassword);
    	      }
    	   });
    	   Message msg = new MimeMessage(session);
    	   msg.setFrom(new InternetAddress(myEmail, false));

    	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
    	   msg.setSubject("Tutorials point email");
    	   msg.setContent("Tutorials point email", "text/html");
    	   msg.setSentDate(new Date());

    	   Transport.send(msg);   
    	}
	 
	public static void main(String auth, String ttls, String host, String myEmail, String myPassword, String toEmail) throws AddressException, MessagingException, IOException{  
	      String to = toEmail;//change accordingly  
	      String from = myEmail;  
//	      String host = "localhost";//or IP address  
	  
	     //Get the session object  
	      Properties properties = System.getProperties();  
	      properties.setProperty("mail.smtp.host", host);  
	      Session session = Session.getDefaultInstance(properties);  
	  
	     //compose the message  
	      try{  
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(from));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	         message.setSubject("Ping");  
	         message.setText("Hello, this is example of sending email  ");  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("message sent successfully....");  
	  
	      }catch (MessagingException mex) {mex.printStackTrace();}  
	   }
	
	
	*/

	@Override
    public void sendEmail(String myEmail, String toEmail, String subject, String body) {

		System.out.println("send email method called");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(myEmail, toEmail);

        msg.setSubject(subject);
        msg.setText(body);

        javaMailSender.send(msg);
    }
}
