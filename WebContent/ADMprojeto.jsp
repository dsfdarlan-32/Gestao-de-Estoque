<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>ADMProjeto</title>
</head>
<body>
<%@ page language="java" import = "br.com.unisys.controller.ADMProjetosAction" %>
	
	<%
	ADMProjetosAction aDMProjetosAction = new ADMProjetosAction();
	String status = aDMProjetosAction.adicionaMaterais(request, response);
	if(status.equals("OK")){  
	response.sendRedirect("AdmistrarProjetos2.jsp");
	}else{
		
	}
	%>
</body>
</html>