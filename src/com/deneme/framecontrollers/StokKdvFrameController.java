package com.deneme.framecontrollers;



import com.deneme.interfaces.Command;
import com.deneme.listeners.GeneralListener;
import com.deneme.view.FrameKdvKarti;


public class StokKdvFrameController implements Command {
	FrameKdvKarti frameKdvKarti;


	public StokKdvFrameController(FrameKdvKarti frameKdvKarti) {
		super();
		this.frameKdvKarti = frameKdvKarti;
	
	}

	@Override
	public void execute() {

		setListeners();
	}

	public void setListeners() {
		
		NavbarFrameController navbarFrameController=new NavbarFrameController(frameKdvKarti.getFrameNavbar(), frameKdvKarti.getStokKdv(),frameKdvKarti.getStokKdvKarti());
navbarFrameController.execute();		
	/*	frameKdvKarti.getSaveButton()
				.addActionListener(new GeneralListener(new KDVSaveCommand(frameKdvKarti  )));
		frameKdvKarti.getDeleteButton()
				.addActionListener(new GeneralListener(new KDVDeleteCommand(frameKdvKarti  )));
		*/
		
		/*
		frameKdvKarti.getFirstButton()
		.addActionListener(new GeneralListener(new KDVFirstComand(frameKdvKarti  )));
frameKdvKarti.getLastButton()
		.addActionListener(new GeneralListener(new KDVLastCommand(frameKdvKarti)));
frameKdvKarti.getBacktButton()
		.addActionListener(new GeneralListener(new KDVPreviousComand(frameKdvKarti  )));
frameKdvKarti.getForwardButton()
		.addActionListener(new GeneralListener(new KDVNextCommand(frameKdvKarti  )));
*/
		

	}

}
