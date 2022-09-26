package com.deneme.framemodels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JOptionPane;

import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mysql.cj.Query;


import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

public class ModelStokListesi {

	private String searchText;

	public String getTextSearch() {
		return searchText;
	}

	public void setTextSearch(String textSearch) {
		this.searchText = textSearch;
	}
	
	public Iterator listeleme() {
		Session session = org.deneme.models.Connection
				.getSessionFactory().openSession();
		session.beginTransaction();
		List l = session.createQuery("from StokKarti").list();
		Iterator it = (Iterator) l.iterator();
		session.getTransaction().commit();
		session.close();
		return it;
	}
	
	public Iterator search() {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		String text ='%'+searchText+'%';
		String hql = "from StokKarti WHERE stokKodu LIKE :kod OR stokAdi LIKE:kod2 OR stokTipiKarti.tipKodu LIKE :kod3 OR birimi LIKE :kod4 OR barkodu LIKE:kod5 OR stokKdvKarti.orani LIKE:kod6 OR aciklama LIKE:kod7 OR tarih LIKE:kod8";
		List l = session.createQuery(hql).setString("kod", text).setString("kod2", text).setString("kod3", text).setString("kod4", text).setString("kod5", text).setString("kod6", text).setString("kod7", text).setString("kod8", text).list();
		Iterator it = (Iterator) l.iterator();
		session.getTransaction().commit();
		session.close();
		return it;
	}

	public void listReport() throws FileNotFoundException, JRException {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		List<StokKarti> listItems = session.createQuery("from StokKarti").list();
		JRBeanCollectionDataSource itemsJRBean=new JRBeanCollectionDataSource(listItems);
		Map<String,Object> parameters=new HashMap<String,Object>();
		parameters.put("HiberPara", itemsJRBean);
		InputStream input=new FileInputStream(new File("C:\\Users\\vahit\\eclipse-workspace"
				+ "\\Deneme\\src\\HiberSon.jrxml"));
		JasperDesign jasperDesign=JRXmlLoader.load(input);
		JasperReport jasperReport=JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint=JasperFillManager.fillReport
				(jasperReport, parameters,new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Excel/JasperHiberSon.pdf");
		JasperViewer.viewReport(jasperPrint);
		session.getTransaction().commit();
		session.close();

		/*try {
			Connection con = Connector.getConnector();
			System.out.println(con);
			JasperDesign jDesign = JRXmlLoader.load("C:/Users/vahit/eclipse-workspace/Deneme/src/hiber.jrxml");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(
					"SELECT stok.stokKodu,stok.stokAdi,stoktipikarti.tipKodu,stok.birimi,stok.barkodu,stokkdvkarti.orani,stok.aciklama,stok.tarih "
							+ "FROM stok " + "JOIN stoktip ON stok.stokKodu=stoktip.StokTipi "
							+ "JOIN stoktipikarti ON stoktip.TipId=stoktipikarti.tipId "
							+ "JOIN stokkdv ON stok.stokKodu=stokkdv.KdvTipi "
							+ "JOIN stokkdvkarti ON stokkdv.KdvId=stokkdvkarti.kdvId ");
			jDesign.setQuery(updateQuery);

			JasperReport jReport = JasperCompileManager.compileReport(jDesign);
			System.out.println("aaaa");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jReport, null, con);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Excel/JasperHiber.pdf");
			JasperViewer.viewReport(jasperPrint);

		} catch (JRException e) {
			System.out.println("Dosya bulunamadı");
			e.printStackTrace();
		}*/
	}
}
