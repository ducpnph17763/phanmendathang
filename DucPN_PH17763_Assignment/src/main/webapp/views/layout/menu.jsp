<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<aside class="col-lg-3">
	<div class="contaner">
		<div class="card card-default">
			<div class="card-header">Danh mục sản phẩm</div>
			<ul class="list-group">
				<c:forEach items="${dsCate.content}" var="dm">
					<li class="list-group-item"><a
						href="/assignment/trangchu/${dm.id}">${dm.name}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</aside>