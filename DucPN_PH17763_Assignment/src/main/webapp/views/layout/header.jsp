<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<div class="col-lg-12">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/assignment/trangchu">Online
			Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${sessionScope.acc.admin==0}">
						<li class="nav-item active"><a class="nav-link"
							href="/assignment/giohang">Giỏ hàng</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="/assignment/lichsu">Lịch sử mua hàng</a></li>
					</c:when>
					<c:when test="${sessionScope.acc.admin==1}">
						<li class="nav-item active"><a class="nav-link"
							href="/assignment/admin/quanlygiohang">Quan ly don hàng</a></li>
					</c:when>
				</c:choose>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<c:choose>
							<c:when test="${sessionScope.acc != null}">${sessionScope.acc.username}</c:when>
							<c:when test="${sessionScope.acc == null}">Tài khoản</c:when>
						</c:choose>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<c:if test="${sessionScope.acc==null}">
							<a class="dropdown-item" href="/assignment/login">Đăng nhập</a>
							<a class="dropdown-item" href="/assignment/register">Đăng kí</a>
							<a class="dropdown-item" href="/assignment/forget">Quên mật
								khẩu</a>
						</c:if>
						<c:if test="${sessionScope.acc.admin == 1}">
							<a class="dropdown-item" href=/assignment/admin/account/index>Quản
								trị người dùng</a>
							<a class="dropdown-item" href="/assignment/admin/category/index">Quản
								trị danh mục</a>
							<a class="dropdown-item" href="/assignment/admin/product/index">Quản
								trị sản phẩm</a>
							<hr>
						</c:if>
						<c:if test="${sessionScope.acc != null}">
							<a class="dropdown-item" href="/assignment/capnhat">Cập nhật
								Tài khoản</a>
							<a class="dropdown-item" href="/assignment/doimk">Đổi mật
								khẩu</a>
							<a class="dropdown-item" href="/assignment/logout">Đăng xuất</a>
						</c:if>

					</div></li>
			</ul>
		</div>
	</nav>
</div>