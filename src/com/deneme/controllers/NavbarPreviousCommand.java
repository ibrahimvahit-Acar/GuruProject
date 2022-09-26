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

public class NavbarPreviousCommand implements Command{
	FrameNavbar frameNavbar;
	StokKarti stokKarti=new StokKarti();
	StokKdvKarti stokKdvKarti=new StokKdvKarti();
	StokTipiKarti stokTipiKarti=new StokTipiKarti();
	JInternalFrame jInternalFrame;

	public NavbarPreviousCommand(FrameNavbar frameNavbar,JInternalFrame jInternalFrame) {
		super();
		this.frameNavbar = frameNavbar;
		this.jInternalFrame=jInternalFrame;
	}

	@Override
	public void execute() {
		frameNavbar.setKomut("previous");
		((BaseInternalFrame)jInternalFrame).setData(((BaseInternalFrame)jInternalFrame).getModel());

		/*switch (frameNavbar.getFrameKarti()) {
		case "StokKarti": {
			if(!((FrameStokKarti) jInternalFrame).getStokCode().isEmpty()) {

			((FrameStokKarti) jInternalFrame).setStokTable(stokKarti.setData(stokKarti.getWhereClause("previous",((FrameStokKarti) jInternalFrame).getStokCode())));
		
			}
			else {
				((FrameStokKarti) jInternalFrame).setStokTable(stokKarti.setData(stokKarti.getWhereClause("first", "aaaaaa")));

			}
				break;
			
		}
		case "StokTipi": {
			if(!((FrameTipKarti) jInternalFrame).getStokCode().isEmpty()) {

			((FrameTipKarti) jInternalFrame).setStokTipi(stokTipiKarti.setData(stokTipiKarti.getWhereClause("previous",((FrameTipKarti) jInternalFrame).getStokCode())));			
			}
			else {
				((FrameTipKarti)jInternalFrame).setStokTipi(stokTipiKarti.setData(stokTipiKarti.getWhereClause("first", "aaaaaa")));

			}
			break;
		}
		
		case "StokKdv": {
			if(!((FrameKdvKarti) jInternalFrame).getStokCode().isEmpty()) {
			((FrameKdvKarti) jInternalFrame).setKdvTipi(stokKdvKarti.setData(stokKdvKarti.getWhereClause("previous",((FrameKdvKarti) jInternalFrame).getStokCode())));			
			}
			else {
				((FrameKdvKarti) jInternalFrame).setKdvTipi(stokKdvKarti.setData(stokKdvKarti.getWhereClause("first", "aaaaaa")));
			}
			break;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + frameNavbar.getFrameKarti());
		}*/
	}

}
