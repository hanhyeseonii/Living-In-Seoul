window.addEventListener('load',()=>{
	$.ajax({
		url : `/myapp/culture/board/hotBoard`,
		method : 'GET',
		success : function(data){
			var first = Object.values(data[0])[2];
			var second = Object.values(data[1])[2];
			var third = Object.values(data[2])[2];
			
			var firstNum = Object.values(data[0])[0];
			var secondNum = Object.values(data[1])[0];
			var thirdNum = Object.values(data[2])[0];
			
			$('.hot-first').attr('href','/myapp/culture/board/detail?bnum=' + firstNum)
				.html(first);
			$('.hot-second').attr('href','/myapp/culture/board/detail?bnum=' + secondNum)
				.html(second);
			$('.hot-third').attr('href','/myapp/culture/board/detail?bnum=' + thirdNum)
				.html(third);
		}//success func 종료
	}) //ajax 종료
})

window.addEventListener('load',()=>{
	$.ajax({
		url : `/myapp/culture/board/newBoard`,
		method : 'GET',
		success : function(data){
			var first = Object.values(data[0])[2];
			var second = Object.values(data[1])[2];
			var third = Object.values(data[2])[2];
						
			var firstNum = Object.values(data[0])[0];
			var secondNum = Object.values(data[1])[0];
			var thirdNum = Object.values(data[2])[0];
			
			$('.new-first').attr('href','/myapp/culture/board/detail?bnum=' + firstNum)
				.html(first);
			$('.new-second').attr('href','/myapp/culture/board/detail?bnum=' + secondNum)
				.html(second);
			$('.new-third').attr('href','/myapp/culture/board/detail?bnum=' + thirdNum)
				.html(third);
		}//success func 종료
	}) //ajax 종료
})

