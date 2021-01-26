package org.techforce.hibernate.operations;

import java.io.File;
import java.io.FileOutputStream;

import org.hibernate.Session;
import org.techforce.hibernate.HibernateUtil;
import org.techforce.hibernate.entities.ImageWrapper;

public class GetBlob {

	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ImageWrapper iw=session.get(ImageWrapper.class, 1);
		
		byte[] data=iw.getData();
		
		try {
			FileOutputStream fos=new FileOutputStream(new File("/home/vishal/Downloads/bd_"+iw.getName()));
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			System.err.println("exception while reading image."+e);
		}

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
