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
import dao.CategoriaDAO;
import utils.HibernateUtil;

/**
 * Servlet implementation class AltaCategoriaServlet
 */
@WebServlet(name = "AltaCategoriaServlet", urlPatterns = "/AltaCategoriaServlet")
public class AltaCategoriaServlet extends HttpServlet {
	
	static SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(AltaCategoriaServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCategoriaServlet() {
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
		logger.info("Comienza la ejecución del servlet de alta de categorias.");

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");

			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			
			CategoriaDAO categoriadao = new CategoriaDAO();     	

			categoriadao.insertCategoria(nombre, descripcion);
			
			response.sendRedirect("Menu.jsp");
			
			logger.info("El usuario ha insertado una categoria en la BD.");
			
			pw.close();
			
		} catch (Exception e) {
			logger.error("Error al ingresar una categoria.", e);

		} finally {
			if (session != null) {
				session.close();
				logger.info("Cerramos la sesion del servlet alta categoria.");
			}
		}

		// Cerramos la sesion
		session.close();

		logger.info("Se acaba la ejecución del servlet alta categoria.");
	}

}
