package dao;

import java.util.List;
import org.hibernate.Session;
import entities.Roles;
import utils.HibernateUtil;

public class RolDAO {

	public static List<Roles> getRoles(Session s) {
		/*
		Query query =miSesion.createQuery("from roles", Roles.class);
		List<Roles> roles = query.list();
		*/
		List<Roles> roles = s.createNativeQuery("SELECT * FROM roles", Roles.class).list();
		
		return roles;
	}
	
	public static List<Roles> getRoles(){
		
		Session s = HibernateUtil.getSessionFactory().openSession();		
		List<Roles> list = getRoles(s);
		
		return list;
	}
	
	public void insertRol(String nombreRol) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		Roles rol = new Roles();
		rol.setRol(nombreRol);
		s.save(rol);
		s.getTransaction().commit();
		
	}
	
}
