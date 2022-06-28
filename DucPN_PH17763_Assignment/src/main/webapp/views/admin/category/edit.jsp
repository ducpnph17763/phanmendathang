<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
		<form:form method="POST"
			action="/assignment/admin/category/update/${cate.id}" modelAttribute="cate">
			<div class="form-group">
				<label>Name</label>
				<form:input path="name" class="form-control" />
			</div>
			<button class="btn btn-primary">Update</button>
		</form:form>
	</div>
	<script src="/assignment/js/jquery.min.js"></script>
	<script src="/assignment/js/popper.min.js"></script>
	<script src="/assignment/js/bootstrap.min.js"></script>
</body>
</html>