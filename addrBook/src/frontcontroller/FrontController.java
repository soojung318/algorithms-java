package frontcontroller;

import dto.AddrBookDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AddrBookAllService;
import command.Service;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		if(command.equals("/addrBooksAll.do")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<html><head></head><body>");
			
			Service service = new AddrBookAllService();
			ArrayList<AddrBookDto> dtos = service.execute(request, response);
		
			for(int i=0; i<dtos.size(); i++) {
				AddrBookDto dto = dtos.get(i);
				int ab_id = dto.getAb_id();
				String ab_name = dto.getAb_name();
				String ab_email = dto.getAb_email();
				String ab_birth = dto.getAb_birth();
				String ab_tel = dto.getAb_tel();
				String ab_comdept = dto.getAb_comdept();
				String ab_memo = dto.getAb_memo();
				
				writer.println(ab_id+","+ab_name+","+ab_email+","+ab_birth+","+ab_tel+","+ab_comdept+","+ab_memo+"<hr/>");
			}
			writer.println("</body></html>");
		}
		
		else if(command.equals("/list.do")) {
			
		}
		else if(command.equals("/insertAddr.do")) {
			
		}
		else if(command.equals("/delete.do")) {
			
		}
	}
	

}
