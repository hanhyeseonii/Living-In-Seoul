/**
 * view에서 파일 추가 버튼 클릭시 
 */
 
 //파일 추가 버튼을 클릭했을때
 function fileAdd(e){
	e.preventDefault(); //기본이벤트 제거
	//input엘리먼트 생성
	var input = document.createElement('input');
	input.type = 'file';
	input.name = 'files';
	//br엘리먼트 생성
	var br = document.createElement('br');
	//button엘리먼트 생성
	var removeButton = document.createElement('button');
	var text = document.createTextNode('-');
	removeButton.type = 'button';
	removeButton.appendChild(text);
	
	
	//divFiles에 추가하기
	var divFiles = document.getElementById('divFiles');
	var div = document.createElement('div');
	
	div.appendChild(input);
	div.appendChild(removeButton);
	div.appendChild(br);
	
	divFiles.appendChild(div);
	
	//이벤트 달기1
/*	button.onclick= function(){
		console.log('이벤트달기');
	}
*/
	//이벤트달기2
	//삭제버튼 클릭시 부모div삭제
	removeButton.addEventListener('click', function(){
		this.parentNode.remove();
	});



	
	
}