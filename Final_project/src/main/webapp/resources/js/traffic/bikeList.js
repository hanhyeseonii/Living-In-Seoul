$(function(){ 
	var path = $('#contextPath').val(); 
	var position = new naver.maps.LatLng(37.484746663141095, 126.93006829643338);
	
	//맵 옵션
	var mapOptions = { 
	    center: position, // 지도초기 중심좌표
	    zoom: 14 
	}; 
	
	//map 객체
	//지도를 표한할 'map' 엘리먼트, mapOtion을 이용하여 생성 
	var map = new naver.maps.Map('map', mapOptions); 
	
	//마커 옵션
	/*var markerOptions = {
		position: position,
	    map: map,
	}*/
	
	var maker = new naver.maps.Marker({
        map: map,
        position: position
    });
	
	/*var greenMarker = new naver.maps.Marker({
	    position: position,
        map: map,
        title: 'Green Marker',
        icon: {
            content: [
                '<div class="cs_mapbridge">',
                '<div class="map_group _map_group crs">',
                '<div class="map_marker _marker num1 num1_big"> ',
                '<span class="ico _icon"></span>',
                '<span class="shd"></span>',
                '</div>',
                '</div>',
                '</div>'
            ].join(''),
            size: new naver.maps.Size(38, 58),
            anchor: new naver.maps.Point(19, 58),
        },
        draggable: true
    });*/
	

	//비동기 방식으로 출력할 맵을 생성하는 함수
	function initMap(stationLatitude, stationLongitude) {
		map = new naver.maps.Map('map', {
			center: new naver.maps.LatLng(stationLatitude, stationLongitude),
			zoom: 14
		});
	}
	
	//맵에 좌표로 마커찍어주는 함수
	function addMaker(stationLatitude, stationLongitude){
		
		marker = new naver.maps.Marker({
			position: new naver.maps.LatLng(stationLatitude, stationLongitude),
			map: map,
			/*icon: {
				path: [
        			new naver.maps.Point(0, 70), new naver.maps.Point(20, 100), new naver.maps.Point(40, 70),
        			new naver.maps.Point(30, 70), new naver.maps.Point(70, 0), new naver.maps.Point(10, 70)
    			],
				style : "CIRCLE",
				radius : 1,
		        anchor: new naver.maps.Point(23, 103),
		        fillColor: '#ff0000', //폴리곤 배경색
		        fillOpacity: 1,	//폴리곤 배경색의 불투명도(0~1)
		        strokeColor: '#000000', //폴리곤 선의 색상
		        strokeStyle: 'solid', //
		        strokeWeight: 3 //폴리곤 선의 두께
		    },
		    shadow: {
		        url: "./img/shadow-arrow.png",
		        size: new naver.maps.Size(193, 128),
		        origin: new naver.maps.Point(0, 0),
		        anchor: new naver.maps.Point(62, 120)
		    }*/
		});
			
	}
	
	//검색 클릭시 ajax비동기 방식 호출
	$('#serch_station').click(()=>{
		var stationId = $('#stationId').val();
		if(stationId!=''){ // 유효성 체크
		
			$.ajax({
				url : `${path}/traffic/serch/${stationId}`,
				type : 'get',
				dataType : 'json', // 응답받을 데이터 타입
				success : (json)=>{
					console.log(json);
					
					//맵의 센터위치 변경
					initMap(json[0].stationLatitude, json[0].stationLongitude);
					for(var i=0;i<json.length;i++){
						addMaker(json[i].stationLatitude, json[i].stationLongitude);
					}
					
				},
				error : console.error
			});
		}else{
			$('#stationAddress').focus();
		}
	});
	
	//자동완성 autocomplete
	$("#stationAddress").autocomplete({
		source : function( request, response ) { // source : 목록을 저장하는 공간과 비슷한 개념
        	$.ajax({
            	type: 'get',
                url: `${path}/traffic/autocomplete`,
                dataType: "json",
				//request.term = $("#findvalue").val()
                data: { value : request.term }, //서버로 보낼 데이터
                success: function(data) {
                    //서버에서 json 데이터 response 후 목록에 추가
                    response(
                        $.map(data, function(item) { //json[i] 번째 에 있는게 item 임.
                            return {
                                label: item.roadaddress + " " + item.detailaddress, //목록에 표시되는 값
                                value: item.roadaddress, //선택시 input창에 표시
								stationId: item.stationId,
                            }
                        })
                    );
                },
				error : ()=>{
					console.error
				}
        	});
        },    // source 는 자동 완성 대상
        select : function(event, ui) {  //아이템 선택시
			$('#stationId').val(ui.item.stationId);
        },
        focus : function(event, ui) {  //포커스 시 이벤트
            return false; //한글 에러 잡기용도로 사용됨
        },
        minLength: 2, // 최소 글자수
        autoFocus: true, //첫번째 항목 자동 포커스 기본값 false
        classes: {   // 위젯 요소에 추가 할 클래스를 지정
            "ui-autocomplete": "highlight"
        },
        delay: 400,  //검색창에 글자 입력 후 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
//      disabled: true, //자동완성 기능 끄기
        position: { my : "left top", at: "left bottom" }, // 목록 위치 지정
		close : function(event){
			console.log($("#stationAddress").val());
		}  
    }).autocomplete('instance')._renderItem = function(ul, item) {
		return $("<li>") // 자동완성 목록에 뿌려줄 html
		.append("<div>" + item.label + "</div>") 
		.appendTo( ul );
	};
	
});