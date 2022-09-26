package com.deneme.controllers;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;
import org.hibernate.Session;

import com.deneme.interfaces.Command;
import com.deneme.view.FrameStokListesi;

public class ListListelemeCommand implements Command {
	FrameStokListesi frameStokListesi;
	public ListListelemeCommand(FrameStokListesi frameStokListesi) {
		super();
		this.frameStokListesi = frameStokListesi;
	}

		@Override
		public void execute() {
			Iterator it=frameStokListesi.getModelStokListesi().listeleme();
			while (it.hasNext()) {
				StokKarti stokKarti = (StokKarti) it.next();
				String stokKodu = stokKarti.getStokKodu();
				String stokAdi = stokKarti.getStokAdi();
				StokTipiKarti stokTipi = stokKarti.getStokTipiKarti();
				String aciklamaString = stokKarti.getAciklama();
				String birimi=stokKarti.getBirimi();
				String barkodu = stokKarti.getBarkodu();
				StokKdvKarti kdvOrani = stokKarti.getStokKdvKarti();
				Date tarih = stokKarti.getTarih();
				frameStokListesi.getModel().addRow(new Object[]{stokKodu, stokAdi,
						stokTipi,birimi,barkodu,kdvOrani,aciklamaString,tarih});
			}			
		}
		
		

	}
