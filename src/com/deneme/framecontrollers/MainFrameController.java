package com.deneme.framecontrollers;

import javax.swing.text.html.FormSubmitEvent;

import com.deneme.controllercomands.MainStokKartiComand;
import com.deneme.controllercomands.MainStokKdvCommand;
import com.deneme.controllercomands.MainStokListCommand;
import com.deneme.controllercomands.MainStokTipiComand;
import com.deneme.listeners.GeneralListener;
import com.deneme.view.MainFrame;







public class MainFrameController {
	MainFrame mainView=new MainFrame();
	 public void execute() {
		 mainView.setVisible(true);
		setListeners();
	}
     public void setListeners() {	
    	 mainView.getStokKarti().addActionListener(new GeneralListener(new MainStokKartiComand(mainView)));
    	 mainView.getStokKdvKarti().addActionListener(new GeneralListener(new MainStokKdvCommand(mainView)));
    	 mainView.getStokTipKarti().addActionListener(new GeneralListener(new MainStokTipiComand(mainView)));
    	 mainView.getStokListesiKarti().addActionListener(new GeneralListener(new MainStokListCommand(mainView)));

     }	    

		 
	    
	    

	
	

}