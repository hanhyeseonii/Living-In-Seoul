/*중복확인*/
function duplCheck(e, path){
	e.preventDefault();
	const email = document.getElementById('email').value;
	console.log(email);
	if(!email){
		alert('이메일을 등록해주세요.');
		document.getElementById('email').focus();
		return;
	}
	
	/*ajax 비동기 방식*/
	fetch(`${path}/member/duplCheck/${email}`)
	.then(res=>res.json())
	.then(data=>{
		console.log(data.code);
		console.log(data.msg);
		alert(data.msg);
	})
	.catch(console.error);
}

/*비밀번호 일치 확인*/
/*일치확인 버튼을 클릭했을 때*/
function passwdCheck(e){
	e.preventDefault();
	
	const passwd = document.getElementById('passwd');
	const againpasswd = document.getElementById('againpasswd');
	
	if (passwd.value != againpasswd.value){
		alert('비밀번호가 일치하지 않습니다.');
		againpasswd.focus();
	}else
		alert('비밀번호가 일치합니다.');
		
}