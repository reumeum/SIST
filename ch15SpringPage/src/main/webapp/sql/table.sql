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

--댓글
CREATE TABLE spboard_reply(
	re_num NUMBER NOT NULL,
	re_content VARCHAR2(900) NOT NULL,
	re_date DATE DEFAULT SYSDATE NOT NULL,
	re_mdate DATE,
	re_ip VARCHAR2(40) NOT NULL,
	board_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT spboard_reply_pk PRIMARY KEY (re_num),
	CONSTRAINT reply_spboard_fk1 FOREIGN KEY (board_num) REFERENCES spboard (board_num),
	CONSTRAINT reply_spmember_fk2 FOREIGN KEY (mem_num) REFERENCES spmember (mem_num)
);
CREATE SEQUENCE spreply_seq;

--댓글 좋아요
CREATE TABLE spreply_fav(
	re_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT refav_fk1 FOREIGN KEY (re_num) REFERENCES spboard_reply (re_num),
	CONSTRAINT refav_fk2 FOREIGN KEY (mem_num) REFERENCES spmember (mem_num)
);

--답글
CREATE TABLE spboard_response(
	te_num NUMBER NOT NULL,
	te_content VARCHAR2(900) NOT NULL,
	te_date DATE DEFAULT SYSDATE NOT NULL,
	te_mdate DATE,
	te_parent_num NUMBER NOT NULL, --부모글의 번호가 들어감, 자식글이 아니라 부모글일 경우 0 (외래키 제약조건 못줌)
	te_depth NUMBER NOT NULL, --자식글의 깊이. 부모글의 자식글A 1, 자식글A의 자식글B 2, 부모글일 경우 0
	te_ip VARCHAR2(40) NOT NULL,
	re_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT spboard_treply_pk PRIMARY KEY (te_num),
	CONSTRAINT treply_reply_fk1 FOREIGN KEY (re_num) REFERENCES spboard_reply (re_num),
	CONSTRAINT treply_spmember_fk2 FOREIGN KEY (mem_num) REFERENCES spmember (mem_num)
);

CREATE SEQUENCE response_seq;