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