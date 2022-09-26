package com.deneme.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{
	JMenuItem itemStokKarti = new JMenuItem("Stok Kartı \r\n");
	JMenuItem itemStokListesiKarti = new JMenuItem("Stok Kartı Listesi\r\n");
	JMenuItem itemStokTipKarti = new JMenuItem("Stok Tip Kartı\r\n");
	JMenuItem itemStokKdvKarti= new JMenuItem("Kdv Tip Kartı\r\n");

	
	public MainFrame() {
		
		this.setBounds(100, 100, 1372, 660);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 101, 22);
		this.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu\r\n");
		menuBar.add(mnNewMenu);
		
		
		mnNewMenu.add(itemStokKarti);
		mnNewMenu.add(itemStokListesiKarti);
		mnNewMenu.add(itemStokTipKarti);
		mnNewMenu.add(itemStokKdvKarti);
		
		
		
	}
	public JMenuItem getStokKarti() {
		return itemStokKarti;
	}
	public JMenuItem getStokListesiKarti() {
		return itemStokListesiKarti;
	}
	public JMenuItem getStokTipKarti() {
		return itemStokTipKarti;
	}
	public JMenuItem getStokKdvKarti() {
		return itemStokKdvKarti;
	}

}