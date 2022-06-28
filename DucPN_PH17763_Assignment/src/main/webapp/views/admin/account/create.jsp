<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - Create Account</title>
<link rel="stylesheet" href="/assignment/css/bootstrap.min.css" />
</head>
<body>
	<div class="p-5 col-lg-12">
		<form:form method="POST" action="/assignment/admin/account/store"
			modelAttribute="account" enctype="multipart/form-data">
			<div class="form-group">
				<label>Fullname</label>
				<form:input path="fullname" name="fullname" class="form-control" />
				<form:errors path="fullname" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" type="email" name="email"
					class="form-control" />
				<form:errors path="email" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Username</label>
				<form:input path="username" name="username" class="form-control" />
				<form:errors path="username" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Password</label>
				<form:password path="password" name="password" class="form-control" />
				<form:errors path="password" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Photo</label>
				<form:password path="photo" name="photo" class="form-control" />
				<form:errors path="photo" class="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<label>Admin</label>
				<form:select path="admin">
					<form:option value="0">Member</form:option>
					<form:option value="1">Admin</form:option>
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