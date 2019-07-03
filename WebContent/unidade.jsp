<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>unidade</title>
</head>
<body>
<%@ page language="java" import = "br.com.unisys.controller.UnidadeAction" %>
	
	<%
	UnidadeAction unidadeAction = new UnidadeAction();
	String status = unidadeAction.adicionaUnidade(request, response);
	if(status.equals("OK")){  
	response.sendRedirect("cadastroUnidade2.jsp");
	}else{
		
	}
	%>

</body>
</html>