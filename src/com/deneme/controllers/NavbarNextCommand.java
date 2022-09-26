package com.deneme.controllers;

import javax.swing.JInternalFrame;

import org.apache.commons.collections.functors.IfClosure;
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

public class NavbarNextCommand implements Command{
	FrameNavbar frameNavbar;
	JInternalFrame jInternalFrame;
	public NavbarNextCommand(FrameNavbar frameNavbar,JInternalFrame jInternalFrame) {
		super();
		this.frameNavbar = frameNavbar;
		this.jInternalFrame=jInternalFrame;
	}

	@Override
	public void execute() {
		frameNavbar.setKomut("next");
		((BaseInternalFrame)jInternalFrame).setData(((BaseInternalFrame)jInternalFrame).getModel());
	
		
		
		
		
		
		
		
		
		
		
		
		/*switch (frameNavbar.getFrameKarti()) {
		case "StokKarti": {
			if(!((FrameStokKarti) jInternalFrame).getStokCode().isEmpty()) {
			((FrameStokKarti) jInternalFrame).setStokTable(stokKarti.setData(stokKarti.getWhereClause("next",((FrameStokKarti) jInternalFrame).getStokCode())));
			}
			else {
				((FrameStokKarti) jInternalFrame).setStokTable(stokKarti.setData(stokKarti.getWhereClause("last","zzzzzzzzzz")));
			}
			break;
			
		}
		case "StokTipi": {
			if(!((FrameTipKarti) jInternalFrame).getStokCode().isEmpty()) {

			
			((FrameTipKarti) jInternalFrame).setStokTipi(stokTipiKarti.setData(stokTipiKarti.getWhereClause("next",((FrameTipKarti) jInternalFrame).getStokCode())));		
			}
			else {
				((FrameTipKarti)jInternalFrame).setStokTipi(stokTipiKarti.setData(stokTipiKarti.getWhereClause("last","zzzzzzzzzz")));

			}
			break;
		}
		
		case "StokKdv": {
			if(!((FrameKdvKarti) jInternalFrame).getStokCode().isEmpty()) {

			((FrameKdvKarti) jInternalFrame).setKdvTipi(stokKdvKarti.setData(stokKdvKarti.getWhereClause("next",((FrameKdvKarti) jInternalFrame).getStokCode())));	
			}
			else {
				((FrameKdvKarti) jInternalFrame).setKdvTipi(stokKdvKarti.setData(stokKdvKarti.getWhereClause("last","zzzzzzzzzz")));

			}
			break;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + frameNavbar.getFrameKarti());
		}	*/
	}

}
