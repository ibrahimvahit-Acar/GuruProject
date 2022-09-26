package com.deneme.controllers;

import javax.swing.JInternalFrame;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.deneme.view.BaseInternalFrame;

public class TabSearchCommand implements Command {
	JInternalFrame jInternalFrame;
	BaseModel baseModel;

	public TabSearchCommand(JInternalFrame jInternalFrame, BaseModel baseModel) {
		super();
		this.jInternalFrame = jInternalFrame;
		this.baseModel = baseModel;
	}

	@Override
	public void execute() {
		if (!((BaseInternalFrame) jInternalFrame).getStokKodu().isEmpty()) {
			((BaseInternalFrame) jInternalFrame)
					.setData(baseModel.searchTab(((BaseInternalFrame) jInternalFrame).getStokKodu()));
		} else {
			System.out.println("boşşşşşş");
		}

	}

}
