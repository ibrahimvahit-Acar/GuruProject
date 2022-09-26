package com.deneme.controllercomands;

import com.deneme.framecontrollers.StokKartiFrameController;
import com.deneme.interfaces.Command;
import com.deneme.view.FrameStokKarti;
import com.deneme.view.MainFrame;

public class MainStokKartiComand implements Command{
	MainFrame mainframe;
	
	
	
	public MainStokKartiComand(MainFrame mainframe) {
		super();
		this.mainframe = mainframe;
	}



	@Override
	public void execute() {
		FrameStokKarti frameStokKarti=new FrameStokKarti(mainframe);
		frameStokKarti.execute();
		StokKartiFrameController stokKartiFrameController=new StokKartiFrameController(frameStokKarti);
		stokKartiFrameController.execute();
		
	}

}
