/*헤더*/

//document가 준비되었을때
$(function(){
		//로그인, 로그아웃, 회원가입 제어
		const sessionEmail = $('#sessionEmail').text();
		if(sessionEmail==''){ //로그인 전
			$('#aLogin').show(); 
			$('#aLogout').hide();
			$('#asign_up').show();
		}else{ //로그인 후
			$('#aLogin').hide(); 
			$('#aLogout').show();
			$('#asign_up').hide();
			
		}
	
	
		//로그아웃 버튼을 클릭했을 때
		$('#aLogout').click((e)=>{
			e.preventDefault();
			if(confirm('로그아웃하시겠습니까?')){
				const path = $('#contextpath').val();
				location.href=`${path}/member/logout`;
			}
		});
		
		
	});