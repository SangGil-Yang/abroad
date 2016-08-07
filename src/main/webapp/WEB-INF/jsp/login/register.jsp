<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/header.jsp" %>
	<link rel="stylesheet" media="screen" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
</head>
<body>
    <form class="form-horizontal" id="frm" name="frm">
 		<div class="control-group">
    		<label class="control-label" for="name">�� ��</label>
    		<div class="controls">
      			<input type="text" id="name" name="name" placeholder="�̸�">
    		</div>
  		</div>
  		<div class="control-group">
    		<label class="control-label" for="id">���̵�</label>
    		<div class="controls">
      			<input type="text" id="id" name="id" placeholder="���̵�">
      			<a href="#this" class="btn" id="idCheck">�ߺ�Ȯ��</a>
    		</div>
  		</div>
  		<div class="control-group">
    		<label class="control-label" for="pwd">��й�ȣ</label>
    		<div class="controls">
      			<input type="text" id="pwd" name="pwd" placeholder="��й�ȣ">
    		</div>
  		</div>
  		  		<div class="control-group">
    		<label class="control-label" for="hp">�ڵ���</label>
    		<div class="controls">
      			<input type="text" id="hp" name="hp" placeholder="�ڵ���">
    		</div>
  		</div>
  		<br/><br/>
		<div class="control-group">
    		<div class="controls">
    			<a href="#this" class="btn" id="register">Ȯ��</a>
      			<a href="#this" class="btn" id="cancel" >���</a>
    		</div>
  		</div> 		
	</form>
	<%@ include file="/WEB-INF/include/body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#register").on("click", function(e){  // Ȯ��
				e.preventDefault();
				fn_formCheck();
				//fn_loginRegister();
			});
			
            $("#cancel").on("click", function(e){ // ��� 
                e.preventDefault();
                fn_loginCancel();
            });	
            
//             $("#idCheck").on("click", function(e){ // ��� 
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
				alert('�̸��� �Է��ϼ���');
				name.focus();	
			}
			
			else if(id.val() == '' || id.val() == null)
			{
				alert('ID�� �Է��ϼ���');
				id.focus();	
			}
			
			else if(pwd.val() == '' || pwd.val() == null)
			{
				alert('��й�ȣ�� �Է��ϼ���');
				pwd.focus();	
			}
			
			else
			{
				alert('������ �Ϸ� �Ǿ����ϴ�.');
			}
		}
	</script>
</body>
</html>