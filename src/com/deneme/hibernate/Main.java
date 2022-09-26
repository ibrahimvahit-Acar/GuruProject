package com.deneme.hibernate;

import java.util.Date;

import org.deneme.models.Connection;
import org.deneme.models.StokKarti;
import org.deneme.models.StokKdvKarti;
import org.deneme.models.StokTipiKarti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.deneme.framecontrollers.MainFrameController;


public class Main {
	public static void main(String[] args) {
		MainFrameController mainFrameController=new MainFrameController();
		mainFrameController.execute();
		
	}	

}
