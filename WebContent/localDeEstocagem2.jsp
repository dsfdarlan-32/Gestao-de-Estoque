<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Local de Estocagem</title>
<meta charset="utf-8"></meta>
<meta http-equiv=âContent-Typeâ content=âtext/html;
	charset=utf-8â³>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
.etyle4 {
	margin: 10px 50px auto 50px;
	width: 25%;
}

th {
	color: #ffffff;
	font-family: Verdana, Arial, Helvetica;
	font-size: 14px;
	background-color: #007cc2;
}

td {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	table-layout: fixed;
	height: 10px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">GestÃ£o de Estoque</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="Home.html">Home</a></li>
					<li><a href="cadastrarFornecedor2.jsp">Fornecedor</a></li>
			        <li><a href="cadastrarMaterial.jsp">Material</a></li>
			        <li><a href="cadastroUnidade2.jsp">Unidade</a></li>
			        <li class="active"><a href="localDeEstocagem2.jsp">Local de estocagem</a></li>
			       	<li><a href="cadastrarProjeto2.jsp">Projeto</a></li>
			        <li><a href="AdmistrarProjetos2.jsp">Administrar Projeto</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<form class="form-horizontal" action="localEstocagem.jsp" method="post">
		<fieldset>
			<div class="panel panel-primary">
				<div class="panel-heading">Local de estocagem</div>
				<div class="panel-body">
					<div class="form-group">

						<div id="newpost">
							<div class="form-group">
								<div class="col-md-2 control-label">
									<h3>Local de estocagem</h3>
								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-2 control-label" for="vinculo">Codigo
									local:</label>
								<div class="col-md-2">
									<input id="codLocal" name="codLocal" placeholder="Codigo"
										class="form-control input-md" type="text">
								</div>
								<label class="col-md-1 control-label" for="Nome">Corredor:</label>
								<div class="col-md-2">
									<input id="corredor" name="corredor" placeholder="corredor"
										class="form-control input-md" type="text">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label" for="Estado Civil">Prateleira:</label>
								<div class="col-md-2">
									<input id="prateleira" name="prateleira"
										placeholder="prateleira" class="form-control input-md"
										type="text">
								</div>
								<label class="col-md-1 control-label" for="Estado Civil">Andar:</label>
								<div class="col-md-2">
									<input id="andar" name="andar" placeholder="Andar"
										class="form-control input-md" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label" for="Estado Civil">Box:</label>
								<div class="col-md-2">
									<input id="box" name="box" placeholder="Box"
										class="form-control input-md" type="text">
								</div>
							</div>
							<!-- Button (Double) -->
							<div class="form-group">
								<label class="col-md-2 control-label" for="Cadastrar"></label>
								<div class="col-md-8">
									<button id="Cadastrar" name="Cadastrar" class="btn btn-success"
										type="Submit">Cadastrar</button>
									<button id="Cancelar" name="Cancelar" class="btn btn-primary"
										type="Reset">Limpar</button>
									<button id="Cancelar" name="Cancelar" class="btn btn-danger"
										type="Reset">Cancelar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</fieldset>
	</form>

	<div class="container">
		<table id="txtTable" width="60%" cellspacing="0" border="2"
			CELLSPACING=2 CELLPADDING=5 RULES=rows>
			<CAPTION>
				<h1>Local de estocagem</h1>
			</CAPTION>
			<thead>
				<tr>
					<th>Codigo local</th>
					<th>Prateleira</th>
					<th>Box</th>
					<th>Corredor</th>
					<th>Andar</th>
				</tr>
			</thead>
			<tbody>
				<%@ page language="java" import="br.com.unisys.controller.LocalEstocagemAction"%>
				<%@ page language="java" import="br.com.unisys.DAO.LocalEstocagem"%>
				<%@ page language="java" import="java.util.ArrayList"%>
				<%@ page language="java" import="java.util.List"%>
				<%
					List<LocalEstocagem> listaLocalEstocagem = new ArrayList<LocalEstocagem>();
					LocalEstocagemAction localEstocagemAction = new LocalEstocagemAction();
					listaLocalEstocagem = localEstocagemAction.buscaLocalEstocagem();
					for (LocalEstocagem forn : listaLocalEstocagem) {
				%>
				<tr>
					<td><%=forn.getCodLocal()%></td>
					<td><%=forn.getPrateleira()%></td>
					<td><%=forn.getBox()%></td>
					<td><%=forn.getCorredor()%></td>
					<td><%=forn.getAndar()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<script>
		$(document).ready(function() {
			$('#txtTable').DataTable({
				"language" : {
					"lengthMenu" : "Mostrando _MENU_ registros por pagina",
					"zeroRecords" : "Nada encontrado",
					"info" : "Mostrando pagina _PAGE_ de _PAGES_",
					"infoEmpty" : "Nenhum registro disponÃÂ­vel",
					"infoFiltered" : "(filtrado de _MAX_ registros no total)"
				}
			});
		});
	</script>
</body>
</html>