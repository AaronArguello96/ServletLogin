package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.UsuarioDAO;
import entities.Usuarios;
import utils.HibernateUtil;

/**
 * Servlet implementation class RestriccionesRoles
 */
@WebServlet("/RestriccionesRoles")
public class RestriccionesRoles extends HttpServlet {
	
	static SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestriccionesRoles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		logger.info("Comienza la ejecución del servlet de login.");

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");

			String user = request.getParameter("userName");
			String pass = request.getParameter("userPassword");
			
			UsuarioDAO usuario = new UsuarioDAO();     	

			if (usuario.validate(session, user, pass)) {
				logger.info("El usuario se ha logueado correctamente.");
				Usuarios datosUsuario = new Usuarios();
				//String apellido1 = datosUsuario.getApellido1();
				//String apellido2 = datosUsuario.getApellido2();
				Integer rol = datosUsuario.getRoles();
				HttpSession session1 = request.getSession(true);
				session1.setAttribute("nombre", user);
				//session1.setAttribute("apellido1", apellido1);
				//session1.setAttribute("apellido2", apellido2);
				session1.setAttribute("rol", rol);
				response.sendRedirect("Menu.jsp");  
			} else {
				logger.info("El usuario no ha introducido las credenciales correctamente.");
				response.sendRedirect("Index.html");  
			}

			pw.close();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error al consultar el usuario ingresado por login", e);

		} finally {
			if (session != null) {
				session.close();
				logger.info("Cerramos la sesion del servlet login");
			}
		}

		// Cerramos la sesion
		session.close();

		logger.info("Se acaba la ejecución del servlet login.");
	}

}