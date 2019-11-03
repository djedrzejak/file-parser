<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Data from files</title>
</head>
<body>
	<div>
		<h3>Data from files</h3>
		<hr>	
		<table>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Postcode</th>
				<th>Phone</th>
				<th>Credit Limit</th>
				<th>Birthday</th>
				<th>File extension</th>
			</tr>
			<c:forEach var="person" items="${people}">
				<tr>
					<td>${person.name}</td>
					<td>${person.address}</td>
					<td>${person.postcode}</td>
					<td>${person.phone}</td>
					<td>${person.creditLimit}</td>
					<td>${person.birthday}</td>
					<td>${person.fileExtension}</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>
</body>
</html>