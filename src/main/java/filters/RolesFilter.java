package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuarios;

/**
 * Servlet Filter implementation class RolesFilter
 */
public class RolesFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RolesFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession(true);	
		String path = req.getRequestURI(); 
		Usuarios user = (Usuarios) req.getSession().getAttribute("rol");
		
		//Si el usuario registrado tiene rol 2 (empleado) o rol 3 (cliente) se le devuelve al menu
	 	if (user == null) { 
	 		switch(user.getRoles()) {
	 		case 1: //Administrador
	 				res.sendRedirect("Alta_nuevo_rol.jsp");			
	 		case 2: //Empleado
	 			res.sendRedirect("Menu.jsp");	
	 		case 3: //Cliente
	 			res.sendRedirect("Menu.jsp");
	 		}	
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
