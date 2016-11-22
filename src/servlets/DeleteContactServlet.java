package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.services.interfaces.IContactService;

/**
 * Servlet implementation class NewContact
 */
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContactServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteContact doPost");
		
		String id = request.getParameter("id");
		
		/*TODO: vérification confirmité des champs*/
		boolean okId = id!=null && id.length()>0;
		long idLong = 0;
		try {
			idLong = Long.parseLong(id);
		} catch (NumberFormatException e){
			okId = false;
		}
		
		if(okId){
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			IContactService contactService = (IContactService) context.getBean("contactService");
			contactService.deleteContact(idLong);
			request.setAttribute("message", "Contact with id n°"+id+" has been correctly delete !");
			RequestDispatcher dispatcher = request.getRequestDispatcher("MyContactServlet");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("message", "Error with the field...");
			RequestDispatcher dispatcher = request.getRequestDispatcher("MyContactServlet");
			dispatcher.forward(request, response);
		}
	}

}
