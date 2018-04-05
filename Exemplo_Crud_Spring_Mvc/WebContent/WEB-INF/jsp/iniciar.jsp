<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Cadastro de pessoa</title>
<script type="text/javascript" src="../resources/js/funcoes.js"></script>


<!-- Jquery -->
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/ui-lightness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> 

</head>
<body>
	<form action="salvar" method="post">

		<label for="nome">Nome</label>	
		<input type="text" id="nome" name="nome">
		
		<br/>
		
		<label for="endereco">Endereço</label>
		<input type="text" id="endereco" name="endereco">
		
		<br/>
		<label for="fone">Telefone</label>
		<input type="text" id="fone" name="fone"><button onclick="addFone();" type="button">Adicionar</button>
		
		<div id="fones"></div>				
		
		<br/>
		<input type="submit" value="Salvar">
		 
		<input type="hidden" id="telefonePessoasTemp" 
		 name="telefonePessoasTemp" >
		 
	</form>
</body>
</html>