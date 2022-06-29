window.onload=function(){
	$.ajax({
		url : `/myapp/covid/covidInfo`,
		method : 'POST',
		success : function(data){
			var covid = Object.values(data[0])[1];
			var death = Object.values(data[0])[0];
			$('.covid-cnt').html(covid+"명");
			$('.death-cnt').html(death+"명");
		}
		
	})
}