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
	<div class="col-lg-10 offset-1">
		<h1 class="text-center">DANG NHAP</h1>
		<form:form method="post" action="/assignment/dangnhap"
			modelAttribute="acc">
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" type="email" class="form-control" />
			</div>
			<div class="form-group">
				<label>Mat khau</label>
				<form:password path="password" class="form-control" />
			</div>
			<button class="btn btn-primary">Dang nhap</button>
		</form:form>
	</div>

</body>
</html>