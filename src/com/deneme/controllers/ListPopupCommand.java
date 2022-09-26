package com.deneme.controllers;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import com.deneme.interfaces.Command;
import com.deneme.view.FrameStokListesi;
import com.itextpdf.text.log.SysoCounter;

public class ListPopupCommand implements Command{
	FrameStokListesi frameStokListesi;
	
	

	public ListPopupCommand(FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;
	}
	@Override
	public void execute() {
		Point p=frameStokListesi.getMousePosition();
		frameStokListesi.getPopup().show(frameStokListesi,p.x,p.y);
		System.out.println(p.x);
	}
}
