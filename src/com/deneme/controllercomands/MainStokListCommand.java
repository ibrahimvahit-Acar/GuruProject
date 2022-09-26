package com.deneme.controllercomands;

import com.deneme.framecontrollers.StokListeFrameController;
import com.deneme.interfaces.Command;
import com.deneme.view.FrameMail;
import com.deneme.view.FrameStokKarti;
import com.deneme.view.FrameStokListesi;
import com.deneme.view.MainFrame;

public class MainStokListCommand implements Command{
	MainFrame mainframe;
	public MainStokListCommand(MainFrame mainframe) {
		super();
		this.mainframe = mainframe;
	}
	@Override
	public void execute() {
	FrameStokListesi frameStokListesi=new FrameStokListesi(mainframe);
	frameStokListesi.execute();
	StokListeFrameController stokListeFrameController=new StokListeFrameController( frameStokListesi);
	stokListeFrameController.execute();
	
		
	}

}
