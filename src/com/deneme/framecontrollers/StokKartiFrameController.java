package com.deneme.framecontrollers;

import javax.sound.sampled.LineUnavailableException;




import com.deneme.interfaces.Command;
import com.deneme.listeners.GeneralListener;
import com.deneme.view.FrameStokKarti;



public class StokKartiFrameController implements Command {
	
	FrameStokKarti frameStokKarti;
	
	public StokKartiFrameController( FrameStokKarti frameStokKarti) {
		super();
	
		this.frameStokKarti = frameStokKarti;
	}
	
	@Override
	public void execute() {
		
			NavbarFrameController navbarFrameController=new NavbarFrameController(frameStokKarti.getFrameNavbar(),frameStokKarti.getStok(),frameStokKarti.getStokKarti());
			navbarFrameController.execute();
			
			/*frameStokKarti.getSubmitButton()
					.addActionListener(new GeneralListener(new StokKartiSubmitCommand( frameStokKarti)));
			frameStokKarti.getDeleteButton()
					.addActionListener(new GeneralListener(new StokKartiDeleteCommand( frameStokKarti)));
			frameStokKarti.getUpdateButton()
			.addActionListener(new GeneralListener(new StokKartiUpdateCommand( frameStokKarti)));*/
			   
		
			
		
	}
	

	

}
