package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import entities.Categorias;
import utils.HibernateUtil;

public class CategoriaDAO {

	public void insertCategoria(String nombre, String descripcion) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		Categorias categoria = new Categorias();
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		s.save(categoria);
		s.getTransaction().commit();
	}
	
	public static ArrayList<Categorias> getCategorias(Session s) {

		ArrayList<Categorias> categorias = (ArrayList<Categorias>) s.createNativeQuery("SELECT * FROM categorias", Categorias.class).list();
		
		return categorias;
	}
	
	public static ArrayList<Categorias> getCategorias(){
		
		Session s = HibernateUtil.getSessionFactory().openSession();		
		ArrayList<Categorias> list = getCategorias(s);
		
		return list;
	}
	
}
