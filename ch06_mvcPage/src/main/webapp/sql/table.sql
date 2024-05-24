--회원관리
CREATE TABLE zmember(
	mem_num NUMBER NOT NULL,
	id VARCHAR2(12) UNIQUE NOT NULL,
	auth NUMBER(1) DEFAULT 2 NOT NULL, --회원 등급:0탈퇴회원,1정지회원,2일반회원,9관리자
	CONSTRAINT zmember_pk PRIMARY KEY (mem_num)
);

CREATE TABLE zmember_detail(
	mem_num NUMBER NOT NULL,
	name VARCHAR2(30) NOT NULL,
	passwd VARCHAR2(12) NOT NULL,
	phone VARCHAR2(15) NOT NULL,
	email VARCHAR2(50) NOT NULL,
	zipcode VARCHAR2(5) NOT NULL,
	address1 VARCHAR2(90) NOT NULL,
	address2 VARCHAR2(90) NOT NULL,
	photo VARCHAR2(400),
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	CONSTRAINT zmember_detail_pk PRIMARY KEY (mem_num),
	CONSTRAINT zmember_detail_fk FOREIGN KEY (mem_num) REFERENCES zmember (mem_num)
);

CREATE SEQUENCE zmember_seq;

--게시판
CREATE TABLE zboard (
	board_num NUMBER NOT NULL,
	title VARCHAR2(150) NOT NULL,
	content CLOB NOT NULL,
	hit NUMBER(9) DEFAULT 0 NOT NULL,
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	filename VARCHAR2(400),
	ip VARCHAR2(40) NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT zboard_pk PRIMARY KEY (board_num),
	CONSTRAINT zboard_fk FOREIGN KEY (mem_num) REFERENCES zmember (mem_num)
);

CREATE SEQUENCE zboard_seq;

--좋아요
CREATE TABLE zboard_fav(
	board_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT zboard_fav_fk1 FOREIGN KEY(board_num) REFERENCES zboard(board_num),
	CONSTRAINT zboard_fav_fk2 FOREIGN KEY(mem_num) REFERENCES zmember(mem_num)
);

--댓글
CREATE TABLE zboard_reply (
	re_num NUMBER NOT NULL,
	re_content VARCHAR2(900) NOT NULL,
	re_modifydate DATE,
	re_ip VARCHAR2(40) NOT NULL,
	re_date DATE DEFAULT SYSDATE NOT NULL,
	board_num NUMBER NOT NULL,
	mem_num NUMBER NOT NULL,
	CONSTRAINT zreply_pk PRIMARY KEY (re_num),
	CONSTRAINT zreply_fk1 FOREIGN KEY (board_num) REFERENCES zboard(board_num),
	CONSTRAINT zreply_fk2 FOREIGN KEY (mem_num) REFERENCES zmember(mem_num)
);

CREATE SEQUENCE zreply_seq;

--상품
CREATE TABLE zitem(
	item_num NUMBER NOT NULL,
	name VARCHAR2(30) NOT NULL,
	price NUMBER(9) NOT NULL,
	quantity NUMBER(7) NOT NULL,
	photo1 VARCAHR2(400) NOT NULL,
	photo2 VARCHAR2(400) NOT NULL,
	detail CLOB NOT NULL,
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	modify_date DATE,
	status NUMBER(1) NOT NULL, --표시 여부(판매 가능 여부)1:미표시, 2:표시
	CONSTRAINT zitem_pk PRIMARY KEY (item_num)
);

CREATE SEQUENCE zitem_seq;