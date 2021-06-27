package com.taxilla.Baseclass;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
   // public static final String HOST = "smtp.googlemail.com";
   // public static final int PORT = 587;
   // public static final boolean SSL_FLAG = true; 
 
   public static void mail() {
       
   // public void sendSimpleEmail() 
    {
    	 String HOST = "smtp.rediffmail.com";
    	 int PORT = 25;
    	 boolean SSL_FLAG = true; 
    	 
        String userName = "chandu.aucampus@rediffmail.com";
        String password = "test111";
         
        String fromAddress="chandu.aucampus@rediffmail.com";
        String toAddress =  "chandu.aucampus@gmail.com";
        String subject = "Test Mail";
        String message = "Hello from Apache Mail";
        
     // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(System.getProperty("user.dir")+"\\InputFile\\fup.exe");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of John");
        attachment.setName("John");
         
        try {
            //Email email = new SimpleEmail();
        	MultiPartEmail email = new MultiPartEmail();
            email.setHostName(HOST);
            email.setSmtpPort(PORT);
            email.setAuthenticator(new DefaultAuthenticator(userName, password));
            
            email.setSSLOnConnect(SSL_FLAG);
            email.setFrom(fromAddress);
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(toAddress);
         // add the attachment
            email.attach(attachment);
            email.send();
        }catch(Exception ex){
            System.out.println("Unable to send email");
            System.out.println(ex);
            ex.printStackTrace();
        }}
  
}}