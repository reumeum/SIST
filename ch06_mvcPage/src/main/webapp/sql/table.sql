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