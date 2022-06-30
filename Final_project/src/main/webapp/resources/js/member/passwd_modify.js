/*비밀번호 일치 확인*/

/*일치확인 버튼을 클릭했을 때*/


function savePasswdmd(e){
	e.preventDefault();
	
	const passwd = document.getElementById('passwd');
	const againpasswd = document.getElementById('againpasswd');
	
	if (passwd.value != againpasswd.value){
		alert('비밀번호가 일치하지 않습니다.');
		$('#savebtn').hide();
		againpasswd.focus();
	}else{
		alert('비밀번호가 일치합니다.');
		$('#savebtn').show();
	}


}
	
	
$(()=>{
	$('#savebtn').hide();
});

