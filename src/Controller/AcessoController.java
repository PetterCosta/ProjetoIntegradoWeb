package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;

public class AcessoController {

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
		long 	conta	 	= Long.parseLong(request.getParameter("conta"));
		long 	agencia 	= Long.parseLong(request.getParameter("agencia"));
		String 	senha 	= request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setSenha(senha);
		usuario.setConta(conta);
		usuario.setAgencia(agencia);
		//usuario.autenticar();
	}
	
}
