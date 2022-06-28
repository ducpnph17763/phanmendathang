<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assignment/css/bootstrap.min.css" />
</head>
<body>
	<div class="col-lg-10 offset-1">
	<h1 class="text-center">Sửa số lượng</h1>
		<form:form action="assignment/sua/${ord.id}" method="post"
			modelAttribute="ord">
			<div class="form-group">
				<form:input path="quantity" class="form-control" />
			</div>
			<button class="btn btn-primary">Lưu</button>
		</form:form>
	</div>

	<script src="/assignment/js/jquery.min.js"></script>
	<script src="/assignment/js/popper.min.js"></script>
	<script src="/assignment/js/bootstrap.min.js"></script>
</body>
</html>