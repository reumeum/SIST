CREATE TABLE member(
me_id VARCHAR2(10) PRIMARY KEY, --회원 ID
me_passwd VARCHAR2(10) NOT NULL, --비밀번호
me_name VARCHAR2(30) NOT NULL, --회원명
me_phone VARCHAR2(13) NOT NULL, --전화번호
me_regdate DATE DEFAULT SYSDATE NOT NULL --가입일
);

CREATE TABLE sbook(
bk_num NUMBER PRIMARY KEY, --도서 번호
bk_name VARCHAR2(90) NOT NULL, --도서명
bk_category VARCHAR2(30) NOT NULL, --분류
bk_regdate DATE DEFAULT SYSDATE NOT NULL --등록일
);

CREATE SEQUENCE sbook_seq;

--도서 대출 정보
CREATE TABLE reservation(
re_num NUMBER PRIMARY KEY,
re_status NUMBER(1) NOT NULL, --0.반납(미대출), 1.대출중
bk_num NUMBER NOT NULL REFERENCES sbook(bk_num), --도서 번호
me_id VARCHAR2(10) NOT NULL REFERENCES member(me_id), --회원 id
re_regdate DATE DEFAULT SYSDATE NOT NULL, --대출 날짜
re_modifydate DATE --반납 날짜
);

CREATE SEQUENCE reservaton_seq;