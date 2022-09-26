package com.deneme.controllers;

import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;

import com.deneme.interfaces.Command;
import com.deneme.view.FrameStokListesi;

public class ListTableGetvalueComand implements Command{
	FrameStokListesi frameStokListesi;

	public ListTableGetvalueComand(FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;
	}
	@Override
	public void execute() {
		
		int selectedrow = frameStokListesi.getTable().getSelectedRow();

		frameStokListesi.setStokCode(frameStokListesi.getTable().getValueAt(selectedrow, 0).toString());
		frameStokListesi.setStokName(frameStokListesi.getTable().getValueAt(selectedrow, 1).toString());
		frameStokListesi.setStokType( (StokTipiKarti) frameStokListesi.getTable().getValueAt(selectedrow, 2));
		frameStokListesi.setStokUnit((String) frameStokListesi.getTable().getValueAt(selectedrow, 3));
		frameStokListesi.setStokBarcode(frameStokListesi.getTable().getValueAt(selectedrow, 4).toString());
		frameStokListesi.setkDVtype((StokKdvKarti) frameStokListesi.getTable().getValueAt(selectedrow, 5));
		frameStokListesi.setStokDesc(frameStokListesi.getTable().getValueAt(selectedrow, 6).toString());
		System.out.println("merhaba");
		
		
	}
	

}
