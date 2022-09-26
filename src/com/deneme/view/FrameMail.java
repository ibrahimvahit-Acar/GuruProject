package com.deneme.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.deneme.framemodels.ModelMail;
import com.deneme.interfaces.Command;


public class FrameMail extends JInternalFrame implements Command {
	
	MainFrame mainframe;
	JTextField mailFrom, mailTo;
	JButton sendBtn = new JButton("Gönder");
	JButton chooseBtn = new JButton("Dosyayı seçiniz");
	ModelMail modelMail = new ModelMail();
	JPasswordField passwordField;
	String path = "";

	public FrameMail(MainFrame mainframe) {
		this.mainframe = mainframe;
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setBounds(50, 50, 500, 540);
		this.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Mail Kartı\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(29, 31, 366, 379);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(30, 120, 62, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Şifre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(30, 140, 62, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gönderilecek Kişi\r\n\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(30, 160, 62, 13);

		panel.add(lblNewLabel_3);
		mailFrom = new JTextField();
		mailFrom.setBounds(154, 120, 202, 19);
		panel.add(mailFrom);

		mailTo = new JTextField();
		mailTo.setBounds(154, 160, 202, 19);
		panel.add(mailTo);

		passwordField = new JPasswordField();
		passwordField.setBounds(154, 140, 202, 19);
		panel.add(passwordField);

		sendBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		sendBtn.setBounds(226, 260, 120, 31);
		panel.add(sendBtn);

		chooseBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		chooseBtn.setBounds(26, 260, 120, 31);
		panel.add(chooseBtn);

	}

	public JButton getChooseBtn() {

		return chooseBtn;
	}

	public void setPath(String path) {
		this.path = path;

	}

	public String getPath() {
		return this.path;
	}

	public JButton getSendBtn() {
		return sendBtn;

	}

	public String getEmailFrom() {

		return mailFrom.getText();
	}

	public String getEmailTo() {
		return mailTo.getText();
	}
	public ModelMail getModelMail() {
		return modelMail;
	}

	public void setModelMail(ModelMail modelMail) {
		this.modelMail = modelMail;
	}

	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passwordField.getText();
	}

	@Override
	public void execute() {
		this.setVisible(true);
	}

}
