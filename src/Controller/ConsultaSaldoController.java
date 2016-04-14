package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;


@WebServlet("/ConsultarSaldo.do")
public class ConsultaSaldoController {

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	doPost(request, response);
		Usuario usuario = new Usuario();
		String codHTML = 	
			"<html>"+
				"<head>"+
					"<title></title>"+
				"</head>"+
				"<body>"+
				"Nome: " + usuario.getNome() + "<br>"+
				"Saldo: " + usuario.getSaldo() + "<br>"+
				"<form action = \"VerificarSaudo.do\" method=\"post\">" + "<br/>" +
				"<input type = \"submit\" value = \"Imprimir\">" + 
				"<input type = \"submit\" value = \"MenuPrincipal\">" + 
				"</body>"+
			"</html>";
		PrintWriter imprimir = response.getWriter();
		imprimir.println(codHTML);	
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	}
}
