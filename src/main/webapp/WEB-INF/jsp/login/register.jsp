<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/header.jsp" %>
	<link rel="stylesheet" media="screen" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<body>
    <form class="form-horizontal" id="frm" name="frm">
 		<div class="control-group">
    		<label class="control-label" for="name">이 름</label>
    		<div class="controls">
      			<input type="text" id="name" name="name" placeholder="이름">
    		</div>
  		</div>
  		<div class="control-group">
    		<label class="control-label" for="id">아이디</label>
    		<div class="controls">
      			<input type="text" id="id" name="id" placeholder="아이디">
      			<a href="#this" class="btn" id="idCheck">중복확인</a>
    		</div>
  		</div>
  		<div class="control-group">
    		<label class="control-label" for="pwd">비밀번호</label>
    		<div class="controls">
      			<input type="text" id="pwd" name="pwd" placeholder="비밀번호">
    		</div>
  		</div>
  		  		<div class="control-group">
    		<label class="control-label" for="hp">핸드폰</label>
    		<div class="controls">
      			<input type="text" id="hp" name="hp" placeholder="핸드폰">
    		</div>
  		</div>
  		<br/><br/>
		<div class="control-group">
    		<div class="controls">
    			<a href="#this" class="btn" id="register">확인</a>
      			<a href="#this" class="btn" id="cancel" >취소</a>
    		</div>
  		</div> 		
	</form>
	<%@ include file="/WEB-INF/include/body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#register").on("click", function(e){  // 확인
				e.preventDefault();
				fn_formCheck();
				//fn_loginRegister();
			});
			
            $("#cancel").on("click", function(e){ // 취소 
                e.preventDefault();
                fn_loginCancel();
            });	
            
//             $("#idCheck").on("click", function(e){ // 취소 
//                 e.preventDefault();
//                 fn_loginCancel();
//             });	
		});
		
		function fn_loginRegister(){
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/login/insertLogin.do' />");
			comSubmit.submit();
		}
		
		function fn_loginCancel(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boards/boardDetail.do' />");
			comSubmit.submit();
		}
		
		function fn_formCheck(){
			
 			var name = $("#name");
			var id = $("#id");
			var pwd = $("#pwd");
		
			if(name.val() == '' || name.val() == null)
			{
				alert('이름을 입력하세요');
				name.focus();	
			}
			
			else if(id.val() == '' || id.val() == null)
			{
				alert('ID를 입력하세요');
				id.focus();	
			}
			
			else if(pwd.val() == '' || pwd.val() == null)
			{
				alert('비밀번호를 입력하세요');
				pwd.focus();	
			}
			
			else
			{
				alert('가입이 완료 되었습니다.');
			}
		}
	</script>
</body>
</html>