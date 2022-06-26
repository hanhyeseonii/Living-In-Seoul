$(function(){
	//로그인 버튼을 클릭했을때 
	$('#btnLogin').click(e=>{
		e.preventDefault();
		const email = $('#email');
		const passwd = $('#passwd');
		if (!email.val()){
			email.focus();
			alert('이메일을 입력해 주세요!');
			return ;
		}
		
		if (!passwd.val()){
			passwd.focus();
			alert('비밀번호를 입력해 주세요!');
			return ;
		}
		
		$('#frmLogin').submit();
	});
	
});