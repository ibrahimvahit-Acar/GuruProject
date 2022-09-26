package com.deneme.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.deneme.models.StokTipiKarti;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class FrameTipKarti extends BaseInternalFrame implements Command {
	private Integer id;
	StokTipiKarti stokTipiKarti = new StokTipiKarti();
	MainFrame mainframe;
	JTextField textStokCode, textStokName, textId;
	JTextArea textDescription;
	JButton backButton, firstButton, lastButton, forwardButton;

	FrameNavbar frameNavbar = new FrameNavbar();
	public FrameTipKarti(MainFrame mainframe) {
		this.mainframe = mainframe;
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setBounds(150, 150, 500, 420);
		this.setTitle("Stok Tipi Kartı ");
		this.getContentPane().add(frameNavbar);
		
		this.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Stok Tipi Kartı Yönetim Sistemi\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(5, -31, 289, 110);
		this.getContentPane().add(lblNewLabel);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Stok Tip Kartı\u0131", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

		JLabel lblNewLabel_6 = new JLabel("Açıklama\r\n");
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

		textDescription = new JTextArea();
		textDescription.setBounds(154, 79, 202, 19);
		panel.add(textDescription);
		textDescription.setColumns(10);


	}

	public StokTipiKarti getStokTipiKarti() {
		return stokTipiKarti;
	}
	public void setStokTipiKarti(StokTipiKarti stokTipiKarti) {
		this.stokTipiKarti = stokTipiKarti;
	}


	public FrameNavbar getFrameNavbar() {
		return frameNavbar;
	}

	public void setFrameNavbar(FrameNavbar frameNavbar) {
		this.frameNavbar = frameNavbar;
	}

	public JInternalFrame getStokTipInternalFrame() {
		return this;
	}

	public void setStokTipi(BaseModel mdTipi) {
		StokTipiKarti stokTipiKarti = (StokTipiKarti) mdTipi;
		if(stokTipiKarti!=null) {
		setId(stokTipiKarti.getTipId());
		textStokCode.setText(stokTipiKarti.getTipKodu());
		textStokName.setText(stokTipiKarti.getTipAdi());
		textDescription.setText(stokTipiKarti.getTipAciklama());
		System.out.println(getId());
		}
		else {
			System.out.println("hataaaaa");
		}
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
		return textStokCode.getText();
	}

	public String getStokName() {
		String stokName = textStokName.getText();
		textStokName.setText("");
		return stokName;
	}

	public String getStokDesc() {
		String stokDesc = textDescription.getText();
		textDescription.setText("");
		return stokDesc;
	}
	



	@Override
	public void execute() {
		this.mainframe.getContentPane().add(this);
		this.setVisible(true);

	}

	@Override
	public void setData(BaseModel model) {
		setStokTipi(model);
	}

	@Override
	public BaseModel getModel() {
		BaseModel a = frameNavbar.navbarLoad(getStokTipiKarti(), getStokCode());
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String getStokKodu() {
		return textStokCode.getText();
	}
	@Override
	public BaseModel getStokInfo() {
		StokTipiKarti a=stokTipiKarti;
		a.setTipKodu(textStokCode.getText());
		System.out.println( "atama başarılıysa doludur=" + a.getTipKodu());
		a.setTipAdi(textStokName.getText());
		a.setTipAciklama(textDescription.getText());
		return a;
	}
	@Override
	public JTextField getTextfield() {
		// TODO Auto-generated method stub
		return textStokCode;
	}
	@Override
	public MainFrame getMainFrame() {
		return this.mainframe;
	}

}
