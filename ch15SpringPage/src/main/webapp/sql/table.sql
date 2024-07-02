--회원관리
CREATE TABLE spmember(
	mem_num NUMBER NOT NULL,
	id VARCHAR2(12) UNIQUE NOT NULL,
	nick_name VARCHAR2(30),
	auth NUMBER(1) DEFAULT 2 NOT NULL, --0. 탈퇴회원, 1. 정지회원, 2. 일반회원, 9. 관리자
	CONSTRAINTS spmember_pk PRIMARY KEY (mem_num)
);

CREATE TABLE spmember_detail(
	mem_num NUMBER NOT NULL,
	au_id VARCHAR2(36) UNIQUE, --자동 로그인에 사용되는 식별값
    name VARCHAR2(30) NOT NULL,
	passwd VARCHAR2(35) NOT NULL,
	phone VARCHAR2(15) NOT NULL,
	email VARCHAR2(50) NOT NULL,
	zipcode VARCHAR2(5) NOT NULL,
	address1 VARCHAR2(90) NOT NULL,
	address2 VARCHAR2(90) NOT NULL,
	photo blob,
	photo_name VARCHAR2(100),
	reg_date DATE DEFAULT sysdate NOT NULL,
	modify_date DATE,
	CONSTRAINT spmember_detail_pk PRIMARY KEY (mem_num),
	CONSTRAINT spmember_detail_fk FOREIGN KEY (mem_num) REFERENCES spmember (mem_num)
);

CREATE SEQUENCE spmember_seq;

--게시판
create table spboard(
 board_num number not null,
 category char(1) not null,
 title varchar2(90) not null,
 content clob not null,
 hit number(8) default 0 not null,
 reg_date date default sysdate not null,
 modify_date date,
 filename varchar2(400),
 ip varchar2(40) not null,
 mem_num number not null,
 constraint spboard_pk primary key (board_num),
 constraint spboard_fk foreign key(mem_num) references spmember (mem_num)
);

create sequence spboard_seq;

--게시판 좋아요
CREATE TABLE spboard_fav(
	board_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT fav_spboard_fk1 FOREIGN KEY (board_num) REFERENCES spboard(board_num),
	CONSTRAINT fav_spmember_fk2 FOREIGN KEY (mem_num) REFERENCES spmember(mem_num)
);