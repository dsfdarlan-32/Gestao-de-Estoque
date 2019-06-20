<!DOCTYPE html>
<head>
	<title>Unidade</title>
	<meta charset="utf-8"></meta>
	<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
  	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

		<style>
			.etyle4{
			 margin: 10px 50px auto 50px;
		     width: 25%;
				}
				th{
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
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span> 
	      </button>
	      <a class="navbar-brand" href="">Gestão de Estoque</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li><a href="Home.html">Home</a></li>
	        <li><a href="cadastrarFornecedor.html">Fornecedor</a></li>
	        <li><a href="cadastrarMaterial.html">Material</a></li>
	        <li class="active"><a href="cadastroUnidade.html">Unidade</a></li>
	        <li><a href="localDeEstocagem.html">Local de estocagem</a></li>
	        <li><a href="cadastrarProjeto.html">Projeto</a></li>
	        <li><a href="AdmistrarProjetos.html">Administrar Projeto</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	
	<form class="form-horizontal" action="unidade.jsp" method="post">
		<fieldset>
			<div class="panel panel-primary">
				<div class="panel-heading">Cadastrar Unidade</div>
				<div class="panel-body">
					<div class="form-group">

						<div id="newpost">
							<div class="form-group">
								<div class="col-md-2 control-label">
									<h3>Unidade</h3>
								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-2 control-label" for="vinculo">Unidade:</label>
								<div class="col-md-2">
									<input id="unidade" name="unidade" placeholder="PC"
										class="form-control input-md" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label" for="Estado Civil">Descricão:</label>
								<div class="col-md-2">
									<input id="descricao" name="descricao"
										placeholder="Peça" class="form-control input-md"
										type="text">
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
	<table id="txtTable" width="60%" cellspacing="0" border="2" 	CELLSPACING=2 CELLPADDING=5 RULES=rows>
		<CAPTION>
			<h1>Unidade</h1>
		</CAPTION>
		<thead>
			<tr>
				<th>Unidade:</th>
				<th>Descricao�o</th>
			</tr>
		</thead>
		<tbody>
			<%@ page language="java" import="br.com.unisys.controller.UnidadeAction"%>
			<%@ page language="java" import="br.com.unisys.DAO.Unidade"%>
			<%@ page language="java" import="java.util.ArrayList"%>
			<%@ page language="java" import="java.util.List"%>
			<%
				List<Unidade> listaUnidade = new ArrayList<Unidade>();
				UnidadeAction localEstocagemAction = new UnidadeAction();
				listaUnidade = localEstocagemAction.buscaUnidade();
				for (Unidade forn : listaUnidade) {
			%>
			<tr>
				<td><%=forn.getUnidade()%></td>
				<td><%=forn.getDescricao()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
		<script>
		  $(document).ready(function(){
			  $('#txtTable').DataTable({
				"language": {
						"lengthMenu": "Mostrando _MENU_ registros por pagina",
						"zeroRecords": "Nada encontrado",
						"info": "Mostrando pagina _PAGE_ de _PAGES_",
						"infoEmpty": "Nenhum registro disponÃ­vel",
						"infoFiltered": "(filtrado de _MAX_ registros no total)"
					}
				});
		  });
		</script>

</body>
</html>