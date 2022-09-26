package com.deneme.framemodels;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class ModelMail {
	private String mailFrom;
	private String mailTo;
	private String password;

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void sendMail(String mailFrom, String password, String mailTo,String path) {
		if(!mailFrom.isEmpty()) {	
			if(!password.isEmpty()) {
				if(!mailTo.isEmpty()) {
					if(!path.isEmpty()) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.zoho.eu");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(mailFrom, password);
			}
		});
		Message message = prepareMessage(session, mailFrom, mailTo,path);

		try {
			Transport.send(message);
			JOptionPane.showMessageDialog(null, "Mailiniz gönderildi.");

		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "Mesaj gönderilemedi.Lütfen biligilerinizi doğru giriniz.");
			e.printStackTrace();
		}}
				
		else {
			JOptionPane.showMessageDialog(null, "Lütfen dosya seçimi yapınız.");
	
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "Lütfen göndermek istediğiniz kişinin mailini girniz.");

				}
		}
			else {
				JOptionPane.showMessageDialog(null, "Lütfen şifrenizi girniz.");

			}
		
			}
		else {
			JOptionPane.showMessageDialog(null, "Lütfen emailinizi giriniz.");

		}

	}

	private Message prepareMessage(Session session, String mailFrom, String mailTo,String path) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			message.setSubject("Rapor maili");
			message.setText("Stok Raporu");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Güncel stok raporu");
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			attachmentBodyPart.attachFile(path);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachmentBodyPart);
			message.setContent(multipart);

			return message;
		} catch (AddressException e) {
			JOptionPane.showMessageDialog(null, "Adresleri lütfen doğru giriniz.");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.print("mesaj exception");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Göndermek istediğiniz dosya bulunamadı.");
			e.printStackTrace();
		}
		return null;
	}

}
