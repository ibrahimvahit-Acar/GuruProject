package com.deneme.controllers;

import java.io.File;

import javax.swing.JFileChooser;

import com.deneme.interfaces.Command;
import com.deneme.view.FrameMail;


public class MailFileComand implements Command {
	JFileChooser chooser;
	FrameMail frameMail;
	
	
	
	
	
	
	public MailFileComand(FrameMail frameMail) {
		super();
		this.frameMail = frameMail;
	}






	@Override
	public void execute() {
		
		chooser = new JFileChooser();
		int returnValue = chooser.showOpenDialog(null);
		chooser.setDialogTitle("Lütfen göndermek istediğiniz dosyayı seçiniz: ");
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			String path=selectedFile.getAbsolutePath();	
			frameMail.getChooseBtn().setText(chooser.getSelectedFile().getName());
			frameMail.setPath(path);
		}
		else {
			System.out.println("hata");
		}
		
		
	}

}
