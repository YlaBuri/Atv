<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login" method="post">
		<label>Login</label>
		<br>
		<input type="text" name="login" id="login">
		<br>
		<label>Senha</label>
		<br>
		<input type="password" name="senha" id="senha">
		<br>
		<input type="submit" name="enviar" id="enviar" value="entrar">
	</form>
	<%String erro=(String)request.getParameter("erro");
	if(erro!= null && !erro.trim().equals("")){
		out.print(erro);
	}
	%>
</body>
</html>