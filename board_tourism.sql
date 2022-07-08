use memberdb;
DROP TABLE member;
create table member (
	email varchar(50), #이메일
    name varchar(50) not null, #이름
    passwd char(64), #비밀번호
    birthdate varchar(30), #생년월일
    address varchar(100), #주소
    simplejoin char(1) default '0', #0:일반가입, 1:네이버
    regidate datetime default now(), #등록일자
    modidate datetime default now(), #수정일자
    primary key (email)
);

select *  from member;
DROP TABLE board;
CREATE TABLE board(
bnum int(5),
email VARCHAR(50),
subject VARCHAR(100),
content VARCHAR(1000),
readcnt int(5) DEFAULT 0,#--조회수
likecnt int(5) DEFAULT 0, #좋아요
dislikecnt int(5) DEFAULT 0, #싫어요
ip VARCHAR(50), #작성자의ip
regidate datetime DEFAULT now(), #작성일자
modidate datetime DEFAULT now() on UPDATE now(), #수정일자,
removeyn CHAR(1) DEFAULT 'n', #삭제여부(y/n) 
PRIMARY KEY (bnum)
);

select * from board;

delete from board;
#게시물파일테이블(boardfile)
#컬럼:bfnum(파일번호:pk:bf_seq), bnum(게시물번호:fk), filename(파일이름)
DROP TABLE boardfile;
CREATE TABLE boardfile(
bfnum int(5) NOT NULL AUTO_INCREMENT,
bnum int(5),
filename VARCHAR(50),
PRIMARY KEY(bfnum),
FOREIGN KEY (bnum) REFERENCES board(bnum)
);
select * from boardfile;
#댓글테이블(reply)
#컬럼:rnum(댓글번호:pk: r_seq), bnum(게시물번호:fk), email(작성자:fk), content(댓글의내용), 
--     ip(작성자의ip), restep(댓글의순서), relevel(댓글의레벨),  regidate(등록일자),modidate(수정일자)
DROP TABLE reply CASCADE;
CREATE TABLE reply(
rnum INT NOT NULL AUTO_INCREMENT, #댓글번호
bnum int(5), #게시물번호
email VARCHAR(50), #작성자
content VARCHAR(1000), #댓글의내용
ip VARCHAR(50), #작성자의ip
restep int(3), #글순서
relevel int(3), #글레벨
regidate datetime DEFAULT now(),
modidate datetime DEFAULT now() on UPDATE now(),
PRIMARY KEY(rnum),
FOREIGN KEY(bnum) REFERENCES board(bnum)
);

drop table tourism;
CREATE TABLE tourism(
tnum int(7), #번호
tname VARCHAR(300) , #상호
taddress VARCHAR(300), #주소
taddress_new VARCHAR(300), #신주소
phone VARCHAR(300), #전화번호
site VARCHAR(300), #웹사이트
use_time VARCHAR(1024), #운영시간
bsnde VARCHAR(300), #운영요일
rstde VARCHAR(300), #휴무일
subway_info VARCHAR(300), #교통정보
tag VARCHAR(300), #태그
BF_DESC VARCHAR(300) #장애인편의시설
);

select * from tourism;

DROP TABLE SEQ_MYSQL;

CREATE TABLE SEQ_MYSQL(
	ID VARCHAR(10) NOT NULL,
    SEQ_NAME VARCHAR(50) NOT NULL
);

SET Global log_bin_trust_function_creators='ON'; # root에서 실행
SET SQL_SAFE_UPDATES = 0;

/* 생성된 펑션 삭제 */
DROP FUNCTION IF EXISTS get_seq;

/* Auto_increment 적용 */
DELIMITER $$
CREATE FUNCTION get_seq (p_seq_name VARCHAR(45))
RETURNS VARCHAR(10) READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE SEQ_MYSQL SET ID = CAST(LAST_INSERT_ID(CAST(id as unsigned)+1) as char(10))
WHERE SEQ_NAME = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN LPAD(RESULT_ID,10,'0');
END $$
DELIMITER ;

/* 시퀀스 생성 */
INSERT INTO seq_mysql
VALUES ('0', 'ID_SEQ');

/* 시퀀스 삽입 */
SELECT get_seq('ID_SEQ');

commit;