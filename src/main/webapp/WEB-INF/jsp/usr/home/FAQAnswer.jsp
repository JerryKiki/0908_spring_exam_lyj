<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="pageTitle" value="FAQ Answer"></c:set>
<%@ include file="../common/head.jspf"%>

	<div style="margin-right: auto; margin-bottom: 10px; font-size: 1.2rem;">검색된 FAQ 수 : ${totalCount }개</div>

	<table class="table border-collapse w-full border-2" style="border-color: #36BA98;">
		<c:if test="${!noneAnswers }">
			<c:forEach var="faq" items="${faqs}">			
				<thead>
					<tr>
						<th style="text-align: center; font-size: 1.2rem;">Q. ${faq.question }</th>
					</tr>
				</thead>
				<tbody>					
					<tr>
						<td style="text-align: center; font-size: 1.2rem;">A. ${faq.answer }</td>
					</tr>
				</tbody>
			</c:forEach>
		</c:if>
		<c:if test="${noneAnswers }">
			<thead>
				<tr style="text-align: center;">
					<th style="text-align: center; font-size: 1.2rem;">관련된 FAQ가 없습니다.</th>
				</tr>
			</thead>
		</c:if>
	</table>
	
	<br>
	
	<div style="margin: 10px;"><a href="faqSearch">▶ 검색창으로 돌아가기</a></div>
	
<%@ include file="../common/foot.jspf"%>