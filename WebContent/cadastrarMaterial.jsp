<!DOCTYPE html>
<head>
<title>Material</title>
<meta charset="utf-8"></meta>
<meta http-equiv=â€Content-Typeâ€ content=â€text/html; charset=utf-8â€³>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
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
				<a class="navbar-brand" href="">Gestão de Estoque</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="Home.html">Home</a></li>
					<li><a href="cadastrarFornecedor2.jsp">Fornecedor</a></li>
	        		<li class="active"><a href="cadastrarMaterial.jsp">Material</a></li>
	        		<li><a href="cadastroUnidade2.jsp">Unidade</a></li>
	        		<li><a href="localDeEstocagem2.jsp">Local de estocagem</a></li>
	       		 	<li><a href="cadastrarProjeto2.jsp">Projeto</a></li>
	        		<li><a href="AdmistrarProjetos2.jsp">Administrar Projeto</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<form class="form-horizontal" action="Material.jsp" method="post">
		<fieldset>
			<div class="panel panel-primary">
				<div class="panel-heading">Cadastrar Material</div>
				<div class="panel-body">
					<div class="form-group">

						<div id="newpost">
							<div class="form-group">
								<div class="col-md-2 control-label">
									<h3>Material</h3>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label" for="vinculo">Fornecedor:</label>
								<div class="col-md-2">
									<input id="fornecedor" name="fornecedor"
										placeholder="Fornecedor" class="form-control input-md"
										type="text">
								</div>
								<label class="col-md-1 control-label" for="Estado Civil">Estoque:</label>
								<div class="col-md-2">
									<input id="estoque" name="estoque" placeholder="Estoque"
										class="form-control input-md" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label" for="Estado Civil">Produto:</label>
								<div class="col-md-2">
									<input id="produto" name="produto" placeholder="Produto"
										class="form-control input-md" type="text">
								</div>
								<label class="col-md-1 control-label" for="Estado Civil">Quantidade:</label>
								<div class="col-md-2">
									<input id="quantidade" name="quantidade"
										placeholder="Quantidade" class="form-control input-md"
										type="number">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label" for="Estado Civil">Preço
									R$:</label>
								<div class="col-md-2">
									<input id="preco" name="preco" class="form-control input-md"
										placeholder="Valor R$" type="number" step=0.01>
								</div>
								<label class="col-md-1 control-label" for="Estado Civil">Status:</label>
								<div class="col-md-2">
									<select required id="status" name="status" class="form-control">
										<option value="">Selecione</option>
										<option value="Pago">Pago</option>
										<option value="Não Pago">Não Pago</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label" for="Estado Civil">Unidade:</label>
								<div class="col-md-2">
									<select required id="unidade" name="unidade"
										class="form-control">
										<option value="">Selecione</option>
										<option value="UN">UN</option>
										<option value="PC">PC</option>
									</select>
								</div>
								<label class="col-md-1 control-label" for="Estado Civil">Data
									Vencimento:</label>
								<div class="col-md-2">
									<input id="data" name="data" placeholder="Data Vencimento:"
										class="form-control input-md" type="date">
								</div>
							</div>
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
				<h1>Material</h1>
			</CAPTION>
			<thead>
				<tr>
					<th>nome</th>
					<th>Quandidade</th>
					<th>Estoque</th>
					<th>Status</th>
					<th>Unidade</th>
					<th>Data vencimento</th>
				</tr>
			</thead>
			<tbody>
				<%@ page language="java"
					import="br.com.unisys.controller.MaterialAction"%>
				<%@ page language="java" import="br.com.unisys.DAO.Material"%>
				<%@ page language="java" import="java.util.ArrayList"%>
				<%@ page language="java" import="java.util.List"%>

				<%
				List<Material> listaMaterial = new ArrayList<Material>();
				MaterialAction materialAction = new MaterialAction();
				listaMaterial = materialAction.buscaMaterial();
				for (Material forn : listaMaterial) {
				%>
				<tr>
					<td><%=forn.getProduto() %></td>
					<td><%=forn.getQuantidade() %></td>
					<td><%=forn.getEstoque() %></td>
					<td><%=forn.getStatusM() %></td>
					<td><%=forn.getUnidade() %></td>
					<td><%=forn.getDataVecimento() %></td>
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
				"infoEmpty" : "Nenhum registro disponÃƒÂ­vel",
				"infoFiltered" : "(filtrado de _MAX_ registros no total)"
			}
		});
	});
	</script>

</body>
</html>