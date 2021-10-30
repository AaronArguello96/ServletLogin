package dao;

import java.util.List;

import org.hibernate.Session;

import entities.Roles;
import entities.Usuarios;

public class UsuarioDAO {

	public boolean validate(Session s, String nombreUsuario, String password) {
		
		List<Usuarios> listaUsuarios = s.createNativeQuery("SELECT * FROM usuarios WHERE nombre ='" + nombreUsuario + "'and clave='" + password + "'").list();
		
		if (listaUsuarios.isEmpty() ) {
			return false;
		}else {
			return true;
		}
	}
	
	public Integer rolUsuario(Session s, String nombreUsuario, String password) {
		List<Usuarios> listaUsuarios = s.createNativeQuery("SELECT * FROM usuarios WHERE nombre ='" + nombreUsuario + "'and clave='" + password + "'", Usuarios.class).list();
		
		Usuarios usuario = listaUsuarios.get(0);
		Integer rol = usuario.getRoles();
		return rol;
	}
}
