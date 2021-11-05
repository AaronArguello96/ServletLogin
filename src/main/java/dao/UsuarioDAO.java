package dao;

import java.util.List;
import org.hibernate.Session;
import entities.Usuarios;
import utils.HibernateUtil;

public class UsuarioDAO {

	public boolean validate(String nombreUsuario, String password) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();

		List<Usuarios> listaUsuarios = s.createNativeQuery("SELECT * FROM usuarios WHERE nombre ='" + nombreUsuario + "'and clave='" + password + "'").list();
		
		if (listaUsuarios.isEmpty() ) {
			return false;
		}else {
			return true;
		}
	}
	
	public Integer rolUsuario(String nombreUsuario, String password) {
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		List<Usuarios> listaUsuarios = s.createNativeQuery("SELECT * FROM usuarios WHERE nombre ='" + nombreUsuario + "'and clave='" + password + "'", Usuarios.class).list();	
		Usuarios usuario = listaUsuarios.get(0);
		Integer rol = usuario.getRoles();
		return rol;
	}
}
