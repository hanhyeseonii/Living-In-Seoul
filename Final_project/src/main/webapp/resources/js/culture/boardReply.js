/**
 * 게시물 댓글
 */

 //윈도우가 로딩이 완료된 후
window.addEventListener('load', ()=>{
	//핸들바에서 사용 : 헬퍼만들기
	Handlebars.registerHelper('levelSpace', function(relevel){
		let result = '';
		for(var i=0; i<relevel; i++)
			result += '<div class ="divSpace"></div>';
		return result;
	});

	//댓글창 초기화
	const replyInit = ()=>{
		//입력된 내용 지우기
		document.getElementById('replyemail').value='';
		document.getElementById('replycontent').value='';
		
		//댓글추가 div 이동
		const hr = document.getElementById(`hr`);
		const divReplyAdd = document.getElementById('divReplyAdd');
		hr.after(divReplyAdd);
		//댓글추가 창 숨기기
		divReplyAdd.style.display = 'none';
		
		//댓글수정 div 이동
		const divReplyModify = document.getElementById('divReplyModify');
		hr.after(divReplyModify);
		//댓글수정 창 숨기기
		divReplyModify.style.display = 'none';
		
		
	};
	//댓글의 리스트 
	const replyList = ()=> {
		
		replyInit();//댓글창 초기화
		
		const bnum = document.getElementById('bnum').innerText;
		//console.log(bnum);
		//ajax 서버 호출(get)
		fetch(`/myapp/reply/list/${bnum}`)
		.then(res=>res.json())
		.then(data=>{
			//console.log(data);
			/*탬플리소스가져오기*/
			const source = document.getElementById('template_source').innerHTML;
			//console.log(source);
			//소스컴파일
			const template = Handlebars.compile(source);
			//컴파일된 데이터를 div넣기 
			document.getElementById('divReplyList').innerHTML= template(data);
			
		})
		.catch(console.err);
	};
	
	replyList(); //댓글의 리스트 출력 함수 호출
	
	//게시물의 댓글 버튼을 클릭했을때
	document.getElementById('replyAddShow').addEventListener('click',()=>{
		//부모의 restep,relevel
		document.getElementById('restep').value = 0;
		document.getElementById('relevel').value = 0;
		
		//댓글추가 div 이동
		const hr = document.getElementById(`hr`);
		const divReplyAdd = document.getElementById('divReplyAdd');
		hr.after(divReplyAdd);
		
		//댓글추가 div 보이기
		divReplyAdd.style.display = '';
		
	});
	
	//댓글추가창에서 취소버튼을 클릭했을때
	document.getElementById('replyCancel').addEventListener('click', ()=>{
		//댓글추가 창 숨기기
		document.getElementById('divReplyAdd').style.display = 'none';	
	});
	
	
	//부모를 선택
	document.getElementById('divReplyList').addEventListener('click', (e)=>{
		//댓글리스트의 댓글버튼을 클릭했을때
		if (e.target.classList.contains('reReplyAddShow')){
			//rnum,restep,relevel 가져오기
			const rnum = e.target.value;
			//console.log(rnum); 
			const restep = document.getElementById(`restep${rnum}`).innerText;
			//console.log(restep); 
			const relevel = document.getElementById(`relevel${rnum}`).innerText;
			//console.log(relevel); 
			//부모의 restep, relevel
			document.getElementById('restep').value = restep;
			document.getElementById('relevel').value = relevel;
			
			//댓글추가 div 이동
			const reply = document.getElementById(`reply${rnum}`);
			const divReplyAdd = document.getElementById('divReplyAdd');
			reply.after(divReplyAdd);
			
			//댓글추가 div 보이기
			divReplyAdd.style.display = '';
		}else if (e.target.classList.contains('reReplyRemove')){
			//댓글리스트의 삭제 버튼을 클릭했을때
			if (!confirm('삭제하시겠습니까?')) return ;
			
			const rnum = e.target.value;
			console.log(rnum);
			
			//ajax 서버 호출
			fetch(`/myapp/reply/${rnum}`,{
				method : 'delete',
			})
			.then(res=>res.text())
			.then(text=>{
				alert(text);
				replyList(); //댓글 리스트 호출
			})
			.catch(err=>console.log(err));
		}else if (e.target.classList.contains('reReplyModify')){	
			//댓글리스트의 수정 버튼을 클릭했을때
			const rnum = e.target.value;
			console.log(rnum);
			//댓글수정 div 이동
			const reply = document.getElementById(`reply${rnum}`);
			const divReplyModify = document.getElementById('divReplyModify');
			reply.after(divReplyModify);
			//댓글수정 창 보이기
			divReplyModify.style.display = '';
		
			//기존 rnum, content 세팅
			document.getElementById(`replyrnumModify`).value = rnum;
			const content = document.getElementById(`content${rnum}`).innerText;
			document.getElementById(`replycontentModify`).innerHTML = content;
		}
			
	});
	
	
	//추가댓글의 추가버튼 클릭시
	document.getElementById('replyAdd').addEventListener('click',()=>{
		//추가할 내용 읽어오기
		const bnum = document.getElementById('bnum').innerText;
		const email = document.getElementById('replyemail').innerText;
		const content = document.getElementById('replycontent').value;
		const restep = document.getElementById('restep').value; // 댓글의 순서
		const relevel = document.getElementById('relevel').value; // 댓글의 레벨
		
		console.log(bnum);
		console.log(email);
		console.log(content);
		console.log(restep);
		console.log(relevel);
		
		//전송할 데이터
		const data ={
			bnum,
			email,
			content,
			restep,
			relevel,
		};
		
		//서버 호출
		fetch('/myapp/reply/',{
			method : 'post',
			headers : {
				'Content-Type' : 'application/json', //json문자열 전송
			},
			body : JSON.stringify(data),//object->json문자열로 변경
		})
		.then(res=>res.text())
		.then(text=>{
			console.log(text);
			replyList(); //댓글의 리스트 호출
		})
		.catch(console.err);
	});
	
	//댓글수정의 저장버튼을 클릭했을때
	document.getElementById('replyModify').addEventListener('click',()=>{
		//rnum, content
		const rnum = document.getElementById('replyrnumModify').value;
		const content = document.getElementById('replycontentModify').value;
		console.log(rnum);
		console.log(content);
		const data = {
			rnum,
			content,
		};
		
		fetch('/myapp/reply/',{
			method : 'put',
			headers : {
				'Content-Type' : 'application/json', //json문자열 전송
			},			
			body: JSON.stringify(data), //json문자열 변환
		})
		.then(res=>res.text())
		.then(text=>{
			console.log(text);
			replyList(); //댓글의 리스트 호출
			
		})
		.catch(console.err);
		
	});
	
	
	//댓글수정창에서 취소버튼을 클릭했을때
	document.getElementById('replyModifyCancel').addEventListener('click', ()=>{
		//댓글수정 창 숨기기
		document.getElementById('divReplyModify').style.display = 'none';	
	});
	
	
	
	
});