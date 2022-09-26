package com.deneme.controllers;

import javax.swing.JInternalFrame;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.deneme.view.BaseInternalFrame;

public class NavbarDeleteCommand implements Command{
	JInternalFrame jInternalFrame;
	BaseModel baseModel;
	public NavbarDeleteCommand(JInternalFrame jInternalFrame,BaseModel baseModel) {
		super();
		this.jInternalFrame = jInternalFrame;
		this.baseModel = baseModel;

	}

	@Override
	public void execute() {
		baseModel.deleteStok(((BaseInternalFrame)jInternalFrame).getStokKodu());
	}
	
	
	

}
