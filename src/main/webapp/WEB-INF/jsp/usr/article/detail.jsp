<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="${article.id }번 게시글 상세"></c:set>
<%@ include file="../common/head.jspf"%>
<%@ include file="../common/toastUiEditorLib.jspf"%>
	
	<div class="details">
		<div>번호 : ${article.id }</div>
		<div>날짜 : ${article.regDate.substring(0,10) }</div>
		<div>제목 : ${article.title }</div>
		<div>▼ 내용 ▼</div>
		<div class="toast-ui-viewer" style="background-color:white; border-radius: 10px; padding: 10px; border: 2px solid #36BA98">
			<script type="text/x-template">${article.body}</script>
		</div>
	</div>
	
	<br />
	
	<ul class="can-access-menu flex items-center flex-row mx-auto" style="font-size: 1.2rem;">
		<li><a href="javascript:void(0);" onclick="if(confirm('수정하시겠습니까?')) window.location.href='doModify?id=${article.id}';">수정</a></li>
		<li><a href="javascript:void(0);" onclick="if(confirm('삭제하시겠습니까?')) window.location.href='doDelete?id=${article.id}';">삭제</a></li>
	</ul>
	
	<br />
	
	<div><a href="getArticles">▶ 리스트로 돌아가기</a></div>
	<div><a href="#" onclick="location.href = document.referrer;">▶ 뒤로가기</a></div>
	
<%@ include file="../common/foot.jspf"%>

	<!-- CSS -->
	
	<style type="text/css">
	
	.can-access-menu > li {
		display:inline-block;
		margin: 0 10px;
		background-color: #36BA98;
		color: white;
		border-radius: 10px;
	}
	
	.can-access-menu > li > a {
		display: block;
		padding: 5px 10px;
	}
	
	.details {
		font-size: 1.5rem;
		color: #36BA98;
	}
	
	tr.modifing {
		color: #FF4E88;
		text-decoration: underline;
	}
	
	</style>