/**
 * 
 */
package com.himanshugoyal.tech.app.ws.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author himanshugoyal
 *
 */
public class HibernateUtils {
	
	/**
	 * SessionFactory
	 * Session is an interface. 
	 * SessionFactory can be created by providing Configuration object, which will contain all DB related property details pulled from either hibernate.cfg.xml file or hibernate.properties file.
	 * SessionFactory is a factory for Session objects. 
	 * If your application is referring to multiple databases, then you need to create one SessionFactory per database.
	 * https://www.java2novice.com/hibernate/session-factory/
	 * 
	 * Static Final
	 * Static final must be assigned value here or inside static block.
	 * Static variables are shared among all the objects of a class; 
	 * creating a new object would change the same static variable which is not allowed if the static variable is final.
	 */
	private static final SessionFactory sessionFactory;
	
	static {
		Configuration conf = new Configuration();
		conf.configure();
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e){
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
