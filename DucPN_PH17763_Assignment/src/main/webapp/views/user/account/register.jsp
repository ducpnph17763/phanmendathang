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
	<div class="contaner">
		<div class="row">
		<div class="col-lg-5"></div>
			<div class="text-center col-lg-6"> 
			<h1>Đăng kí</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="p-5 col-lg-6">
				<form:form method="POST" action="/assignment/user/account/dangki"
					modelAttribute="account">
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
						<form:password path="password" name="password"
							class="form-control" />
						<form:errors path="password" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label>Photo</label>
						<form:input path="photo" class="form-control" />
						<form:errors path="photo" class="text-danger"></form:errors>
					</div>
					<button class="btn btn-primary">Đăng kí</button>
				</form:form>
			</div>
		</div>
	</div>

	<script src="/assignment/js/jquery.min.js"></script>
	<script src="/assignment/js/popper.min.js"></script>
	<script src="/assignment/js/bootstrap.min.js"></script>
</body>
</html>