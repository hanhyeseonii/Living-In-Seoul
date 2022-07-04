/*간편로그인시 비밀번호변경 버튼 숨기기*/
$(function(){
		const simplejoin = $('#simplejoin').val();
		
		if(simplejoin==0){ //일반회원
			$('#btnmdpw').show();
		}else{ //네이버간편가입회원
			$('#btnmdpw').hide();
			
		}
		
	});