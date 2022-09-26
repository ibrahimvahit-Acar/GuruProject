package com.deneme.controllers;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.sql.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.deneme.view.BaseInternalFrame;
import com.deneme.view.JdiyalogOzet;

public class NavbarListe implements Command{

	BaseModel baseModel;
	JdiyalogOzet jdiyalogOzet;
	public NavbarListe(BaseModel baseModel,JdiyalogOzet jdiyalogOzet) {
		super();
		this.baseModel = baseModel;
		this.jdiyalogOzet=jdiyalogOzet;
	}
	@Override
	public void execute() {
			Iterator it = (Iterator) baseModel.getAllData().iterator();
			while (it.hasNext()) {
				 baseModel = (BaseModel) it.next();
				jdiyalogOzet.getModel().addRow(new Object[]{baseModel.getKodu(), baseModel.getAdi()});
			}	
			jdiyalogOzet.execute();
			
			
			
	}
	
	
	

	
}
