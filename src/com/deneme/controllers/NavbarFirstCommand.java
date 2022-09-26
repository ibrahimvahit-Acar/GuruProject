package com.deneme.controllers;

import javax.swing.JInternalFrame;

import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.deneme.view.BaseInternalFrame;
import com.deneme.view.FrameKdvKarti;
import com.deneme.view.FrameNavbar;
import com.deneme.view.FrameStokKarti;
import com.deneme.view.FrameTipKarti;
import com.deneme.view.MainFrame;

import antlr.debug.NewLineEvent;

public class NavbarFirstCommand implements Command{
	FrameNavbar frameNavbar;
	JInternalFrame jInternalFrame;
	
	
		
	public NavbarFirstCommand(FrameNavbar frameNavbar,JInternalFrame jInternalFrame) {
		super();
		this.frameNavbar = frameNavbar;
		this.jInternalFrame=jInternalFrame;
	}
	@Override
	public void execute() {	
		frameNavbar.setKomut("first");
		((BaseInternalFrame)jInternalFrame).setData(((BaseInternalFrame)jInternalFrame).getModel());
		
			
		
		
	}

}
