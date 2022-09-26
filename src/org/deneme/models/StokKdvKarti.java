package org.deneme.models;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.deneme.interfaces.BaseModel;

@Entity
public class StokKdvKarti extends BaseModel{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int kdvId;
	private String kdvKodu;
	private String kdvAdi;
	private Double orani;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "" + orani + "";
	}
	
	public int getKdvId() {
		return kdvId;
	}
	public void setKdvId(int kdvId) {
		this.kdvId = kdvId;
	}
	public String getKdvKodu() {
		return kdvKodu;
	}
	public void setKdvKodu(String kdvKodu) {
		this.kdvKodu = kdvKodu;
	}
	public String getKdvAdi() {
		return kdvAdi;
	}
	public void setKdvAdi(String kdvAdi) {
		this.kdvAdi = kdvAdi;
	}
	public Double getOrani() {
		return orani;
	}
	public void setOrani(Double orani) {
		this.orani = orani;
	}
	public List<StokKdvKarti> getKdvOrani() {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		List<StokKdvKarti> stokKdvOrani = null;
		session.beginTransaction();
		stokKdvOrani = session.createQuery("FROM StokKdvKarti").list();
		session.getTransaction().commit();
		session.close();
		return stokKdvOrani;
	}
	

	public String getWhereClause(String komut, String kodu) {
		String hql;
		switch (komut) {
		case "first": {
			hql = " FROM StokKdvKarti  ORDER BY kdvKodu ";

			break;
		}
		case "previous": {
			hql = " FROM StokKdvKarti WHERE kdvKodu<"+"\'"+kodu+"\'"+" ORDER BY kdvKodu DESC  ";
			break;
		}
		case "next": {
			hql = " FROM StokKdvKarti  WHERE kdvKodu>"+"\'"+kodu+"\'"+" ORDER BY kdvKodu  ";
			System.out.println("nexte girdi" + kodu);
			break;
		}
		case "last": {
			hql = " FROM StokKdvKarti   ORDER BY kdvKodu DESC ";
			System.out.println("lasta girdi" + kodu);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + komut);
		}
		return hql;
	}

	
	public BaseModel setData(String hql) {
		
		List<StokKdvKarti> modelStokKdv = null;
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		modelStokKdv = session.createQuery(hql).setMaxResults(1).list();
		if (modelStokKdv.size()!= 0) {
			StokKdvKarti mdKdv = (StokKdvKarti) modelStokKdv.get(0);
			session.getTransaction().commit();
			session.close();
			return mdKdv;
		} else {
			JOptionPane.showMessageDialog(null, "Daha kayıt yok.");
			session.close();
		}
		return null;
	}

	@Override
	public void deleteStok(String stokKodu) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();

		if (!stokKodu.isEmpty()) {
			try {
				session.beginTransaction();
				String hql = "delete from StokKdvKarti where kdvKodu= :kodu";
				int a = session.createQuery(hql).setString("kodu", stokKodu).executeUpdate();
				if (a > 0) {
					session.getTransaction().commit();
					session.close();
					JOptionPane.showMessageDialog(null, "Stokunuz silindi.");

				} else {
					JOptionPane.showMessageDialog(null, "Bu stok kodunda ürün yok.");
					session.close();

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Bu stok kodunda zaten ürün var lütfen geçerli bir stok kodu giriniz.");
				session.close();
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Stok kodu alanı boş olamaz");

		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void submitUpdate(BaseModel baseModel) {
		List<StokKdvKarti> modelStokKdv = null;
		System.out.println("submit update çalıştı");
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		StokKdvKarti stokKdvKarti = (StokKdvKarti) baseModel;
		modelStokKdv	=  session.createQuery("From StokKdvKarti Where kdvKodu=" + "\'" +stokKdvKarti.kdvKodu + "\'").list();
		if (modelStokKdv.size() != 0) {
			session.close();
			System.out.println("UPDATE GİRDİ");
			updateStokKdv(modelStokKdv.get(0).getKdvId(),stokKdvKarti);
		} else {
			session.close();

			System.out.println("KAYDETE GİRDİ");
			submitStokKdv(stokKdvKarti);
		}
		session.close();
	}
	public void submitStokKdv(StokKdvKarti stokKdvKarti) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
			try {
				session.save(stokKdvKarti);
				session.getTransaction().commit();
				session.close();
				JOptionPane.showMessageDialog(null,
						"Stokunuz kaydedildi.");
			}
			catch (Exception e1) {
				session.close();
				JOptionPane.showMessageDialog(null,
						"Bu stok kodunda zaten ürün var lütfen geçerli bir stok kodu giriniz.");
				e1.printStackTrace();
			}
	}
	public void updateStokKdv(int id,StokKdvKarti stokKdvKarti) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		StokKdvKarti yedeKarti = new StokKdvKarti();
		try {
			yedeKarti=session.get(StokKdvKarti.class,id);
			yedeKarti.setKdvKodu(stokKdvKarti.getKdvKodu());
			yedeKarti.setKdvAdi(stokKdvKarti.getKdvAdi());
			yedeKarti.setOrani(stokKdvKarti.getOrani());
			session.save(yedeKarti);
			session.getTransaction().commit();
			System.out.println("yedekkartininORAN ="+yedeKarti.getOrani());
			session.close();
			
			
		/*	yedeKarti=session.get(StokKdvKarti.class, stokKdvKartis.get(0).kdvId);	
			yedeKarti.setKdvAdi(stokKdvKarti.getKdvAdi());
			yedeKarti.setKdvKodu(stokKdvKarti.getKdvKodu());
			yedeKarti.setOrani(stokKdvKarti.getOrani());
			System.out.println("stok tipinden gelen açıklama="+stokKdvKarti.getOrani());
			System.out.println("Yedekkarttaki açıklama="+yedeKarti.getOrani());
			session.save(yedeKarti);
			session.getTransaction().commit();
			session.close();*/
			JOptionPane.showMessageDialog(null, "Stok Kartı güncellendi.");

		} catch (Exception e) {
			session.close();
			JOptionPane.showMessageDialog(null, "Bu stok kodunda stok bulunmuyor.");
		}
		
	}

	@Override
	public BaseModel searchTab(String kodu) {
		List<StokKdvKarti> modelStokKdv = null;
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		modelStokKdv= session.createQuery("From StokKdvKarti Where kdvKodu=" + "\'" +kodu + "\'").list();
		StokKdvKarti stokKdvKarti=new StokKdvKarti();
		if(modelStokKdv.size()!=0) {
		stokKdvKarti.setKdvKodu(modelStokKdv.get(0).getKdvKodu());
		stokKdvKarti.setKdvAdi(modelStokKdv.get(0).getKdvAdi());
		stokKdvKarti.setOrani(modelStokKdv.get(0).getOrani());
		session.close();
		return stokKdvKarti;
		}
		else {
			System.out.println("hataaaaaaaaaaaa");
		}
		return null;
	
		
	}

	@Override
	public List getAllData() {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		List l = session.createQuery("from StokKdvKarti").list();
		Iterator it = (Iterator) l.iterator();
		session.getTransaction().commit();
		session.close();
		return l;		
	}

	

	@Override
	public String getKodu() {
		return getKdvKodu();
	}

	@Override
	public String getAdi() {
		return getKdvAdi();
	}

	
	

}