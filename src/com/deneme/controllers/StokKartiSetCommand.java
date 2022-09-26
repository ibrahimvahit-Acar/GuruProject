package com.deneme.controllers;

import javax.swing.JOptionPane;

import com.deneme.framecontrollers.StokKartiFrameController;
import com.deneme.interfaces.Command;
import com.deneme.view.FrameStokKarti;
import com.deneme.view.FrameStokListesi;

public class StokKartiSetCommand implements Command {
	FrameStokListesi frameStokListesi;

	public StokKartiSetCommand(FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;

	}

	@Override
	public void execute() {
		if(frameStokListesi.getStokCode()!=null) {
		FrameStokKarti frameStokKarti = new FrameStokKarti(frameStokListesi.getMainFrame());
		StokKartiFrameController stokKartiFrameController = new StokKartiFrameController(frameStokKarti);
		stokKartiFrameController.execute();
		frameStokListesi.getMainFrame().getContentPane().add(frameStokKarti);
		frameStokKarti.setStokCode(frameStokListesi.getStokCode());
		frameStokKarti.setStokName(frameStokListesi.getStokName());
		frameStokKarti.setStokType(frameStokListesi.getStokType());
		frameStokKarti.setStokUnit(frameStokListesi.getStokUnit());
		frameStokKarti.setStokKdv(frameStokListesi.getkDVtype());
		frameStokKarti.setStokBarcode(frameStokListesi.getStokBarcode());
		frameStokKarti.setDesc(frameStokListesi.getStokDesc());
		
		frameStokKarti.setVisible(true);
		frameStokKarti.toFront();
		frameStokKarti.setBounds(0, 0, 500, 500);
		}
		else {
			JOptionPane.showMessageDialog(null, "Lütfen tabloda göstermek istediğiniz satırı seçiniz.");

		}

	}

}
