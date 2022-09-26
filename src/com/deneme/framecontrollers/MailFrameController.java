package com.deneme.framecontrollers;


import org.apache.poi.examples.hssf.usermodel.NewLinesInCells;

import com.deneme.controllers.MailFileComand;
import com.deneme.controllers.MailSendComand;
import com.deneme.listeners.GeneralListener;
import com.deneme.view.FrameMail;



public class MailFrameController {

	FrameMail frameMail;
	public MailFrameController(FrameMail frameMail) {
		super();
		this.frameMail = frameMail;
	}
	public void execute() {	
		setListeners();
	}
	public void setListeners() {
		
		frameMail.getSendBtn().addActionListener(new GeneralListener(new MailSendComand(frameMail)));
		frameMail.getChooseBtn().addActionListener(new GeneralListener(new MailFileComand(frameMail)));
		
	}

}
