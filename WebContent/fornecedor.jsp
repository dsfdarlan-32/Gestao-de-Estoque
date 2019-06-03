<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>fornecedor</title>
</head>
<body>
<%@ page language="java" import = "br.com.unisys.controller.FornecedorAction" %>
	
	<%
	FornecedorAction fornecedorAction = new FornecedorAction();
	String status = fornecedorAction.adicionaFornecedor(request, response);
	if(status.equals("OK")){  
	response.sendRedirect("cadastrarFornecedor.html");
	}else{
		
	}
	%>

</body>
</html>