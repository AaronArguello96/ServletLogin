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
import dao.RolDAO;
import utils.HibernateUtil;

/**
 * Servlet implementation class AltaRolServlet
 */
@WebServlet(name = "AltaRolServlet", urlPatterns = "/AltaRolServlet")
public class AltaRolServlet extends HttpServlet {
	
	static SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaRolServlet() {
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
		try {
			
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");

			String nombreRol = request.getParameter("nombreRol");
			
			RolDAO roldao = new RolDAO();     	

			roldao.insertRol(nombreRol);
			
			response.sendRedirect("Menu.jsp");
			
			logger.info("El usuario ha insertado un rol en la BD.");
			
			pw.close();
			
		} catch (Exception e) {
			logger.error("Error al ingresar un rol", e);

		} finally {
			if (session != null) {
				session.close();
				logger.info("Cerramos la sesion del servlet alta rol");
			}
		}

		// Cerramos la sesion
		session.close();

		logger.info("Se acaba la ejecución del servlet alta rol.");
	}


}