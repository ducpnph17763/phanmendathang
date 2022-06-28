<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
<link rel="stylesheet" href="/assignment/css/bootstrap.min.css" />
</head>
<body>
	<div class="contaner">
		<div class="row">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>

		<div class="row">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>


	<script src="/assignment/js/jquery.min.js"></script>
	<script src="/assignment/js/popper.min.js"></script>
	<script src="/assignment/js/bootstrap.min.js"></script>
</body>
</html>