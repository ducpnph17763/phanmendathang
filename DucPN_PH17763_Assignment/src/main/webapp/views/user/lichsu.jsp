<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Ngày mua</th>
				<th>Giá</th>
				<th>Trạng Thái</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ord" items="${lichsu}">
				<tr>
					<td>${ord.createDate}</td>
					<td>Giá</td>
					<c:choose>
						<c:when test="${ord.status==1}">Đang chờ xử lý</c:when>
						<c:when test="${ord.status==2}">Đã xác nhận</c:when>
					</c:choose>
					<td><a href="">Chi Tiết</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>