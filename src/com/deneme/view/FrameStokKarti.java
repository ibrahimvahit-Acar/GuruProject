package com.deneme.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.apache.commons.beanutils.A;
import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import antlr.debug.NewLineEvent;

public class FrameStokKarti extends BaseInternalFrame implements Command {
	MainFrame mainframe;
	JTextField textStokCode, textStokName, textBarcode, textDescription;
	JTable table;
	JComboBox cbUnit;
	FrameNavbar frameNavbar = new FrameNavbar();

	JComboBox<StokTipiKarti> cbStokType;
	JComboBox<StokKdvKarti> cbKDV;
	JButton btnStokDelete = new JButton("Sil\r\n");
	JButton btnSubmit = new JButton("Kaydet\r\n");
	StokKarti stokKarti = new StokKarti();

	public FrameStokKarti(MainFrame mainframe) {
		this.mainframe = mainframe;
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setBounds(50, 50, 500, 540);
		this.getContentPane().setLayout(null);

		this.getContentPane().add(frameNavbar);

		JLabel lblNewLabel = new JLabel("Stok Kartı Yönetim Sistemi\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(5, -31, 289, 99);
		this.getContentPane().add(lblNewLabel);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Stok Kart\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(29, 70, 366, 200);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Stok Adı");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(30, 40, 62, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Stok Tipi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(30, 60, 62, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Birimi\r\n\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(30, 80, 62, 13);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Barkodu\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(30, 100, 62, 19);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("KDV Oranı");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(30, 120, 62, 13);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Açıklama\r\n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(30, 140, 62, 25);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("Stok Kodu");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(28, 20, 79, 13);
		panel.add(lblNewLabel_8);
		textStokCode = new JTextField();
		textStokCode.setBounds(154, 20, 202, 19);
		panel.add(textStokCode);
		textStokCode.setColumns(10);

		textStokName = new JTextField();
		textStokName.setBounds(154, 40, 202, 19);
		panel.add(textStokName);
		textStokName.setColumns(10);

		cbStokType = new JComboBox<StokTipiKarti>();
		StokTipiKarti modelStokTipi = new StokTipiKarti();

		List<StokTipiKarti> modelTip = modelStokTipi.getTip();

		for (int i = 0; i < modelTip.size(); i++) {
			cbStokType.addItem(modelTip.get(i));
		}
		cbStokType.setBounds(154, 60, 202, 19);
		panel.add(cbStokType);

		String[] stokUnitStrings = { "Kıyafet", "Mobilya", "Kişisel", "Eğlence", "Bakım" };
		cbUnit = new JComboBox(stokUnitStrings);
		cbUnit.setBounds(154, 80, 169, 21);
		panel.add(cbUnit);

		textBarcode = new JTextField();
		textBarcode.setBounds(154, 100, 202, 19);
		panel.add(textBarcode);
		textBarcode.setColumns(10);

		cbKDV = new JComboBox<StokKdvKarti>();
		StokKdvKarti modelKdvTipi = new StokKdvKarti();
		List<StokKdvKarti> modelKdvTip = modelKdvTipi.getKdvOrani();
		for (int i = 0; i < modelKdvTip.size(); i++) {
			cbKDV.addItem(modelKdvTip.get(i));
		}
		cbKDV.setBounds(154, 120, 184, 21);
		panel.add(cbKDV);

		textDescription = new JTextField();
		textDescription.setBounds(154, 140, 202, 19);
		panel.add(textDescription);
		textDescription.setColumns(10);

	}

	public FrameNavbar getFrameNavbar() {
		return frameNavbar;
	}

	public StokKarti getStokKarti() {
		return stokKarti;
	}

	public void setStokKarti(StokKarti stokKarti) {
		this.stokKarti = stokKarti;
	}

	public void setFrameNavbar(FrameNavbar frameNavbar) {
		this.frameNavbar = frameNavbar;
	}

	public MainFrame getMainframe() {
		return mainframe;
	}

	public void setMainframe(MainFrame mainframe) {
		this.mainframe = mainframe;
	}



	public JInternalFrame getStok() {
		return this;
	}

	public void setStokCode(String stokCode) {
		textStokCode.setText(stokCode);
	}

	public void setStokName(String stokName) {
		textStokName.setText(stokName);
	}

	public void setStokType(StokTipiKarti stokType) {

		for (int i = 0; i < cbStokType.getItemCount(); i++) {

			if (cbStokType.getItemAt(i).getTipId() == stokType.getTipId()) {
				cbStokType.setSelectedIndex(i);
				return;
			}

		}
	}

	public void setStokUnit(String stokUnit) {
		cbUnit.setSelectedItem(stokUnit);
	}

	public void setStokBarcode(String stokBarcode) {
		textBarcode.setText(stokBarcode);
	}

	public void setStokKdv(StokKdvKarti stokKdv) {

		for (int i = 0; i < cbKDV.getItemCount(); i++) {

			if (cbKDV.getItemAt(i).getKdvId() == stokKdv.getKdvId()) {
				cbKDV.setSelectedIndex(i);
				return;
			}

		}

	}

	public void setDesc(String stokDesc) {
		textDescription.setText(stokDesc);

	}

	public String getStokCode() {
		return textStokCode.getText();
	}

	public String getStokName() {
		String stokName = textStokName.getText();
		textStokName.setText("");
		return stokName;
	}

	public StokTipiKarti getStokType() {
		StokTipiKarti stokType = (StokTipiKarti) cbStokType.getSelectedItem();
		return stokType;
	}

	public String getStokUnit() {
		String stokUnit = (String) cbUnit.getSelectedItem();

		return stokUnit;
	}

	public String getStokBarcode() {
		String stokBarcode = textBarcode.getText();
		textBarcode.setText("");
		return stokBarcode;
	}

	public StokKdvKarti getStokKdv() {
		StokKdvKarti stokKdv = (StokKdvKarti) cbKDV.getSelectedItem();
		return stokKdv;
	}

	public String getStokDesc() {
		String stokDesc = textDescription.getText();
		textDescription.setText("");
		return stokDesc;
	}

	public Date getStokDate() {

		Date utilDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	public JButton getDeleteButton() {
		return btnStokDelete;
	}

	public JButton getSubmitButton() {
		return btnSubmit;
	}

	@Override
	public void execute() {

		mainframe.getContentPane().add(this);
		this.setVisible(true);

	}
	@Override
	public BaseModel getModel() {
		if (getStokCode() != null) {
			BaseModel a = frameNavbar.navbarLoad(getStokKarti(), getStokCode());
			return a;
		} else {
			System.out.println("hataaaaaaaaaa");
		}
		return stokKarti;
	}

	public void setStokTable(BaseModel mdStokKarti2) {
		StokKarti mdStokKarti = (StokKarti) mdStokKarti2;
		if (mdStokKarti != null) {
			textStokCode.setText(mdStokKarti.getStokKodu());
			textStokName.setText(mdStokKarti.getStokAdi());
			for (int i = 0; i < cbStokType.getItemCount(); i++) {
				if (cbStokType.getItemAt(i).getTipId() == mdStokKarti.getStokTipiKarti().getTipId()) {
					cbStokType.setSelectedIndex(i);
				}
			}
			cbUnit.setSelectedItem(mdStokKarti.getBirimi());
			textBarcode.setText(mdStokKarti.getBarkodu());
			for (int i = 0; i < cbKDV.getItemCount(); i++) {
				if (cbKDV.getItemAt(i).getKdvId() == mdStokKarti.getStokKdvKarti().getKdvId()) {
					cbKDV.setSelectedIndex(i);
				}
			}
			textDescription.setText(mdStokKarti.getAciklama());
		} else {
			System.out.println("hataaa");
		}
	}

	@Override
	public void setData(BaseModel model) {
		setStokTable(model);
	}

	@Override
	public String getStokKodu() {
		return textStokCode.getText();
	}
	@Override
	public BaseModel getStokInfo() {
		StokKarti a = stokKarti;
		a.setStokKodu(textStokCode.getText());
		System.out.println("bişeyler yazarsın inşallah=" + a.getStokKodu());
		a.setStokAdi(textStokName.getText());
		a.setStokTipiKarti((StokTipiKarti) cbStokType.getSelectedItem());
		a.setBirimi((String) cbUnit.getSelectedItem());
		a.setBarkodu(textBarcode.getText());
		a.setStokKdvKarti((StokKdvKarti) cbKDV.getSelectedItem());
		a.setAciklama(textDescription.getText());
		a.setTarih((java.sql.Date) getStokDate());
		return a;
	}

	@Override
	public JTextField getTextfield() {
		return textStokCode;
	}

	@Override
	public MainFrame getMainFrame() {
		// TODO Auto-generated method stub
		return this.mainframe;
	}
}