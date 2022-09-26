package com.deneme.controllercomands;

import com.deneme.framecontrollers.StokTipiFrameController;
import com.deneme.interfaces.Command;
import com.deneme.view.FrameTipKarti;
import com.deneme.view.MainFrame;

public class MainStokTipiComand implements Command {
	public MainFrame mainframe;

	public MainStokTipiComand(MainFrame mainframe) {
		super();
		this.mainframe = mainframe;
	}


	@Override
	public void execute() {
		System.out.println("hey");
		FrameTipKarti frameTipKarti=new FrameTipKarti(mainframe);
		frameTipKarti.execute();
		StokTipiFrameController stokTipiFrameController=new StokTipiFrameController(frameTipKarti);
		stokTipiFrameController.execute();
		
		
		
		
	}

}