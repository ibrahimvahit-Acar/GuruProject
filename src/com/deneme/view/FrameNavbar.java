package com.deneme.view;

import java.awt.Font;

import javax.sound.sampled.TargetDataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import org.apache.poi.ss.formula.functions.T;
import org.bouncycastle.mail.smime.handlers.x_pkcs7_mime;
import org.deneme.models.StokKarti;

import com.deneme.interfaces.BaseModel;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class FrameNavbar extends JPanel {
	JButton backButton, firstButton, lastButton, forwardButton,dialogBtn;
	String komut;
	StokKarti stokKarti = new StokKarti();
	JButton btnStokDelete = new JButton("Sil\r\n");
	JButton btnSubmit = new JButton("Kaydet\r\n");

	public FrameNavbar() {
		this.setBounds(28, 280, 437, 98);
		this.setLayout(null);
		this.setVisible(true);
		ImageIcon first = new ImageIcon(getClass().getResource("first.png"));
		firstButton = new JButton(first);
		firstButton.setBounds(6, 40, 66, 31);
		this.add(firstButton);
		ImageIcon back = new ImageIcon(getClass().getResource("gerison.png"));
		backButton = new JButton(back);
		backButton.setBounds(96, 40, 66, 31);
		this.add(backButton);
		ImageIcon forward = new ImageIcon(getClass().getResource("ilerisSondan.png"));
		forwardButton = new JButton(forward);
		forwardButton.setBounds(200, 40, 66, 31);
		this.add(forwardButton);
		ImageIcon last = new ImageIcon(getClass().getResource("last.png"));
		lastButton = new JButton(last);
		lastButton.setBounds(290, 40, 66, 31);
		this.add(lastButton);
	
		btnStokDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.setBounds(189, 0, 120, 31);
		this.add(btnSubmit);
		btnStokDelete.setBounds(56, 0, 80, 31);
		this.add(btnStokDelete);
		
		ImageIcon stokListe = new ImageIcon(getClass().getResource("büyüteç1.png"));
		dialogBtn = new JButton(stokListe);
		dialogBtn.setBounds(370, 0, 60, 61);
		this.add(dialogBtn);
	}
	public String getKomut() {
		return komut;
	}
	public JButton getBtnStokDelete() {
		return btnStokDelete;
	}

	public void setBtnStokDelete(JButton btnStokDelete) {
		this.btnStokDelete = btnStokDelete;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public void setKomut(String komut) {
		this.komut = komut;
	}

	public JButton getDialogBtn() {
		return dialogBtn;
	}
	public void setDialogBtn(JButton dialogBtn) {
		this.dialogBtn = dialogBtn;
	}
	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JButton getFirstButton() {
		return firstButton;
	}

	public void setFirstButton(JButton firstButton) {
		this.firstButton = firstButton;
	}

	public JButton getLastButton() {
		return lastButton;
	}
	public void setLastButton(JButton lastButton) {
		this.lastButton = lastButton;
	}
	public JButton getForwardButton() {
		return forwardButton;
	}
	public void setForwardButton(JButton forwardButton) {
		this.forwardButton = forwardButton;
	}
	
	
	
	
	

	public BaseModel navbarLoad(BaseModel baseModel,String kodu) {
			BaseModel a = baseModel.setData(baseModel.getWhereClause(getKomut(),kodu));
			return a;
		}
	

	

}
