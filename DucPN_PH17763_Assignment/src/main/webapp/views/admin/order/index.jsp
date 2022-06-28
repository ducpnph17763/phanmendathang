<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${donhang.content}" var="order">
		<div class="col-lg-12">
			<div class="p-5">
				<div class="card card-default">
					<div class="card-header">
						<div>Người đặt: ${order.account.fullname}</div>
						<div>Ngày đặt: ${order.createDate}</div>
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Tên</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Tổng giá</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${order.orderDetails}" var="sp">
									<tr>
										<td>${sp.product.name}</td>
										<td>${sp.price}</td>
										<td>${sp.quantity}</td>
										<td>${sp.price * sp.quantity}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="card-footer">
						<div class="row">
							<div class="col-lg-3">Thành tiền :</div>
							<div class="offset-10 col-lg-9">
								<a class="btn btn-primary"
									href="giohang/xacnhan/${order.id}">Xác nhận</a> <a
									class="btn btn-danger">Hủy Đơn</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>