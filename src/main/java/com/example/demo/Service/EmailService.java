package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.ContactMessage;

@Service
public class EmailService 
{
	
   @Autowired
   private JavaMailSender javaMailSender;
   
   // Use your personal email address here
   @Value(value = "${spring.mail.username}")
   private String recipientEmail ; 

   public void sendNewSubmissionNotification(ContactMessage submission) {
SimpleMailMessage message = new SimpleMailMessage();
       
       // 1. Where the email is going
       message.setTo(recipientEmail); 
       
       // 2. The subject line you will see
       message.setSubject("New Contact Form Submission from Portfolio!");
       
       // 3. The content of the email
       String text = String.format(
           "You received a new message from your portfolio:\n\n" +
           "Name: %s\n" +
           "Email: %s\n" +
           "Message: %s",
           submission.getName(),
           submission.getEmail(),
           submission.getMassage() // Note: Using 'massage' as per your entity
       );
       message.setText(text);

       this.javaMailSender.send(message);
   }
       
   
}
