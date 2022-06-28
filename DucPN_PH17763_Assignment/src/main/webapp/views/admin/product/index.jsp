<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - QL product</title>
<link rel="stylesheet" href="/assignment/css/bootstrap.min.css" />
</head>
<body>
	<div class="table-responsive col-10 offset-1">
		<a class="btn btn-success" href="/assignment/admin/product/create">
			Create </a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Gia</th>
					<th>Anh</th>
					<th>Available</th>
					<th>Ngày tạo</th>
					<th colspan="2" class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ pro.content }" var="pro">
					<tr>
						<td>${ pro.id }</td>
						<td>${ pro.name }</td>
						<td>${ pro.price }</td>
						<td>${ pro.image }</td>
						<td>${ pro.available }</td>
						<td>${ pro.createdDate }</td>
						<td class="text-center"><a class="btn btn-primary"
							href="/assignment/admin/product/edit/${ pro.id }"> Update </a></td>
						<td class="text-center"><a class="btn btn-danger"
							href="/assignment/admin/product/delete/${ pro.id }"> Delete </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row m-0">
			<ul class="pagination">
				<c:forEach var="index" begin="0" end="${ pro.totalPages - 1 }">
					<li class="page-item"><a class="page-link"
						href="/assignment/admin/product/index?page=${ index }">${ index + 1 }</a>
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