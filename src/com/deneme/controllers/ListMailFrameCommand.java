package com.deneme.controllers;

import com.deneme.framecontrollers.MailFrameController;
import com.deneme.interfaces.Command;
import com.deneme.view.FrameMail;
import com.deneme.view.FrameStokListesi;

public class ListMailFrameCommand implements Command {

	FrameStokListesi frameStokListesi;
	
	public ListMailFrameCommand(FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;
	
	}
	
	
	@Override
	public void execute() {
		FrameMail frameMail=new FrameMail(frameStokListesi.getMainFrame());
		MailFrameController mailFrameController = new MailFrameController(frameMail);
		mailFrameController.execute();
		frameStokListesi.getMainFrame().getContentPane().add(frameMail);
		frameMail.setVisible(true);
		frameMail.toFront();
		frameMail.setBounds(0,0,500,500);
		
		
	}

}

