package com.deneme.view;

import java.awt.Font;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.deneme.framemodels.ModelStokListesi;
import com.deneme.interfaces.Command;
import net.proteanit.sql.DbUtils;

public class FrameStokListesi extends JInternalFrame implements Command {
	MainFrame mainframe;
	JScrollPane scrollpaneList = new JScrollPane();
	static JTable table;
	DefaultTableModel model;
	String[] columnNames = { "StokKodu", "StokAdı", "StokTipi", "StokBirimi", "StokBarkodu", "KdvOranı", "Açıklama",
			"Tarih" };
	ModelStokListesi modelStokListesi = new ModelStokListesi();
	JPanel panel_2 = new JPanel();
	JTextField textSearch;
	JButton listButton = new JButton("Listele");
	JButton btnSearch = new JButton("Ara\r\n");
	JPopupMenu jPopupMenu = new JPopupMenu("Menü");
	JMenuItem excel = new JMenuItem("Excel");
	JMenuItem rapor = new JMenuItem("Rapor");
	JMenuItem mail = new JMenuItem("Mail");
	JMenuItem stokKarti = new JMenuItem("Stok Kartı");
	private String stokCode;
	private String stokName;
	private StokTipiKarti stokType;
	private String stokUnit;
	private String stokBarcode;
	private StokKdvKarti kDVtype;
	private String stokDesc;
	private Date date;

	public FrameStokListesi(MainFrame mainframe) {
		this.mainframe = mainframe;
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.setBounds(550, 0, 700, 680);
		this.getContentPane().setLayout(null);
		scrollpaneList.setBounds(135, 230, 544, 294);
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		scrollpaneList.setViewportView(table);

		this.getContentPane().add(scrollpaneList);

		listButton.setBounds(29, 260, 100, 31);
		this.getContentPane().add(listButton);
		listButton.setFont(new Font("Tahoma", Font.BOLD, 8));

		jPopupMenu.add(excel);
		jPopupMenu.add(rapor);
		jPopupMenu.add(mail);
		jPopupMenu.add(stokKarti);
		this.getContentPane().add(jPopupMenu);

		panel_2.setBorder(new TitledBorder(null, "Arama", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(139, 116, 550, 94);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		textSearch = new JTextField();
		textSearch.setBounds(10, 26, 362, 43);
		panel_2.add(textSearch);
		textSearch.setColumns(10);

		btnSearch.setBounds(412, 33, 85, 25);
		panel_2.add(btnSearch);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));

	}

	public ModelStokListesi getModelStokListesi() {
		return modelStokListesi;
	}

	public void setModelStokListesi(ModelStokListesi modelStokListesi) {
		this.modelStokListesi = modelStokListesi;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JMenuItem getExcel() {

		return excel;
	}

	public JMenuItem getScreen() {

		return rapor;
	}

	public JMenuItem getMail() {

		return mail;
	}

	public JMenuItem getStokKarti() {

		return stokKarti;
	}

	public JPopupMenu getPopup() {

		return jPopupMenu;

	}

	public FrameStokListesi getFrame() {
		return this;
	}

	public JButton getListButton() {
		return listButton;
	}

	public JButton getSearchButton() {
		return btnSearch;
	}

	public void setTable(ResultSet rs) {
		table.setModel(DbUtils.resultSetToTableModel(rs));

	}

	public JTable getTable() {
		return table;
	}

	public String getTextSearch() {
		String text = textSearch.getText();
		textSearch.setText("");
		return text;
	}

	public String getStokCode() {
		return stokCode;
	}

	public void setStokCode(String stokCode) {
		this.stokCode = stokCode;
	}

	public String getStokName() {
		return stokName;
	}

	public void setStokName(String stokName) {
		this.stokName = stokName;
	}

	public StokTipiKarti getStokType() {
		return stokType;
	}

	public void setStokType(StokTipiKarti stokType) {
		this.stokType = stokType;
	}

	public String getStokUnit() {
		return stokUnit;
	}

	public void setStokUnit(String stokUnit) {
		this.stokUnit = stokUnit;
	}

	public String getStokBarcode() {
		return stokBarcode;
	}

	public void setStokBarcode(String stokBarcode) {
		this.stokBarcode = stokBarcode;
	}

	public StokKdvKarti getkDVtype() {
		return kDVtype;
	}

	public MainFrame getMainFrame() {
		return mainframe;
	}

	public void setkDVtype(StokKdvKarti kDVtype) {
		this.kDVtype = kDVtype;
	}

	public String getStokDesc() {
		return stokDesc;
	}

	public void setStokDesc(String stokDesc) {
		this.stokDesc = stokDesc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void execute() {
		mainframe.getContentPane().add(this);
		this.setVisible(true);

	}

}
