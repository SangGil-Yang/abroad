<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/header.jsp" %>
</head>
<body>
    <form id="frm" name="frm" encType="multipart/form-data">
        <table class="board_view">
            <colgroup>
                <col width="15%">
                <col width="*"/>
            </colgroup>
            <caption>게시글 작성</caption>
            <tbody>
                <tr>
                    <th scope="row">제목</th>
                    <td><input type="text" id="title" name="title" class="wdp_90"></input></td>
                </tr>
                <tr>
                    <td colspan="2" class="view_text">
                        <textarea rows="20" cols="100" title="내용" id="content" name="content"></textarea>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="file" name="file">
        <br/><br/>
         
        <a href="#this" class="btn" id="write" >작성하기</a>
        <a href="#this" class="btn" id="list" >목록으로</a>
    </form>
     
    <%@ include file="/WEB-INF/include/body.jsp" %> 
    <script type="text/javascript">
        $(document).ready(function(){
        	$("#list").on("click", function(e){  // 목록으로
        		e.preventDefault();
        		fn_boardList();
        	});
        	
        	$("#write").on("click", function(e){  // 작성하기
        		e.preventDefault();
        		fn_insertBoard();
        	});
                     
        });
        
        function fn_boardList(){
        	var comSubmit = new ComSubmit();
        	comSubmit.setUrl("<c:url value='/boards/boardList.do'/>");
        	comSubmit.submit();
        }
        
        function fn_insertBoard(){
        	var comSubmit = new ComSubmit("frm");
        	comSubmit.setUrl("<c:url value='/boards/insertBoard.do'/>");
        	comSubmit.submit();
        }
        
    </script>
</body>
</html>