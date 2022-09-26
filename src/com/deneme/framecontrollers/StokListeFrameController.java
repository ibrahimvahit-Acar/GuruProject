package com.deneme.framecontrollers;

import com.deneme.controllers.ListExcelCommand;
import com.deneme.controllers.ListListelemeCommand;
import com.deneme.controllers.ListMailFrameCommand;
import com.deneme.controllers.ListPopupCommand;
import com.deneme.controllers.ListReportComand;
import com.deneme.controllers.ListSearchComand;
import com.deneme.controllers.ListTableGetvalueComand;
import com.deneme.controllers.StokKartiSetCommand;
import com.deneme.interfaces.Command;
import com.deneme.listeners.GeneralListener;
import com.deneme.listeners.GeneralListener2;
import com.deneme.view.FrameMail;
import com.deneme.view.FrameStokKarti;
import com.deneme.view.FrameStokListesi;
import com.itextpdf.text.log.SysoCounter;

import antlr.debug.NewLineEvent;



public class StokListeFrameController implements Command {
	FrameStokListesi frameStokListesi ;


	public StokListeFrameController(  FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;
	
	}
	public void execute() {
		setListeners();
		System.out.println("Liste frami");
		
	}
	public void setListeners() {
		frameStokListesi.getListButton()
				.addActionListener(new GeneralListener(new ListListelemeCommand(frameStokListesi)));
		
		frameStokListesi.getSearchButton()
				.addActionListener(new GeneralListener(new ListSearchComand(frameStokListesi)));
		
		frameStokListesi.getFrame().addMouseListener(new GeneralListener2(new ListPopupCommand(frameStokListesi)));
		
		frameStokListesi.getStokKarti()
				.addActionListener(new GeneralListener(new StokKartiSetCommand(frameStokListesi)));
		
		frameStokListesi.getExcel().addActionListener(new GeneralListener(new ListExcelCommand(frameStokListesi)));
		
		frameStokListesi.getScreen().addActionListener(new GeneralListener(new ListReportComand(frameStokListesi)));
		
		frameStokListesi.getMail()
				.addActionListener(new GeneralListener(new ListMailFrameCommand(frameStokListesi)));
		frameStokListesi.getTable()
				.addMouseListener(new GeneralListener(new ListTableGetvalueComand(frameStokListesi)));
		frameStokListesi.getTable().addMouseListener(new GeneralListener2(new ListPopupCommand(frameStokListesi)));
		
		
		
	}

}
