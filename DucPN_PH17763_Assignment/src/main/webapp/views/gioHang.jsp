<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assignment/css/bootstrap.min.css" />
</head>
<body>
	<c:if test="${od==null}">
		<h1>Gio hang trong</h1>
	</c:if>
	<c:if test="${od!=null}">
		<div class="p-5">
			<h1>Giỏ Hàng</h1>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Tên</th>
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Tổng giá</th>
						<th colspan="2">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${odd}" var="sp">
						<tr>
							<td>${sp.product.name}</td>
							<td>${sp.price}</td>
							<td>${sp.quantity}</td>
							<td>${sp.price * sp.quantity}</td>
							<td><a class="btn btn-danger"
								href="/assignment/giohang/xoa/${sp.id}">Xóa</a></td>
							<td><a class="btn btn-primary"
								href="/assignment/giohang/edit/${sp.id}">Sua</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn btn-primary" href="/assignment/giohang/mua">Mua
				hang</a>
		</div>
		<div class="p-5">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Tên</th>
						<th>Giá</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pro}" var="sp">
						<tr>
							<td>${sp.name}</td>
							<td>${sp.price}</td>
							<td><a class="btn btn-primary"
								href="trangchu/giohang/create/${sp.id}">Them vao gio</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>

	<script src="/assignment/js/jquery.min.js"></script>
	<script src="/assignment/js/popper.min.js"></script>
	<script src="/assignment/js/bootstrap.min.js"></script>
</body>
</html>