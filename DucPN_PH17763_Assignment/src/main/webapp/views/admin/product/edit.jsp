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
	<div class="col-10 offset-1">
		<form:form method="POST"
			action="/assignment/admin/product/update/${pro.id }" modelAttribute="pro">
			<div class="form-group">
				<label>Name</label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<label>Gia</label>
				<form:input path="price" class="form-control" />
			</div>
			<div class="form-group">
				<label>Anh</label>
				<form:input path="image" class="form-control" />
			</div>
			<div class="form-group">
				<label>Available</label>
				<form:select path="available">
					<form:option value="0">Không</form:option>
					<form:option value="1">Có</form:option>
				</form:select>
			</div>
			<div>
				<label>Category</label>
				<form:select path="category">
					<c:forEach items="${cate}" var="cate">
						<form:option value="${cate.id}">${cate.name}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<button class="btn btn-primary">Save</button>
		</form:form>
	</div>
	<script src="/assignment/js/jquery.min.js"></script>
	<script src="/assignment/js/popper.min.js"></script>
	<script src="/assignment/js/bootstrap.min.js"></script>
</body>
</html>