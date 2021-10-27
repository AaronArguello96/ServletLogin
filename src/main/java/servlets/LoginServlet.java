package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import dao.UsuarioDAO;
import utils.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "/LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	static SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
				pw.println("¡Bienvenido a mi tienda online!");
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