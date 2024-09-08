<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alert</title>
</head>
<body>
	<c:if test="${noArticle}">
		<script>alert('유효하지 않은 게시글 번호입니다.'); history.back();</script>
	</c:if>
	<c:if test="${articleModified}">
		<script>alert('게시글 수정이 완료되었습니다.'); location.replace('getArticles');</script>
	</c:if>
	<c:if test="${articleDeleted}">
		<script>alert('게시글 삭제가 완료되었습니다.'); location.replace('getArticles');</script>
	</c:if>
	<c:if test="${writeSuccess}">
		<script>alert('게시글이 작성되었습니다.'); location.replace('getArticles');</script>
	</c:if>
</body>
</html>