/*save버튼을 클릭했을 때*/
function modifyCheck(e){
	e.preventDefault();
	const birthdate = document.getElementById('birthdate');
	const address = document.getElementById('address');
	
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