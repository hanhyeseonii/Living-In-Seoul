/*save버튼을 클릭했을 때*/
function modifyCheck(e){
	e.preventDefault();
	const email = document.getElementById('email');
	const name = document.getElementById('name');
	const birthdate = document.getElementById('birthdate');
	const address = document.getElementById('address');
	
	if(!email.value){
		alert('이메일을 입력해주세요.');
		email.focus();
		return;
	}
	if(!name.value){
		alert('이름을 입력해주세요.');
		name.focus();
		return;
	}
	if(!birthdate.value){
		alert('생년월일을 입력해주세요.');
		birthdate.focus();
		return;
	}
	if(!address.value){
		alert('주소를 입력해주세요.');
		address.focus();
		return;
	}
	document.getElementById('frmInfomodi').submit();
}