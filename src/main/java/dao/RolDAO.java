package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import entities.Roles;
import utils.HibernateUtil;

public class RolDAO {

	public static ArrayList<Roles> getRoles(Session s) {

		ArrayList<Roles> roles = (ArrayList<Roles>) s.createNativeQuery("SELECT * FROM roles", Roles.class).list();
		
		return roles;
	}
	
	public static ArrayList<Roles> getRoles(){
		
		Session s = HibernateUtil.getSessionFactory().openSession();		
		ArrayList<Roles> list = getRoles(s);
		
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
