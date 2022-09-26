package com.deneme.controllers;

import org.apache.poi.examples.hssf.usermodel.NewLinesInCells;

import com.deneme.interfaces.Command;
import com.deneme.view.FrameMail;


public class MailSendComand implements Command {
	FrameMail frameMail;
	

	public MailSendComand(FrameMail frameMail) {
		super();
		this.frameMail = frameMail;
	
	}


	@Override
	public void execute() {
		System.out.println("göder bee");
		frameMail.getModelMail().sendMail(frameMail.getEmailFrom(), frameMail.getPassword(),frameMail.getEmailTo(),frameMail.getPath());		
	}

	

}
