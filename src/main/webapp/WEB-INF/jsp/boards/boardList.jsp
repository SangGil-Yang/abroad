<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" >

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
<title>first</title>
<%@ include file="/WEB-INF/include/header.jsp" %>
</head>
<body>
<h2>게시판 목록</h2>
	<table style="border:1px solid #ccc">
    	<colgroup>
        	<col width="10%"/>
        	<col width="*"/>
        	<col width="15%"/>
        	<col width="20%"/>
    	</colgroup>
    	<thead>
        	<tr>
            	<th scope="col">글번호</th>
            	<th scope="col">제목</th>
            	<th scope="col">내용</th>
            	<th scope="col">조회수</th>
            	<th scope="col">작성일</th>
        	</tr>
    	</thead>
    	<tbody>
        	<c:choose>
            	<c:when test="${fn:length(boardlist) > 0}">
                	<c:forEach items="${boardlist }" var="row">
                    	<tr>
                        	<td>${row.id }</td>
                        	<td class="title">
                        		<a href="#this" name="title">${row.title }</a>
                        		<input type="hidden" id="id" value="${row.id }">
                        	<td>${row.content }</td>
                        	<td>${row.count }</td>
                        	<td>${row.create_date }</td>
                    	</tr>
                	</c:forEach>
            	</c:when>
            	<c:otherwise>
                	<tr>
                    	<td colspan="4">조회된 결과가 없습니다.</td>
                	</tr>
            	</c:otherwise>
        	</c:choose>        
    	</tbody>
	</table>
	<br/>
	<a href="#this" class="btn" id="write">글쓰기</a>
	
	<%@ include file="/WEB-INF/include/body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#write").on("click", function(e){  //글쓰기
				e.preventDefault();
				fn_boardWrite();
			});
			
            $("a[name='title']").on("click", function(e){ //제목 
                e.preventDefault();
                fn_boardDetail($(this));
            });	
		});
		
		function fn_boardWrite(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boards/boardWrite.do' />");
			comSubmit.submit();
		}
		
		function fn_boardDetail(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boards/boardDetail.do' />");
			comSubmit.addParam("id", obj.parent().find("#id").val());
			comSubmit.submit();
		}
	</script>
</body>
</html>