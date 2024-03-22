CREATE TABLE car(
	num NUMBER PRIMARY KEY, 
	name VARCHAR2(30) NOT NULL, --이름
	cnumber VARCHAR2(30) NOT NULL, --차번호
	color VARCHAR2(30) NOT NULL, --색상
	maker VARCHAR2(30) NOT NULL, --제조사
	price NUMBER(10) NOT NULL, --가격
	reg_date DATE NOT NULL --등록일
);

CREATE SEQUENCE car_seq;