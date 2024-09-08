<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="pageTitle" value="LIST"></c:set>
<%@ include file="../common/head.jspf"%>

	<div style="margin-right: auto; margin-bottom: 10px; font-size: 1.2rem;">전체 게시글 수 : ${totalCount }개</div>

	<table class="table border-collapse w-full border-2" style="border-color: #36BA98;">
		<thead>
			<tr>
				<th style="text-align: center;">ID</th>
				<th style="text-align: center;">Registration Date</th>
				<th style="text-align: center;">Title</th>
				<th style="text-align: center;">Modify</th>
				<th style="text-align: center;">Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!noneArticle }">
			<c:forEach var="article" items="${articles}">
				<tr>
					<td style="text-align: center;">${article.id}</td>
					<td style="text-align: center;">${article.regDate.substring(0,10)}</td>
					<td style="text-align: center;"><a href="getArticle?id=${article.id}">${article.title}</a></td>
					<td style="text-align: center"><a href="doModify?id=${article.id}">수정</a></td>
					<td style="text-align: center"><a href="doDelete?id=${article.id}">삭제</a></td>
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${noneArticle }">
				<tr style="text-align: center;">
					<td colspan='5' style="text-align: center;">아직 아무런 게시글이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<c:if test="${!noneArticle }">
		<div class = "page" style = "font-size: 1.2rem; margin-top: 10px;">
			<c:forEach var="i" begin="${startNum }" end="${endNum }">
					<a href="getArticles?page=${i }&boardId=${boardId}" <c:if test="${i == pageNum }">class = "cPage"</c:if>>
						<c:if test="${i < 10}">0</c:if>${i }
					</a>
			</c:forEach>
		</div>
	</c:if>

	<!-- 게시글 작성 버튼 -->
	<div><button onclick="location.replace('doWrite');">게시글 작성</button></div>
	
	<!-- CSS -->
	
	<style type="text/css">
	td, th {
		font-family: 'Pretendard-Regular';
		border: 2px solid #36BA98;
		color: black;
		padding: 5px;
	}
	
	button {
		font-size: 1.2rem;
		background-color: #36BA98;
		color: white;
		margin-top: 20px;
		padding: 10px;
		border-radius: 10px;
	}
	
	.cPage {
		color: #36BA98;
	}
	</style>
	
<%@ include file="../common/foot.jspf"%>