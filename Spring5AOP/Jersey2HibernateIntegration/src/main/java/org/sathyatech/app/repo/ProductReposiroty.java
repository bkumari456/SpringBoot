package org.sathyatech.app.repo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.sathyatech.app.model.Product;
import org.sathyatech.app.util.HibernateUtil;

public class ProductReposiroty {

	public static int saveProduct(Product p) {
		Session ses=HibernateUtil.getSf().openSession();
		ses.beginTransaction();
		Serializable s=ses.save(p);
		ses.getTransaction().commit();
		return (Integer)s;
	}

	@SuppressWarnings("unchecked")
	public static List<Product> getAllProducts() {
		Session ses=HibernateUtil.getSf().openSession();
		return ses.createQuery("from "+Product.class.getName()).getResultList();
	}
	
}
