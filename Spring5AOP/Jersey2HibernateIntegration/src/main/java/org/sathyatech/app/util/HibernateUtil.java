package org.sathyatech.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;

	static {
		try {
			Configuration cfg=new Configuration().configure();
			sf=cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSf() {
		return sf;
	}

}
