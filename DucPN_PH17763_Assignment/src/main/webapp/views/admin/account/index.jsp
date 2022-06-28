<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - QL Account</title>
<link rel="stylesheet" href="/assignment/css/bootstrap.min.css" />
</head>
<body>
	<div class="table-responsive col-10 offset-1">
		<a class="btn btn-success" href="/assignment/admin/account/create">
			Create </a>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Full name</th>
					<th>User name</th>
					<th>Email</th>
					<th>Photo</th>
					<th>Activated</th>
					<th>Role</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ acc.content }" var="acc">
					<tr>
						<td>${ acc.id }</td>
						<td>${ acc.fullname }</td>
						<td>${ acc.username }</td>
						<td>${ acc.email }</td>
						<td><img src="${ acc.photo }" /></td>
						<td>${ acc.activated == 0 ? "In-Active" : "Active" }</td>
						<td>${ acc.admin == 1 ? "Admin" : "Member" }</td>
						<td><a class="btn btn-primary"
							href="/assignment/admin/account/edit/${ acc.id }"> Update </a></td>
						<td><a class="btn btn-danger"
							href="/assignment/admin/account/delete/${ acc.id }"> Delete </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row m-0">
			<ul class="pagination">
				<c:forEach var="index" begin="0" end="${ acc.totalPages - 1 }">
					<li class="page-item"><a class="page-link"
						href="/assignment/admin/account/index?page=${ index }">${ index + 1 }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<script src="/assignment/js/jquery.min.js"></script>
	<script src="/assignment/js/popper.min.js"></script>
	<script src="/assignment/js/bootstrap.min.js"></script>
</body>
</html>