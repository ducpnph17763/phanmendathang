<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<article class="col-lg-9">
	<div class="row">
		<h1 class="col-lg-12">${title}</h1>
		<c:forEach items="${dsPro.content}" var="pro">
			<div class="col-lg-4">
				<div class="card card-default text-center mb-3 ">
					<div class="card-header">${pro.name}</div>
					<div class="card-body">
						<img src="/assignment/photo/${pro.image}" class="img-fluid">
					</div>
					<div class="card-footer text-center">
						<div>Giá: ${pro.price}đ</div>
						<a class="btn btn-primary"
							href="trangchu/giohang/create/${pro.id}">Them vao gio</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</article>