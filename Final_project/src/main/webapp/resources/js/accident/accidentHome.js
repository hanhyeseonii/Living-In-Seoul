window.addEventListener('load',()=>{
	$.ajax({
		url : `/myapp/accident/wizet`,
		method : 'GET',
		success : function(data){
			var info = Object.values(data);
			console.log("확인:" + data);
			$('.accident-text').html(info);
		
		}//success func 종료
	}) //ajax 종료
})