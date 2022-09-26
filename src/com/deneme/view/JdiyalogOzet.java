package com.deneme.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.deneme.interfaces.BaseModel;
import com.deneme.interfaces.Command;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class JdiyalogOzet implements Command {
	JDialog jDialog;
	JScrollPane scrollPaneList = new JScrollPane();
	JTable table;
	DefaultTableModel model = new DefaultTableModel();
	String[] columnNames = { "StokKodu", "StokAdı" };
	JTextField textSearch;
	public JdiyalogOzet() {
		JFrame frame = new JFrame();
		jDialog = new JDialog(frame, "ornek", true);
		jDialog.setFocusable(true);
		jDialog.setResizable(true);
		jDialog.setBounds(750, 250, 500, 540);
		jDialog.getContentPane().setLayout(null);
		scrollPaneList.setBounds(25, 65, 150, 294);
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		scrollPaneList.setViewportView(table);
		jDialog.add(scrollPaneList);
		textSearch = new JTextField();
		textSearch.setBounds(25, 26, 90, 23);
		jDialog.add(textSearch);
		textSearch.setColumns(10);
		

	}
	 public void TableFilter() {
			TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
	        table.setRowSorter(rowSorter);
	        textSearch.getDocument().addDocumentListener(new DocumentListener(){
				@Override
				public void insertUpdate(DocumentEvent e) {
					String text = textSearch.getText();

	                if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                }					
				}
				@Override
				public void removeUpdate(DocumentEvent e) {
					 String text = textSearch.getText();

		                if (text.trim().length() == 0) {
		                    rowSorter.setRowFilter(null);
		                } else {
		                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		                }					
				}
				@Override
				public void changedUpdate(DocumentEvent e) {
	                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
					
				}

	        });
	    }
	public String getSearchValue() {
		return textSearch.getText();
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextSearch() {
		return textSearch;
	}

	public void setTextSearch(JTextField textSearch) {
		this.textSearch = textSearch;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	@Override
	public void execute() {
		TableFilter();
		jDialog.setVisible(true);

	}

}
