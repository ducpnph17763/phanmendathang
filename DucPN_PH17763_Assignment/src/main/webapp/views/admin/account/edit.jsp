<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-10 offset-1">
		<form:form method="POST"
			action="/assignment/admin/account/update/${account.id}"
			modelAttribute="account">
			<div class="form-group">
				<label>Fullname</label>
				<form:input path="fullname" class="form-control" />
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" type="email" class="form-control" />
			</div>
			<div class="form-group">
				<label>Username</label>
				<form:input path="username" class="form-control" />
			</div>
			<div class="form-group">
				<label>Password</label>
				<form:password path="password" class="form-control" />
			</div>
			<div class="form-group">
				<label>Photo</label>
				<form:input path="photo" class="form-control" />
			</div>
			<div class="form-group">
				<label>Admin</label>
				<form:select path="admin">
					<form:option value="0">Member</form:option>
					<form:option value="1">Admin</form:option>
				</form:select>
			</div>
			<button>Save</button>
		</form:form>
	</div>

</body>
</html>