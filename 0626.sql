use memberdb;
select user();

show tables;

###########################################################
#실시간 대여소 정보
drop table realTimeStationInfo;
create table realTimeStationInfo (
	stationId varchar(10) not null,
    stationName varchar(100) not null,
    rackTotCnt int not null,
    parkingBikeTotCnt int not null,
    shared int not null,
    stationLatitude decimal(11,8) not null,
    stationLongitude decimal(12,8) not null,
	foreign key (stationId) references bikeStation (stationId)
);

#foreign key (stationId) references bikeStaion (stationId)

insert into realTimeStationInfo(stationId, stationName, rackTotCnt, parkingBikeTotCnt,
	shared, stationLatitude, stationLongitude)
 values("ST-1027", "941. 은평뉴타운 도서관", 13, 0, 0, 37.63722229, 126.93330383);

update realTimeStationInfo
set stationName = '108. 수정됐나 확인',
	rackTotCnt = 13,
	parkingBikeTotCnt = 3,
	shared = 23,
    stationLatitude = 37.123,
    stationLongitude = 126.123
where stationId = "ST-10";

select * from realTimeStationInfo
order by stationID asc;
select count(*) from realTimeStationInfo;

#검색 대여소로부터 2키로 이내의 데이터 불러오기 
select *, (6371*acos(cos(radians(37.484746663141095))*cos(radians(stationLatitude))*cos(radians(stationLongitude)
	- radians(126.93006829643338))+sin(radians(37.484746663141095))*sin(radians(stationLatitude)))) as distance 
from realTimeStationInfo having distance < 2
order by distance asc;

#한건 조회
select * from realTimeStationInfo
where stationId = "ST-1073";

select * from realTimeStationInfo
where stationName like "%아현역%";
#
show table status like 'realTimeStationInfo';

###########################################################
#검색을 위한 대여소 마스터db
select * from bikeStation
order by stationID asc;
select count(*) from bikeStation;

drop table bikeStation;

#컬럼 데이터 타입 수정
alter table bikeStation modify stationId varchar(10) primary key not null;
alter table bikeStation modify roadaddress varchar(100) not null;
alter table bikeStation modify detailaddress varchar(80);
#정확한 소수점 저장을 위해 decimal타입 사용
alter table bikeStation modify stationLatitude decimal(9,6) not null;
alter table bikeStation modify stationLongitude decimal(10,6) not null;

#한건 조회
select * from bikeStation
where stationId = "ST-1705";

#자동 완성을 위한 리스트 조회
select * from bikeStation
where roadaddress like "%동빙고%" or detailaddress like "%동빙고%"
limit 10;

#key값이 아닌 값으로 수정하거나 지우려고 하면 에러가 safemode로 인해 에러발생
#safe updates 일시적으로 해제해준다(0), 다시 적용(1) 
set sql_safe_updates=1;

#좌표값이 0으로 되어 있는 쓰레기데이터 지우기
delete from bikeStation
where stationLatitude = 0;




