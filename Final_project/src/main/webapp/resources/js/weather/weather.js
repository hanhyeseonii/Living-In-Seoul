function weather(region){
	$.ajax({
		url : `/myapp/weather/weatherDetail`,
		method : 'POST',
		data : {"id" : region},
		success : function(data){
			var tempNow = Object.values(data[0])[0];
			var windSpeed = Object.values(data[1])[0];
			var sky = Object.values(data[2])[0];
			var rainState = Object.values(data[3])[0];
			var rainChance = Object.values(data[4])[0];
			var rain = Object.values(data[5])[0];
			var humid = Object.values(data[6])[0];
								
			$('.weather-region').html(region);
			$('.weather-temp').html(tempNow + " ℃");
			$('.weather-rainChance').html("강수확률 : "+rainChance+"%");
			$('.weather-humid').html("습도 : "+humid + "%");
			$('.weather-windSpeed').html("풍속 : "+windSpeed+"m/s");
		
			if(rainState!='0') {
				switch(rainState) {
					case "1":
						$('.weather-state-text').html("☔비");
						$('#RN1').html("시간당강수량 : "+ rain);
						break;
					case "2":
						$('.weather-state-text').html("🌨비/눈");
						$('#RN1').html("시간당강수량 : "+ rain);
						break;
					case "3":
						$('.weather-state-text').html("☃눈");
						$('#RN1').html("시간당강수량 : "+ rain);
						break;
					case "4":
						$('.weather-state-text').html("☔소나기");
						$('#RN1').html("시간당강수량 : "+ rain);
						break;
				}
			}else {
				$('#RN1').html("강수없음");
				switch(sky) {
					case "1":
						$('.weather-state-text').html("☀맑음");
						break;
					case "2":
						$('.weather-state-text').html("🌤구름조금");
						break;
					case "3":
						$('.weather-state-text').html("⛅구름많음");
						break;
					case "4":
						$('.weather-state-text').html("☁흐림");    
						break;
           		}    
       		}					
		}//success func 종료
	}) //ajax 종료
}

window.addEventListener('load',()=>{
	weather("서울시")
	document.getElementById("jonglo").addEventListener('click',()=>{
		weather("종로구");
	})
	document.getElementById("joong").addEventListener('click',()=>{
		weather("중구");
	})
	document.getElementById("yongsan").addEventListener('click',()=>{
		weather("용산구");
	})
	document.getElementById("seongdong").addEventListener('click',()=>{
		weather("성동구");
	})
	document.getElementById("gwangjin").addEventListener('click',()=>{
		weather("광진구");
	})
	document.getElementById("dongdaemoon").addEventListener('click',()=>{
		weather("동대문구");
	})
	document.getElementById("joonglang").addEventListener('click',()=>{
		weather("중랑구");
	})
	document.getElementById("seongbook").addEventListener('click',()=>{
		weather("성북구");
	})
	document.getElementById("gangbook").addEventListener('click',()=>{
		weather("강북구");
	})
	document.getElementById("dobong").addEventListener('click',()=>{
		weather("도봉구");
	})
	document.getElementById("nowon").addEventListener('click',()=>{
		weather("노원구");
	})
	document.getElementById("eunpyeong").addEventListener('click',()=>{
		weather("은평구");
	})
	document.getElementById("seodaemoon").addEventListener('click',()=>{
		weather("서대문구");
	})
	document.getElementById("mapo").addEventListener('click',()=>{
		weather("마포구");
	})
	document.getElementById("yangcheon").addEventListener('click',()=>{
		weather("양천구");
	})
	document.getElementById("gangseo").addEventListener('click',()=>{
		weather("강서구");
	})
	document.getElementById("guro").addEventListener('click',()=>{
		weather("구로구");
	})
	document.getElementById("geumcheon").addEventListener('click',()=>{
		weather("금천구");
	})
	document.getElementById("yeongdeungpo").addEventListener('click',()=>{
		weather("영등포구");
	})
	document.getElementById("dongjak").addEventListener('click',()=>{
		weather("동작구");
	})
	document.getElementById("gwanak").addEventListener('click',()=>{
		weather("관악구");
	})
	document.getElementById("seocho").addEventListener('click',()=>{
		weather("서초구");
	})
	document.getElementById("gangnam").addEventListener('click',()=>{
		weather("강남구");
	})
	document.getElementById("songpa").addEventListener('click',()=>{
		weather("송파구");
	})
	document.getElementById("gangdong").addEventListener('click',()=>{
		weather("강동구");
	})
})