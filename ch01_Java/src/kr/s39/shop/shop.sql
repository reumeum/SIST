--상품 정보
CREATE TABLE sitem(
item_num NUMBER PRIMARY KEY, --상품 번호
item_name VARCHAR2(30) NOT NULL, --상품명
item_price NUMBER(9) NOT NULL, --가격
item_date DATE DEFAULT SYSDATE NOT NULL --등록일
);

CREATE SEQUENCE sitem_seq;

--회원 정보
CREATE TABLE customer(
cust_id VARCHAR2(30) PRIMARY KEY, --회원id
cust_name VARCHAR2(30) NOT NULL, --회원명
cust_address VARCHAR2(90) NOT NULL, --주소
cust_tel VARCHAR2(20) NOT NULL, --전화번호
cust_date DATE DEFAULT SYSDATE NOT NULL --가입일
);

--주문정보
CREATE TABLE sorder(
order_num NUMBER PRIMARY KEY, --주문 번호
cust_id VARCHAR2(30) REFERENCES customer(cust_id), --회원 id
item_num NUMBER REFERENCES sitem(item_num), --상품 번호
order_date DATE DEFAULT SYSDATE NOT NULL --주문일
);

CREATE SEQUENCE sorder_seq;