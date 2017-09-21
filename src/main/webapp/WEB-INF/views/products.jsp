<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<metacharset="UTF-8">
<title>Catalogue de produits</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<body>
	<div id="formProducts">
		<f:form modelAttribute="product" method="post" action="saveProduct">
			<table class="table1">
				<tr>
					<th>Référence:</th>
					<td><f:input path="reference" /></td>
				</tr>
				<tr>
					<th>Désignation:</th>
					<td><f:input path="designation" /></td>
				</tr>
				<tr>
					<th>Prix:</th>
					<td><f:input path="price" /></td>
				</tr>
				<tr>
					<th>Quantité:</th>
					<td><f:input path="amount" /></td>
				</tr>
				<f:hidden path="id" />
				<tr>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</f:form>
	</div>
	<div id="listProducts">
		<table class="table2">
			<tr>
				<th>REF</th>
				<th>DESIGNATION</th>
				<th>PRIX</th>
				<th>QUANTITE</th>
			</tr>
			<c:forEach items="${products}" var="p">
				<tr>
					<td>${p.reference}</td>
					<td>${p.designation}</td>
					<td>${p.price}</td>
					<td>${p.amount}</td>
					<td><a href="deleteProduct?ref=${p.reference}">Supprimer</a></td>
					<td><a href="editProduct?ref=${p.reference}">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>