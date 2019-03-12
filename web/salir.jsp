<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
	response.sendRedirect("index.jsp");
%>    
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Saliendo...</title>
</head>
<body>
</body>
</html>