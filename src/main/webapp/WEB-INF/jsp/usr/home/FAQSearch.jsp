<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="FAQ Search"></c:set>
<%@ include file="../common/head.jspf"%>

	<!-- 질문입력 -->
	<div class="search mx-auto" style="margin-top: 30px;">
		<div style="text-align: left">▶ FAQ 키워드를 입력하세요</div>
		<form onsubmit="faqForm__submit(this); return false;" style="font-size: 1.4rem;" action="getFAQs" class="flex justify-center items-center">
		<div>
			<input class="input input-bordered input-sm" type="text" autocomplete="off" name="FAQKeyword" style="margin: 0 10px"/>
		</div>
		<div>
			<input style="cursor: pointer; background-color:#36BA98; color: white; padding: 2px 10px; border-radius: 10px; font-size:1.2rem;" type="submit" value="검색">
		</div>
		
		</form>
	</div>
	

	<!-- JS -->
	<script type="text/javascript">
	
		function faqForm__submit(form) {
			console.log("form.FAQKeyword.value : " + form.searchKeyword.value);
			
			let FAQKeyword = form.FAQKeyword.value.trim();

			if(FAQKeyword.length == 0) {
				alert('FAQ 키워드를 입력하세요.');
				return;
			}
			
			//다 확인했으면 그냥 여기서 submit
			form.submit();
		}
	</script>

<%@ include file="../common/foot.jspf"%>