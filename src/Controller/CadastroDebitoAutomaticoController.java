package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroDebitoAutomaticoController {

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
		
		//String pCodigo 	= request.getParameter("codigo");
		String 	pSenha 	= request.getParameter("senha");
		double 	valor 	= Double.parseDouble(request.getParameter("valor"));
		long 	agencia = Long.parseLong(request.getParameter("agencia"));
		long 	conta 	= Long.parseLong(request.getParameter("conta"));
	}
}
