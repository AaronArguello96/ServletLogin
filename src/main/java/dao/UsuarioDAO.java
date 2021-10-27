package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entities.Usuarios;

public class UsuarioDAO {

	public boolean validate(Session s, String nombreUsuario, String password) {
		
		List<Usuarios> listaUsuarios = s.createNativeQuery("SELECT * FROM usuarios WHERE nombre ='" + nombreUsuario + "'and clave='" + password + "'").list();
		/*
        List result = s.createQuery("select u from usuarios u where u.nombre=:nombreUsuario and u.clave=:password")
       .setParameter("nombreUsuario", usuario.getNombre())
       .setParameter("password", usuario.getClave())
       .list()*/;
		
		if (listaUsuarios.isEmpty() ) {
			return false;
		}else {
			return true;
		}

		
	}
}
