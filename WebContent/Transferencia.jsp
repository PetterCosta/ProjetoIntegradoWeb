<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@page import= "TO.UsuarioTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transferencia Usuario</title>
</head>
<body>
	<form action="Transferencia.do" method="post">
			<%UsuarioTO to = (UsuarioTO)request.getAttribute("usuario"); %> 
			Id: <%=to.getAgencia() %><br>
			Nome: <%=to.getConta() %><br>
			Fone: <%=to.getSaldo() %><br>
		</form>
</body>
</html>

