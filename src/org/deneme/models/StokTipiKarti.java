package org.deneme.models;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.criteria.From;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.deneme.interfaces.BaseModel;
import com.itextpdf.text.log.SysoCounter;

@Entity
public class StokTipiKarti extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tipId;
	private String tipKodu;
	private String tipAdi;
	@Lob
	private String tipAciklama;

	@Override
	public String toString() {
		return "" + tipKodu + "";
	}

	public int getTipId() {
		return tipId;
	}

	public void setTipId(int tipId) {
		this.tipId = tipId;
	}

	public String getTipKodu() {
		return tipKodu;
	}

	public void setTipKodu(String tipKodu) {
		this.tipKodu = tipKodu;
	}

	public String getTipAdi() {
		return tipAdi;
	}

	public void setTipAdi(String tipAdi) {
		this.tipAdi = tipAdi;
	}

	public String getTipAciklama() {
		return tipAciklama;
	}

	public void setTipAciklama(String tipAciklama) {
		this.tipAciklama = tipAciklama;
	}

	public List<StokTipiKarti> getTip() {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		List<StokTipiKarti> stokTipi = null;
		session.beginTransaction();
		stokTipi = session.createQuery("FROM StokTipiKarti").list();
		session.getTransaction().commit();
		session.close();
		return stokTipi;

	}

	public String getWhereClause(String komut, String kodu) {
		String hql;
		switch (komut) {
		case "first": {
			hql = " FROM StokTipiKarti  ORDER BY tipKodu ";break;
		}
		case "previous": {
			hql = " FROM StokTipiKarti WHERE tipKodu<" + "\'" + kodu + "\'" + " ORDER BY tipKodu DESC  ";break;
		}
		case "next": {
			hql = " FROM StokTipiKarti  WHERE tipKodu>" + "\'" + kodu + "\'" + " ORDER BY tipKodu  ";break;
		}
		case "last": {
			hql = " FROM StokTipiKarti   ORDER BY tipKodu DESC ";break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + komut);
		}
		return hql;
	}

	public BaseModel setData(String hql) {
		List<StokTipiKarti> modelStokTipi = null;
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		modelStokTipi = session.createQuery(hql).setMaxResults(1).list();
		if (modelStokTipi.size() != 0) {
			StokTipiKarti mdKdv = (StokTipiKarti) modelStokTipi.get(0);
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
				String hql = "delete from StokTipiKarti where tipkodu= :kodu";
				int a = session.createQuery(hql).setString("kodu", stokKodu).executeUpdate();
				if (a > 0) {
					session.getTransaction().commit();
					session.close();
					JOptionPane.showMessageDialog(null, "Stok silindi.");
				} else {
					JOptionPane.showMessageDialog(null, "Bu stok kodunda kayıt yok.");
					session.close();
				}
			} catch (Exception e) {
				session.close();
				e.printStackTrace();
			}
		} else {
			session.close();
			JOptionPane.showMessageDialog(null, "Stok kodu alanınız boş olamaz.");
		}
	}

	@SuppressWarnings("unchecked")

	@Override
	public void submitUpdate(BaseModel baseModel) {
		List<StokTipiKarti> modelStokTipi = null;
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		StokTipiKarti stokTipiKarti = (StokTipiKarti) baseModel;
		modelStokTipi = session
				.createQuery("From StokTipiKarti Where tipKodu=" + "\'" 
		                               + stokTipiKarti.getTipKodu() + "\'").list();
		if (modelStokTipi.size() != 0) {
			session.close();
			updateStokTip(modelStokTipi, stokTipiKarti);
		} else {
			session.close();
			submitStokTip(stokTipiKarti);
		}
		session.close();

	}

	public void submitStokTip(StokTipiKarti stokTipiKarti) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(stokTipiKarti);
			System.out.println("olduysan söyle");
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null, "Stokunuz kaydedildi.");
		} catch (Exception e1) {
			session.close();
			JOptionPane.showMessageDialog(null, 
					"Bu stok kodunda zaten ürün var lütfen geçerli bir stok kodu giriniz.");
			e1.printStackTrace();
		}

	}

	public void updateStokTip(List<StokTipiKarti> stokTipiKarti, StokTipiKarti a) {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		StokTipiKarti yedeKarti = new StokTipiKarti();
		try {
			session.beginTransaction();
			yedeKarti = session.get(StokTipiKarti.class, stokTipiKarti.get(0).tipId);
			yedeKarti.setTipAdi(a.getTipAdi());
			yedeKarti.setTipKodu(a.getTipKodu());
			yedeKarti.setTipAciklama(a.tipAciklama);
			session.save(yedeKarti);
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null, "[ " + tipKodu + " ]" + " stok kartı güncellendi.");
		} catch (Exception e) {
			session.close();
			JOptionPane.showMessageDialog(null, "Bu stok kodunda stok bulunmuyor.");
		}
	}

	@Override
	public BaseModel searchTab(String kodu) {
		List<StokTipiKarti> modelStokTipi = null;
		StokTipiKarti stokTipiKarti = new StokTipiKarti();
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		modelStokTipi = session.createQuery("From StokTipiKarti Where tipKodu=" + "\'" + kodu + "\'").list();
		if (modelStokTipi.size() != 0) {
			stokTipiKarti.setTipKodu(modelStokTipi.get(0).getTipKodu());
			stokTipiKarti.setTipAdi(modelStokTipi.get(0).getTipAdi());
			stokTipiKarti.setTipAciklama(modelStokTipi.get(0).getTipAciklama());
			return stokTipiKarti;
		} else {
			System.out.println("hataaaaaaa");
		}
		return null;

	}

	@Override
	public List getAllData() {
		Session session = org.deneme.models.Connection.getSessionFactory().openSession();
		session.beginTransaction();
		List l = session.createQuery("from StokTipiKarti").list();
		Iterator it = (Iterator) l.iterator();
		session.getTransaction().commit();
		session.close();
		return l;
	}

	@Override
	public String getKodu() {
		return getTipKodu();
	}

	@Override
	public String getAdi() {
		// TODO Auto-generated method stub
		return getTipAdi();
	}

}