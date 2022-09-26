package com.deneme.controllercomands;

import com.deneme.framecontrollers.StokKdvFrameController;
import com.deneme.interfaces.Command;
import com.deneme.view.FrameKdvKarti;
import com.deneme.view.MainFrame;


public class MainStokKdvCommand implements Command {
	MainFrame mainframe;
	public MainStokKdvCommand(MainFrame mainframe) {
		super();
		this.mainframe = mainframe;
	}
	
	
	@Override
	public void execute() {
		FrameKdvKarti frameKdvKarti=new FrameKdvKarti(mainframe);
		frameKdvKarti.execute();
		StokKdvFrameController stokKdvFrameController=new StokKdvFrameController(frameKdvKarti);
		stokKdvFrameController.execute();
		
		
	}

}
