package com.signup.service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService 
{
		private final JavaMailSender mailSender;

	    // Injecting the JavaMailSender into the service
	    public EmailService(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	    }

	    // Method to send the booking confirmation email
	    public void sendBookingConfirmation(String toEmail, String subject, String message) 
	{
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setFrom("airportauthority.yash@gmail.com");  // Use your email here
	        mailMessage.setTo(toEmail);
	        mailMessage.setSubject(subject);
	        mailMessage.setText(message);

	        try {
	            mailSender.send(mailMessage);
	        } catch (MailException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Email could not be sent", e);
	        }
	    }
}
