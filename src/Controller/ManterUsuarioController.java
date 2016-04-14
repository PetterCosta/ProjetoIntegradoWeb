package Controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Usuario;
/**
 * Servlet implementation class ManterUsuarioController
 */
@WebServlet("/ManterUsuario.do")
public class ManterUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String pSenha = request.getParameter("senha");
		String pAgencia = request.getParameter("agencia");
		String pConta = request.getParameter("conta");
		long agencia = Long.parseLong(pAgencia);
		long conta = Long.parseLong(pConta);
				
		
		Usuario usuario = new Usuario(agencia, conta, pSenha);
		/*Usuario.criar();
		Usuario.carregar();*/
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Usuario Cadastrado</title></head><body>");
		out.println( "nome: "+usuario.getNome()+"<br>");
		out.println( "conta: "+usuario.getConta()+"<br>");
		out.println( "agencia: "+usuario.getAgencia()+"<br>");
		out.println("</body></html>");
	}
}