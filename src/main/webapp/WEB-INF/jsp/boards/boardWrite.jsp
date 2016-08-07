<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/header.jsp" %>
	<link rel="stylesheet" media="screen" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
</head>
<body>
    <form class="form-horizontal" id="frm" name="frm" encType="multipart/form-data">
 		<div class="control-group">
    		<label class="control-label" for="title">제 목</label>
    		<div class="controls">
      			<input type="text" id="title" name="title" placeholder="Title">
    		</div>
  		</div>
  		<div class="control-group">
    		<label class="control-label" for="content">내 용</label>
    		<div class="controls">
      			<textarea rows="10" id="content" name="content" placeholder="Content"></textarea>
    		</div>
  		</div>
  		<div class="control-group" id="fileDiv">
  			<label class="control-label" for="file">첨부 파일</label>
    		<div class="controls">
      			<input type="file" id="file" name="file_0">
      			<a href="#this" class="btn" id="delete" name="delete">삭제</a>
    		</div>
  		</div>
  		<br/><br/>
		<div class="control-group">
    		<div class="controls">
    			<a href="#this" class="btn" id="addFile">파일 추가</a>
      			<a href="#this" class="btn" id="write" >작성하기</a>
        		<a href="#this" class="btn" id="list" >목록으로</a>
    		</div>
  		</div>
  		
	</form>
    <%@ include file="/WEB-INF/include/body.jsp" %> 
    <script type="text/javascript">
    	var gfv_count = 1;
    
        $(document).ready(function(){
        	$("#list").on("click", function(e){  // 목록으로
        		e.preventDefault();
        		fn_boardList();
        	});
        	
        	$("#write").on("click", function(e){  // 작성하기
        		e.preventDefault();
        		fn_insertBoard();
        	});
        	
            $("#addFile").on("click", function(e){ //파일 추가
                e.preventDefault();
                fn_addFile();
            });
            
            $("a[name='delete']").on("click", function(e){ //삭제 버튼
                e.preventDefault();
                fn_deleteFile($(this));
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
        
        function fn_addFile(){
            var str = "<div class='controls'><input type='file' name='file_"+(gfv_count++)+"'> <a href='#this' class='btn' name='delete'>삭제</a></div>";
            $("#fileDiv").append(str);
            $("a[name='delete']").on("click", function(e){ //삭제 버튼
                e.preventDefault();
                fn_deleteFile($(this));
            });
        }
        
        function fn_deleteFile(obj){
            obj.parent().remove();
        }
        
    </script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>