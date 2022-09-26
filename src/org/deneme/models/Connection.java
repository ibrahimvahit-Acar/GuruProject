package org.deneme.models;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;




public class Connection {
    	private static SessionFactory sessionFactory;
    	static{
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(StokTipiKarti.class)
					.addAnnotatedClass(StokKarti.class)
					.addAnnotatedClass(StokKdvKarti.class).buildSessionFactory();
			
		}
		public static SessionFactory  getSessionFactory() {
			return sessionFactory;
			
			
			
	}
}
