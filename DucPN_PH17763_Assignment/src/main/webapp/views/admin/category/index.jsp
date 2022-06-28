<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16309 - QL category</title>
<link rel="stylesheet" href="/assignment/css/bootstrap.min.css" />
</head>
<body>
	<div class="table-responsive col-10 offset-1">
		<a class="btn btn-success" href="/assignment/admin/category/create">
			Create </a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th colspan="2" class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ cate.content }" var="cate">
					<tr>
						<td>${ cate.id }</td>
						<td>${ cate.name }</td>
						<td class="text-center"><a class="btn btn-primary"
							href="/assignment/admin/category/edit/${ cate.id }"> Update </a></td>
						<td class="text-center"><a class="btn btn-danger"
							href="/assignment/admin/category/delete/${ cate.id }"> Delete
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row m-0">
			<ul class="pagination">
				<c:forEach var="index" begin="0" end="${ cate.totalPages - 1 }">
					<li class="page-item"><a class="page-link"
						href="/assignment/admin/category/index?page=${ index }">${ index + 1 }</a>
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