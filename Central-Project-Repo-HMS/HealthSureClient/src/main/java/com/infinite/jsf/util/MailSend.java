/**
* The MailSend class provides a utility method to send emails via Gmail's SMTP server.
* It allows users to send an email with a specified recipient, subject, and message content.
* This class uses JavaMail API to establish a connection with the SMTP server and send an email.
*
* Important: Ensure the email credentials (username and password) are kept secure and not hardcoded in production code.
* For Email, consider using App Passwords if 2-factor authentication is enabled.
*/

package com.infinite.jsf.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {

	/**
	 * Sends an email to a specified recipient with the given subject and message
	 * content.
	 *
	 * @param toEmail The recipient's email address.
	 * @param subject The subject of the email.
	 * @param data    The body content of the email.
	 * @return A success message if the email was sent successfully, otherwise an
	 *         error message.
	 */
	public static String sendInfo(String toEmail, String subject, String data) {
		// String to = "prasanna.trainer@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "infinitehealthsure@gmail.com";

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("infinitehealthsure@gmail.com", "xrascqydsfthxttk");

			}
//            infinitehealthsure@gmail.com
//            xrascqydsfthxttk
		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
//			message.setText(data);
			message.setContent(data, "text/html; charset=utf-8");


			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
			return "Mail Send Successfully...";
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return mex.getMessage();
		}

	}
}