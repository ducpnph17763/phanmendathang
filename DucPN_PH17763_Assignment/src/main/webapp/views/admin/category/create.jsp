<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - Create category</title>
</head>
<body>
	<div class="col-lg-10 offset-1">
		<form:form method="POST" action="/assignment/admin/category/store"
			modelAttribute="category">
			<div>
				<label>Name</label>
				<form:input path="name" />
			</div>
			<button>Save</button>
		</form:form>
	</div>
</body>
</html>