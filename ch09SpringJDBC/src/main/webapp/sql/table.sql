CREATE TABLE abroad(
	num number primary key,
	writer varchar2(30) not null,
	title varchar2(60) not null,
	passwd varchar2(12) not null,
	content clob not null,
	reg_date date not null
);

CREATE SEQUENCE aboard_seq;