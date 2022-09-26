package com.deneme.controllers;

import javax.swing.JInternalFrame;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.deneme.view.BaseInternalFrame;

public class NavbarSubmitCommand implements Command{
	JInternalFrame jInternalFrame;
	BaseModel baseModel;
	public NavbarSubmitCommand(JInternalFrame jInternalFrame, BaseModel baseModel) {
		super();
		this.jInternalFrame = jInternalFrame;
		this.baseModel = baseModel;
	}
	@Override
	public void execute() {
		//Burada metodumuz text alanlardaki değerleri alıp modelimizdeki metodumuza gönderir.
		((BaseModel)baseModel).submitUpdate(((BaseInternalFrame)jInternalFrame).getStokInfo());
		
	}

}
