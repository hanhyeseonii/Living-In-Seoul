drop table accident;
create table accident(
	accid int(5),
    accinfo varchar(200),
    regidate datetime DEFAULT now(),
    PRIMARY KEY(accid)
);

-- 목록 조회 (최신 데이터 위로)
select * from accident order by accId desc;

-- 한건 조회(최신 데이터)
select * from accident where accId = (select max(accId) from accident);

-- 추가
insert into accident(accid,accinfo) values(5,"사고 내용");

-- 삭제 (현재시간 기준 3시간보다 이전 데이터 삭제)
delete from accident where regidate < DATE_ADD(NOW(), INTERVAL -3 HOUR);

