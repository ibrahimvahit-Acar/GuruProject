package com.deneme.framecontrollers;



import com.deneme.interfaces.Command;
import com.deneme.listeners.GeneralListener;
import com.deneme.view.FrameTipKarti;

public class StokTipiFrameController implements Command {
	FrameTipKarti frameTipKarti;

	public StokTipiFrameController(FrameTipKarti frameTipKarti) {
		super();
		this.frameTipKarti = frameTipKarti;
	}

	public void execute() {

		setListeners();
	}

	public void setListeners() {
		NavbarFrameController navbarFrameController=new NavbarFrameController(frameTipKarti.getFrameNavbar(),frameTipKarti.getStokTipInternalFrame(),frameTipKarti.getStokTipiKarti());
		navbarFrameController.execute();
		


	}
}
