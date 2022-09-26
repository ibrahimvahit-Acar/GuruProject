package com.deneme.controllers;

import javax.swing.JInternalFrame;

import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;

import com.deneme.interfaces.Command;
import com.deneme.view.BaseInternalFrame;
import com.deneme.view.FrameKdvKarti;
import com.deneme.view.FrameNavbar;
import com.deneme.view.FrameStokKarti;
import com.deneme.view.FrameTipKarti;

public class NavbarLastComand implements Command{
	FrameNavbar frameNavbar;
	JInternalFrame jInternalFrame;

	public NavbarLastComand(FrameNavbar frameNavbar,JInternalFrame jInternalFrame) {
		super();
		this.frameNavbar = frameNavbar;
		this.jInternalFrame=jInternalFrame;
	}

	@Override
	public void execute() {
		frameNavbar.setKomut("last");
		((BaseInternalFrame)jInternalFrame).setData(((BaseInternalFrame)jInternalFrame).getModel());		
		
		
		
	/*	switch (frameNavbar.getFrameKarti()) {
		case "StokKarti": {
			
			((FrameStokKarti) jInternalFrame).setStokTable(stokKarti.setData(stokKarti.getWhereClause("last","zzzzzzzzzz")));
			break;
			
		}
		case "StokTipi": {
			((FrameTipKarti)jInternalFrame).setStokTipi(stokTipiKarti.setData(stokTipiKarti.getWhereClause("last","zzzzzzzzzz")));
			break;
		}
		
		case "StokKdv": {
			((FrameKdvKarti) jInternalFrame).setKdvTipi(stokKdvKarti.setData(stokKdvKarti.getWhereClause("last","zzzzzzzzzz")));
			break;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + frameNavbar.getFrameKarti());
		}*/
		
	
		
	}

}
