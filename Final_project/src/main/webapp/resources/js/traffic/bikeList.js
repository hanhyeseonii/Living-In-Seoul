$(()=>{ 
	const path = $('#contextPath').val(); 
	const sessionEmail = $('#sessionEmail').text().trim();
	
	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(37.48450851, 126.93006897),
		zoom:15
	});
	
	var markers = [],
		favoritMaker = [],
   		infoWindows = [];
	
	//실시간 대여소 정보 받아와 맵에 뿌려주는 함수
	function stationList(){
		var stationId = $('#stationId').val();
		if(stationId!=''){ // 유효성 체크
			
			$.ajax({
				url : `${path}/traffic/serch/`,
				type : 'get',
				data : {"stationId": stationId},
				dataType : 'json', // 응답받을 데이터 타입
				success : (json)=>{
					//맵 센터 이동
					map.setCenter(new naver.maps.LatLng(json[0].stationLatitude, json[0].stationLongitude));
					
					//맵에 좌표로 마커찍어주는 함수
					for(key in json){
					    var position = new naver.maps.LatLng( json[key].stationLatitude, json[key].stationLongitude);
					    var marker = new naver.maps.Marker({
					        map: map,
					        position: position,
					        title: json[key].stationId,
							icon: {
						        content: [
						                    `<div class="markers">${json[key].parkingBikeTotCnt}</div>`
						                ].join(''),
						        size: new naver.maps.Size(30, 30),
						    },
					    });
					    var infoWindow = new naver.maps.InfoWindow({
					        content: '<div style="width:150px;text-align:center;padding:10px;"> <b>'+ json[key].stationName +'</b><br>'
								+ json[key].rackTotCnt + '/'+ json[key].parkingBikeTotCnt + 
								`<button class="addFavorite" valu="${json[key].stationId}"><img class="info_favorite" src="${path}/resources/images/aside_favorite2.png"></button></div>`
					    });
						
					    markers.push(marker);
					    infoWindows.push(infoWindow);
					}
					
					naver.maps.Event.addListener(map, 'idle', function() {
					    updateMarkers(map, markers);
					});
					
					//맵 범위 안의 마커만 출력
					function updateMarkers(map, markers) {
					    var mapBounds = map.getBounds();
					    var marker, position;
					    for (var i = 0; i < markers.length; i++) {
					        marker = markers[i]
					        position = marker.getPosition();
					        if (mapBounds.hasLatLng(position)) {
					            showMarker(map, marker);
					        } else {
					            hideMarker(map, marker);
					        }
					    }
					}
					
					function showMarker(map, marker) {
					    if (marker.setMap()) return;
					    marker.setMap(map);
					}
					function hideMarker(map, marker) {
					    if (!marker.setMap()) return;
					    marker.setMap(null);
					}
					
					//해당 마커의 인덱스를 seq라는 클로저 변수로 저장하는 이벤트 핸들러를 반환합니다.
					function getClickHandler(seq) {
					    return function(e) {
					        var marker = markers[seq],
					            infoWindow = infoWindows[seq];
					        if (infoWindow.getMap()) {
					            infoWindow.close();
					        } else {
					            infoWindow.open(map, marker);
					        }
					    }
					}
					
					for (var i=0, ii=markers.length; i<ii; i++) {
					    naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i));
					}
					
				},
				error : console.error
			});
		}else{
			$('#stationAddress').focus();
		}
	}
	
	stationList();
	
	//자전거 레이어
	var bicycleLayer = new naver.maps.BicycleLayer();
	var bikeBtn = $('#bike_rayer');
	
	naver.maps.Event.addListener(map, 'bicycleLayer_changed', function(bicycleLayer) {
	    if (bicycleLayer) {
	        bikeBtn.addClass('control-on');
	    } else {
	        bikeBtn.removeClass('control-on');
	    }
	});
	
	bikeBtn.on("click", function(e) {
	    e.preventDefault();
	
	    if (bicycleLayer.getMap()) {
	        bicycleLayer.setMap(null);
	    } else {
	        bicycleLayer.setMap(map);
	    }
	});
					
	//검색 클릭시 ajax비동기 방식 호출
	$('#serch_station').click((e)=>{
		e.preventDefault();		
		
		//기존마커 삭제(덜구현)
		for(var i=0;i<markers.length;i++){
			markers[i].setMap(null);
		}	
		
		stationList();
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
        },    // source는 자동완성 대상
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
	
	
	//즐겨찾기 추가
	$('.addFavorite').on("click",function(e){
		e.preventDefault();
		
		var stationId = $('.addFavorite').val();
		console.log(stationId);
	})
	
	//즐겨찾기리스트 가져오기
	function favoriteList(){
		if(sessionEmail!=""){
			$.ajax({
				type: 'get',
                url: `${path}/traffic/favorite`,
				data: {"email":sessionEmail},
                dataType: "json",
				success: function(json){
					for(key in json){
						var position = new naver.maps.LatLng( json[key].stationLatitude, json[key].stationLongitude);	
						var marker = new naver.maps.Marker({
					        map: map,
					        position: position,
							icon: {
						        content: [
						                    `<div class="favorite"><img class="favorite_marker" src="${path}/resources/images/favorite.png"></div>`
						                ].join(''),
						        size: new naver.maps.Size(10, 10),
						    },
					    });
						favoritMaker.push(marker)
					}
				},
				error : ()=>{
					console.error
				}
			});
			
		}else{
			console.log("실행안함")
		}
	}
	
	favoriteList();
	
	//즐겨찾기 리스트 열기
	$('#aside_favorite').click((e)=>{
		e.preventDefault();
		
	});
});