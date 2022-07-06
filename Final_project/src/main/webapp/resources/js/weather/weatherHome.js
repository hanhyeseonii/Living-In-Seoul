window.addEventListener('load',()=>{
	$.ajax({
		url : `/myapp/weather/weatherDetail`,
		method : 'POST',
		data : {"id" : "서울시"},
		success : function(data){
			var tempNow = Object.values(data[0])[0];
			var sky = Object.values(data[2])[0];
			var rainState = Object.values(data[3])[0];
		
			if(rainState!='0') {
				switch(rainState) {
					case "1":
						$('.weather-text').html("☔비 "+tempNow+"℃");
						break;
					case "2":
						$('.weather-text').html("🌨비/눈 "+tempNow+"℃");
						break;
					case "3":
						$('.weather-text').html("☃눈 "+tempNow+"℃");
						break;
					case "4":
						$('.weather-text').html("☔소나기 "+tempNow+"℃");
						break;
				}
			}else {
				switch(sky) {
					case "1":
						$('.weather-text').html("☀맑음 "+tempNow+"℃");
						break;
					case "2":
						$('.weather-text').html("🌤구름조금 "+tempNow+"℃");
						break;
					case "3":
						$('.weather-text').html("⛅구름많음 "+tempNow+"℃");
						break;
					case "4":
						$('.weather-text').html("☁흐림 "+tempNow+"℃");    
						break;
           		}    
       		}					
		}//success func 종료
	}) //ajax 종료
})