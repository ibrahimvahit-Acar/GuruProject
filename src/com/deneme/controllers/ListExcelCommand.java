package com.deneme.controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.deneme.interfaces.Command;
import com.deneme.view.FrameStokListesi;



public class ListExcelCommand implements Command {
	FrameStokListesi frameStokListesi;

	public ListExcelCommand(FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;
	}

	public String getCellVal(int x, int y) {

		return frameStokListesi.getTable().getValueAt(x, y).toString();
	}

	@Override
	public void execute() {

		try (XSSFWorkbook wb = new XSSFWorkbook()) {
			XSSFSheet ws = wb.createSheet();

			if(frameStokListesi.getTable().getColumnCount()!=0) {
			Row headerRow = ws.createRow(0);
			for (int headings = 0; headings < frameStokListesi.getTable().getColumnCount(); headings++) { 
				headerRow.createCell(headings).setCellValue(frameStokListesi.getTable().getColumnName(headings));
			}			
			Row row = ws.createRow(1);
			for (int rows = 0; rows < frameStokListesi.getTable().getRowCount(); rows++) { 
				for (int cols = 0; cols < frameStokListesi.getTable().getColumnCount(); cols++) {
					row.createCell(cols).setCellValue(frameStokListesi.getTable().getValueAt(rows, cols).toString()); 
				}
				row = ws.createRow((rows + 2));

			try {

				FileOutputStream fos = new FileOutputStream(new File("C:/Excel/stokTablosu.xlsx"));
				wb.write(fos);
				Desktop.getDesktop().open(new File("C:/Excel/stokTablosu.xlsx"));
				fos.close();
			} catch (FileNotFoundException e) {
				System.out.println("Dosya bulunamadı");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("data hatası");
				e.printStackTrace();
			}
			
			
			
			
			
			}
			}else {
				JOptionPane.showMessageDialog(null, "Lütfen excelde göstermek istediğiniz bilgileri listeleyin");

			}
			
		} catch (IOException e) {
			System.out.println("son catch");

			e.printStackTrace();
		}

	}

}
