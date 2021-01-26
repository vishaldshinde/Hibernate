package org.techforce.hibernate.operations;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.ImageWrapper;

public class SaveBlob {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		///home/vishal/Downloads/vishal.jpeg
		File image=new File("/home/vishal/Downloads/vishal.jpeg");
		byte[] data=new byte[(int)image.length()];
		
		try {
			FileInputStream is=new FileInputStream(image);
			is.read(data);
			is.close();
		} catch (Exception e) {
			System.err.println("error while image reading.."+e);
		}
		
		ImageWrapper iw=new ImageWrapper();
		iw.setId(1);
		iw.setData(data);
		iw.setName("vishal.jpeg");
		
		session.save(iw);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
