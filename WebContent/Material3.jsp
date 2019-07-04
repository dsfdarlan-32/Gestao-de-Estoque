<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Material</title>
</head>
<body>
<%@ page language="java" import = "br.com.unisys.controller.MaterialAction" %>
	<%
	MaterialAction materialAction = new MaterialAction();
	materialAction.buscaMatNaoPago();

	response.sendRedirect("cadastrarMaterial.jsp");

	%>
</body>
</html>