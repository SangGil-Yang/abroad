<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/header.jsp" %>
</head>
<body>
	<table class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<caption>게시글 상세</caption>
		<tbody>
			<tr>
				<th scope="row">글 번호</th>
				<td>${boardlist.id }</td>
				<th scope="row">조회수</th>
				<td>${boardlist.count }</td>
			</tr>
			 <tr>
<!--                 <th scope="row">작성자</th> -->
<%--                 <td>${boardlist.CREA_ID }</td> --%>
                <th scope="row">작성시간</th>
                <td>${boardlist.board_create_date }</td>
            </tr>
            <tr>
                <th scope="row">제목</th>
                <td colspan="3">${boardlist.title }</td>
            </tr>
            <tr>
                <td colspan="4">${boardlist.content }</td>
            </tr>
            <tr>
            	<th scope="row">첨부파일</th>
            	<td colspan="3">
            		<c:forEach var="row" items="${filelist }">
            			<input type="hidden" id="id" value="${row.id}">
            			<a href="#this" name="file">${row.origin_file }</a>
            			(${row.file_size }kb)
            		</c:forEach>
            	</td>
            </tr>
		</tbody>
	</table>
	
	<a href="#this" class="btn" id="list">목록으로</a>
	<a href="#this" class="btn" id="update">수정하기</a>
	
	<%@ include file="/WEB-INF/include/body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
            $("#list").on("click", function(e){ //목록으로 버튼
                e.preventDefault();
                fn_boardList();
            });
             
            $("#update").on("click", function(e){  //수정으로 버튼
                e.preventDefault();
                fn_openboardUpdate();
            });
            
            $("a[name='file']").on("click", function(e){  // 파일 이름
            	e.preventDefault();
            	fn_downloadFile($(this));
            });
        });
         
        function fn_boardList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/boards/boardList.do' />");
            comSubmit.submit();
        }
         
        function fn_openboardUpdate(){
            var idx = "${boardlist.id}";
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/boards/openboardUpdate.do' />");
            comSubmit.addParam("id", idx);
            comSubmit.submit();
        }
        
        function fn_downloadFile(obj){
        	var idx = obj.parent().find("#id").val();
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/boards/downloadFile.do' />");
            comSubmit.addParam("id", idx);
            comSubmit.submit();
        }
        
        
    </script>
</body>
</html>