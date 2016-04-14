package Controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import TO.UsuarioTO;
//import Model.Usuario;


@WebServlet("/Transferencia.do")
public class TransferenciaController {
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
		long 	agencia = Long.parseLong(request.getParameter("agencia"));
		long 	conta 	= Long.parseLong(request.getParameter("conta"));
		double 	valor 	= Double.parseDouble(request.getParameter("valor"));
		
		Usuario usuario = new Usuario();
		
		if (pAcao.equals("Transferir")) {
			usuario.transferir(agencia, conta, valor);
		}
		//usuario.carrega();   
		UsuarioTO to = new UsuarioTO();   
		to.setAgencia(usuario.getAgencia());   
		to.setConta(usuario.getConta());   
		to.setSaldo(usuario.getSaldo());   
		request.setAttribute("usuario", to);
		RequestDispatcher view = request.getRequestDispatcher("Transferencia.jsp"); 
		view.forward(request, response);
		
	}

}
