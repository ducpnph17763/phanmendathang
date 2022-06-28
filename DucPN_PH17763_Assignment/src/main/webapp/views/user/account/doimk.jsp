<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 class="text-center">DANG NHAP</h1>
	<form:form method="post" action="/assignment/doi">
		<div>
			<label>Mat khau cu</label>
			<form:password path="password"/>
		</div>
		<div>
			<label>Mat khau moi</label>
			<form:password path="password" />
		</div>
		<div>
			<label>Xac nhan mat khau moi</label>
			<form:password path="password" />
		</div>
		<button class="btn btn-primary">Dang nhap</button>
	</form:form>
</body>
</html>