<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Cadastro de pessoa</title>
<script type="text/javascript" src="../resources/js/funcoes.js"></script>

</head>
<body>
		<h4>Pessoa Gravada com sucesso!</h4>
		<br/>
		
		<label for="nome">ID</label>	
		<input type="text" id="nome" name="nome" value="${pessoa.id}" readonly="readonly">
		
		<br/>

		<label for="nome">Nome</label>	
		<input type="text" id="nome" name="nome" value="${pessoa.nome}" readonly="readonly">
		
		<br/>
		
		<label for="endereco">Endereço</label>
		<input type="text" id="endereco" name="endereco" value="${pessoa.endereco}" readonly="readonly">
		
		<br/>
		
		<h3>Contatos:</h3>
		<br/>
		<table>
			<c:forEach var="contato" items="${pessoa.telefonePessoas}">
				<tr>
					<td>${contato.numero}</td>
				</tr>
			</c:forEach>
		
		</table>
		
		 
</body>
</html>