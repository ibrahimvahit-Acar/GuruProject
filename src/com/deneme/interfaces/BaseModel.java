package com.deneme.interfaces;

import java.util.List;

import javax.swing.JPanel;

import org.deneme.models.StokKarti;

public abstract class BaseModel  {
	//Hangi Navbar metodun çalışmasını anlamak için
	public abstract String getWhereClause(String komut,String kodu);
	
	//Gelen Sql sorgusuna göre dönen modeli göndermek için
	public abstract BaseModel setData(String hql);
	
	//Gelen stok koduna göre kaydı silme
	public abstract void deleteStok(String stokKodu);
	
	//GetStokInfo metodundan dönen değeri kaydetme veya güncelleme
	public abstract void submitUpdate(BaseModel baseModel);
	
	public abstract BaseModel searchTab(String kodu);
	public abstract List<BaseModel> getAllData();
	public abstract String getKodu();
	public abstract String getAdi();



}
