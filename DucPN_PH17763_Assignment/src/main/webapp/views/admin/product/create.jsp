<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="col-lg-10 offset-1">
	<form:form method="POST" action="/assignment/admin/product/store"
		modelAttribute="product" enctype="multipart/form-data">
		<div>
			<label>Name</label>
			<form:input path="name" />
		</div>
		<div>
			<label>Gia</label>
			<form:input path="price" />
		</div>
		<div>
			<label>Anh</label> <input type="file" name="photo">
		</div>
		<div>
			<label>Available</label>
			<form:select path="available">
				<form:option value="0">Không</form:option>
				<form:option value="1">Có</form:option>
			</form:select>
		</div>
		<div>
			<label>Category</label>
			<form:select path="category_id">
				<c:forEach items="${cate }" var="cate">
					<form:option value="${ cate.id}">${cate.name }</form:option>
				</c:forEach>
			</form:select>
		</div>
		<button>Save</button>
	</form:form>
</div>