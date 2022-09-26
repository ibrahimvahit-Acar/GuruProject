package com.deneme.framecontrollers;

import javax.swing.JInternalFrame;

import com.deneme.controllers.ListExcelCommand;
import com.deneme.controllers.ListListelemeCommand;
import com.deneme.controllers.ListMailFrameCommand;
import com.deneme.controllers.ListPopupCommand;
import com.deneme.controllers.ListReportComand;
import com.deneme.controllers.ListSearchComand;
import com.deneme.controllers.ListTableGetvalueComand;
import com.deneme.controllers.NavbarDeleteCommand;
import com.deneme.controllers.NavbarFirstCommand;
import com.deneme.controllers.NavbarLastComand;
import com.deneme.controllers.NavbarListe;
import com.deneme.controllers.NavbarNextCommand;
import com.deneme.controllers.NavbarPreviousCommand;
import com.deneme.controllers.NavbarSubmitCommand;
import com.deneme.controllers.StokKartiSetCommand;
import com.deneme.controllers.TabSearchCommand;
import com.deneme.interfaces.BaseModel;
import com.deneme.listeners.GeneralListener;
import com.deneme.view.BaseInternalFrame;
import com.deneme.view.FrameNavbar;
import com.deneme.view.JdiyalogOzet;
import com.deneme.view.MainFrame;

import net.bytebuddy.asm.Advice.This;

public class NavbarFrameController {
	FrameNavbar frameNavbar;
	JInternalFrame jInternalFrame;
	BaseModel baseModel;

	public NavbarFrameController(FrameNavbar frameNavbar, JInternalFrame jInternalFrame, BaseModel baseModel) {
		super();
		this.frameNavbar = frameNavbar;
		this.jInternalFrame = jInternalFrame;
		this.baseModel = baseModel;

	}

	JdiyalogOzet jdiyalogOzet = new JdiyalogOzet();

	public void execute() {
		setListeners();
	}
	public void setListeners() {
		frameNavbar.getLastButton()
				.addActionListener(new GeneralListener(new NavbarLastComand(frameNavbar, jInternalFrame)));
		frameNavbar.getBackButton()
				.addActionListener(new GeneralListener(new NavbarPreviousCommand(frameNavbar, jInternalFrame)));
		frameNavbar.getForwardButton()
				.addActionListener(new GeneralListener(new NavbarNextCommand(frameNavbar, jInternalFrame)));
		frameNavbar.getFirstButton()
				.addActionListener(new GeneralListener(new NavbarFirstCommand(frameNavbar, jInternalFrame)));
		frameNavbar.getBtnStokDelete()
				.addActionListener(new GeneralListener(new NavbarDeleteCommand(jInternalFrame, baseModel)));
		frameNavbar.getBtnSubmit()
				.addActionListener(new GeneralListener(new NavbarSubmitCommand(jInternalFrame, baseModel)));
		((BaseInternalFrame) jInternalFrame).getTextfield()
				.addFocusListener(new GeneralListener(new TabSearchCommand(jInternalFrame, baseModel)));

		frameNavbar.getDialogBtn().addActionListener(new GeneralListener(new NavbarListe(baseModel, jdiyalogOzet)));

	}

}
