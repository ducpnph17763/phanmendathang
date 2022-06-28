<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-lg-10 offset-1">
	<h1 class="text-center">Dang ki</h1>
	<form:form method="post" action="/assignment/dangki"
		modelAttribute="acc">
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
			<form:input path="photo" name="photo" class="form-control" />
			<form:errors path="photo" class="text-danger"></form:errors>
		</div>
		<button class="btn btn-primary">Dang ki</button>
	</form:form>
</div>
