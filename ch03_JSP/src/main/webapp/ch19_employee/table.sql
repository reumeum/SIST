CREATE TABLE semployee(
	num NUMBER PRIMARY KEY,
	id VARCHAR2(12) UNIQUE NOT NULL,
	name VARCHAR2(30) NOT NULL,
	passwd VARCHAR2(12) NOT NULL,
	salary NUMBER(8) NOT NULL,
	job VARCHAR2(30) NOT NULL,
	reg_date DATE DEFAULT SYSDATE NOT NULL
);

CREATE SEQUENCE semployee_seq;

CREATE TABLE story(
	snum NUMBER NOT NULL,
	title VARCHAR2(150) NOT NULL,
	content CLOB NOT NULL,
	ip VARCHAR2(30) NOT NULL,
	num NUMBER NOT NULL,
	reg_date DATE DEFAULT SYSDATE NOT NULL,
	CONSTRAINT story_pk PRIMARY KEY (snum),
	CONSTRAINT story_fk FOREIGN KEY (num) REFERENCES semployee (num)
);

CREATE SEQUENCE story_seq;