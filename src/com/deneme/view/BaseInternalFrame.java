package com.deneme.view;

import java.awt.Frame;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.deneme.interfaces.BaseModel;

public abstract class BaseInternalFrame extends JInternalFrame{
    //Navbar metotlarından dönecek olan modeli alması için
	public abstract BaseModel getModel();
	
	//Gelen modeli textFieldlara doldurması için
	public abstract void setData(BaseModel model);
	
	//Silme metodu için gerekli stok kodunun gönderilmesi
	public abstract String getStokKodu();
	
	//Kaydetme ve güncelleme metotları için bilgilerin gönderilmesi 
	public abstract BaseModel getStokInfo();
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	public abstract JTextField getTextfield();
	public abstract MainFrame getMainFrame();


}
