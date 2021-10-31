package dao;

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
	
	public static List<Categorias> getCategorias(Session s) {

		List<Categorias> categorias = s.createNativeQuery("SELECT * FROM categorias", Categorias.class).list();
		
		return categorias;
	}
	
	public static List<Categorias> getCategorias(){
		
		Session s = HibernateUtil.getSessionFactory().openSession();		
		List<Categorias> list = getCategorias(s);
		
		return list;
	}
}
