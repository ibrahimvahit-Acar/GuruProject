package com.deneme.controllers;

import java.io.FileNotFoundException;

import com.deneme.interfaces.Command;
import com.deneme.view.FrameStokListesi;
import com.itextpdf.text.log.SysoCounter;

import net.sf.jasperreports.engine.JRException;

public class ListReportComand implements Command {
	
	FrameStokListesi frameStokListesi;


	public ListReportComand(FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;
	}


	@Override
	public void execute() {
		try {
			frameStokListesi.getModelStokListesi().listReport();
		} catch (FileNotFoundException | JRException e) {
				System.out.println("olmadı");
			e.printStackTrace();
		}
		
		
	 
		
		
	}

}
