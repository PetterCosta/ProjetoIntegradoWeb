package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import TO.UsuarioTO;

@WebServlet("/EfetuarSaque.do")
public class SaqueController {

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
		
		
		//Vai trazer os dados do html para a classe
		String 	pAcao 	= request.getParameter("acao");
		double 	valor 	= Double.parseDouble(request.getParameter("valor"));
		Usuario usuario = new Usuario(/*agencia, conta*/);
		if (pAcao.equals("SACAR")) {
			try {
				usuario.efetuarSaque( valor );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			usuario.carrega();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		UsuarioTO to = new UsuarioTO();   
		to.setAgencia(usuario.getAgencia());   
		to.setConta(usuario.getConta());   
		to.setSaldo(usuario.getSaldo());   
		request.setAttribute("usuario", to);
		RequestDispatcher view = request.getRequestDispatcher("Saque.jsp"); 
		view.forward(request, response);
		
		
		
		
	}
}
