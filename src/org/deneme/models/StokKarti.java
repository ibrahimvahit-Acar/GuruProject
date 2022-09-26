package org.deneme.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.deneme.interfaces.BaseModel;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@Entity
@Table(name = "Stok")
public class StokKarti extends BaseModel {
	@Id
	private String stokKodu;
	private String stokAdi;
	@ManyToOne
	@JoinTable(name = "StokTip", 
	joinColumns = @JoinColumn(name = "StokTipi"), 
	inverseJoinColumns = @JoinColumn(name = "TipId"))
	private StokTipiKarti stokTipiKarti;
	private String birimi;
	private String barkodu;
	@ManyToOne
	@JoinTable(name = "StokKdv", 
	joinColumns = @JoinColumn(name = "KdvTipi"),
	inverseJoinColumns = @JoinColumn(name = "KdvId"))
	private StokKdvKarti stokKdvKarti;
	@Lob
	private String aciklama;
	private Date tarih;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getStokKodu() {
		return stokKodu;
	}

	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getStokAdi() {
		return stokAdi;
	}

	public void setStokAdi(String stokAdi) {
		this.stokAdi = stokAdi;
	}

	public StokTipiKarti getStokTipiKarti() {
		return stokTipiKarti;
	}

	public void setStokTipiKarti(StokTipiKarti stokTipiKarti) {
		this.stokTipiKarti = stokTipiKarti;
	}

	public String getBirimi() {
		return birimi;
	}

	public void setBirimi(String birimi) {
		this.birimi = birimi;
	}

	public String getBarkodu() {
		return barkodu;
	}

	public void setBarkodu(String barkodu) {
		this.barkodu = barkodu;
	}

	public StokKdvKarti getStokKdvKarti() {
		return stokKdvKarti;
	}

	public void setStokKdvKarti(StokKdvKarti stokKdvKarti) {
		this.stokKdvKarti = stokKdvKarti;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date date) {
		this.tarih = (Date) date;
	}

	public void submitStok(StokKarti stokKarti) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		
			try {
				session.beginTransaction();
				session.save(stokKarti);
				session.getTransaction().commit();
				session.close();
				JOptionPane.showMessageDialog(null, "Stokunuz kaydedildi.");

			} catch (Exception e) {
				session.close();

				JOptionPane.showMessageDialog(null, "Bu stok kodunda zaten kayıt var.");
			}
	}
	public void updateStok(StokKarti stokKarti) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		StokKarti yedekKart=new StokKarti();
		
			try {
				session.beginTransaction();
				yedekKart = session.get(StokKarti.class, stokKarti.getStokKodu());
				session.save(yedekKart);
				session.getTransaction().commit();
				session.close();
				JOptionPane.showMessageDialog(null, "[ " + stokKodu + " ]" + " stok kartı güncellendi.");

			} catch (Exception e) {
				session.close();

				JOptionPane.showMessageDialog(null, "Bu stok kodunda stok bulunmuyor.");

			}
		 
	}

	public String getWhereClause(String komut, String kodu) {
		String hql;
		switch (komut) {
		case "first": {
			hql = " FROM StokKarti  ORDER BY stokKodu ";

			break;
		}
		case "previous": {
			hql = " FROM StokKarti WHERE stokKodu<" + "\'" + kodu + "\'" + " ORDER BY stokKodu DESC  ";
			break;
		}
		case "next": {
			hql = " FROM StokKarti  WHERE stokKodu>" + "\'" + kodu + "\'" + " ORDER BY stokKodu  ";
			break;
		}
		case "last": {
			hql = " FROM StokKarti   ORDER BY stokKodu DESC ";

			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + komut);
		}
		return hql;
	}

	public StokKarti setData(String hql) {

		List<StokKarti> modelStok = null;
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		modelStok = session.createQuery(hql).setMaxResults(1).list();
		if (modelStok.size() != 0) {
			StokKarti mdKdv = (StokKarti) modelStok.get(0);
			session.getTransaction().commit();
			session.close();
			return mdKdv;
		} else {
			JOptionPane.showMessageDialog(null, "Daha kayıt yok.");
			session.close();
		}
		return null;
	}
	public BaseModel getStokBase() {
		return this;
	}
	@Override
	public void deleteStok(String stokKodu) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		if (!stokKodu.isEmpty()) {
			try {
				session.beginTransaction();
				String hql = "delete from StokKarti where stokKodu= :kodu";
				int a = session.createQuery(hql).setString("kodu", stokKodu).executeUpdate();
				if (a > 0) {
					session.getTransaction().commit();
					JOptionPane.showMessageDialog(null, "Stok silindi.");
					session.close();
				} else {
					session.close();
					JOptionPane.showMessageDialog(null, "Bu stok kodunda kayıt yok.");
				}
			} catch (Exception e) {
				session.close();
				JOptionPane.showMessageDialog(null, "Geçerli bir değer giriniz.");
			}
		} else {
			session.close();
			JOptionPane.showMessageDialog(null, "Stok kodu alanını doldurunuz.");
		}
	}
	@Override
	public void submitUpdate(BaseModel baseModel) {
		StokKarti stokKarti = (StokKarti) baseModel;
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		StokKarti a = session.get(StokKarti.class, stokKarti.getStokKodu());
session.close();	
		if (a==null) {
			submitStok(stokKarti);
		} else {
			updateStok(stokKarti);
		}
		session.close();
	}
	@Override
	public BaseModel searchTab(String kodu) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		StokKarti stokKarti=session.get(StokKarti.class,kodu);
		session.close();
		return stokKarti;
	}

	@Override
	public List getAllData() {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		List l = session.createQuery("from StokKarti").list();
		Iterator it = (Iterator) l.iterator();
		session.getTransaction().commit();
		session.close();
		return l;
	}


	@Override
	public String getKodu() {
		// TODO Auto-generated method stub
		return getStokKodu();
	}

	@Override
	public String getAdi() {
		// TODO Auto-generated method stub
		return getStokAdi();
	}
}