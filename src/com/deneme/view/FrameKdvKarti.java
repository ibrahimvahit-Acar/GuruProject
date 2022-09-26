package com.deneme.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class FrameKdvKarti extends BaseInternalFrame implements Command {
	MainFrame mainframe;
	StokKdvKarti stokKdvKarti = new StokKdvKarti();
	JButton backButton, firstButton, lastButton, forwardButton;
	JTextField textStokCode, textStokName, textRate;
	private Integer id;
	
	
	
	FrameNavbar frameNavbar = new FrameNavbar();
	public FrameKdvKarti(MainFrame mainframe) {
		this.mainframe = mainframe;
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setBounds(150, 150, 500, 420);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(frameNavbar);

		JLabel lblNewLabel = new JLabel("Kdv Tipi Kartı Yönetim Sistemi\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(5, -31, 289, 110);
		this.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Kdv Tip Kartı", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(29, 81, 366, 189);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Stok Kodu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(28, 29, 79, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Stok Adı\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(28, 54, 79, 13);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Kdv oranı\r\n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(28, 79, 62, 19);
		panel.add(lblNewLabel_6);

		textStokCode = new JTextField();
		textStokCode.setBounds(154, 29, 202, 19);
		panel.add(textStokCode);
		textStokCode.setColumns(10);

		textStokName = new JTextField();
		textStokName.setBounds(154, 54, 202, 19);
		panel.add(textStokName);
		textStokName.setColumns(10);

		textRate = new JTextField();
		textRate.setBounds(154, 79, 202, 19);
		panel.add(textRate);
		textRate.setColumns(10);

	}

	public JInternalFrame getStokKdv() {
		return this;
	}

	public FrameNavbar getFrameNavbar() {
		return frameNavbar;
	}

	public void setFrameNavbar(FrameNavbar frameNavbar) {
		this.frameNavbar = frameNavbar;
	}

	public JButton getBacktButton() {
		return frameNavbar.backButton;
	}

	public JButton getForwardButton() {
		return frameNavbar.forwardButton;
	}

	public JButton getLastButton() {
		return frameNavbar.lastButton;
	}

	public JButton getFirstButton() {
		return frameNavbar.firstButton;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStokCode() {
		System.out.println("Framede" + textStokCode.getText());
		return textStokCode.getText();
	}

	public String getStokName() {
		String stokName = textStokName.getText();
		textStokName.setText("");
		return stokName;
	}

	public Double getStokKdvRate() {
		String stokRate = textRate.getText();

		Double stokDouble = Double.parseDouble(stokRate);
		textRate.setText("");
		return stokDouble;

	}

	public StokKdvKarti getStokKdvKarti() {
		return stokKdvKarti;
	}

	public void setStokKdvKarti(StokKdvKarti stokKdvKarti) {
		this.stokKdvKarti = stokKdvKarti;
	}
	public void setKdvTipi(BaseModel modelStokKdv) {
		StokKdvKarti stokKdvKarti = (StokKdvKarti) modelStokKdv;
		if (stokKdvKarti != null) {
			System.out.println("ife girdi");
			setId(stokKdvKarti.getKdvId());
			textStokCode.setText(stokKdvKarti.getKdvKodu());
			textStokName.setText(stokKdvKarti.getKdvAdi());
			textRate.setText(String.valueOf(stokKdvKarti.getOrani()));
		} else {
			System.out.println("hata");
		}
	}

	@Override
	public void execute() {
		mainframe.getContentPane().add(this);
		this.setVisible(true);

	}

	@Override
	public void setData(BaseModel model) {
		setKdvTipi(model);

	}

	@Override
	public BaseModel getModel() {
		BaseModel a = frameNavbar.navbarLoad(getStokKdvKarti(), getStokCode());
		return a;
	}

	@Override
	public String getStokKodu() {
		return textStokCode.getText();
	}

	@Override
	public BaseModel getStokInfo() {
		StokKdvKarti a = new StokKdvKarti();
		a.setKdvKodu(textStokCode.getText());
		a.setKdvAdi(textStokName.getText());
		a.setOrani(getStokKdvRate());
		return a;
	}

	@Override
	public JTextField getTextfield() {
		// TODO Auto-generated method stub
		return textStokCode;
	}

	@Override
	public MainFrame getMainFrame() {
		// TODO Auto-generated method stub
		return this.mainframe;
	}

}