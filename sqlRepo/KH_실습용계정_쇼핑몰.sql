-- 쇼핑몰

/*
    제공할 기능 : 
    <유저>
        - 회원가입
        - 로그인
        - 비밀번호 변경
        - 탈퇴하기
        
        - 전체 상품 조회
        - 특정 상품 검색
    
    <판매자>
        - 상품 등록
        - 상품 가격 변경
        - 상품 삭제
    
*/
-- MEMBER
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    ID VARCHAR2(100)
    , PWD VARCHAR2(100)
    , NICK VARCHAR2(100)
    , ENROLL_DATE TIMESTAMP
);

-- ITEM
DROP TABLE ITEM;
CREATE TABLE ITEM(
    NAME VARCHAR2(100)
    , PRICE NUMBER
    , CNT NUMBER
    , ENROLL_DATE TIMESTAMP
);

-- 회원가입
INSERT INTO MEMBER(ID, PWD, NICK, ENROLL_DATE) VALUES ('유저입력ID', '유저입력PWD', '유저입력NICK', SYSDATE);
-- 로그인
SELECT * FROM MEMBER WHERE ID = '유저입력ID' AND PWD = '유저입력PWD';
-- 비밀번호 변경
UPDATE MEMBER 
SET PWD = '유저입력 신규비밀번호' -- SC.NEXTLINE();
WHERE ID = '유저입력ID' AND PWD = '유저입력PWD';  -- 아이디가 OOO인 비번이 ㅇㅇ인
-- 탈퇴
DELETE MEMBER WHERE ID = '유저입력ID' AND PWD = '유저입력PWD';

-- 상품 등록
INSERT INTO ITEM(NAME, PRICE, CNT, ENROLL_DATE) VALUES ('유저입력NAME', '유저입력PRICE', '유저입력CNT', SYSDATE);
-- 상품가격 변경
UPDATE ITEM 
SET PRICE = '유저입력 가격'
    , CNT = '유저입력 수량'
WHERE NAME = 'NAME';
-- 상품 삭제
DELETE ITEM WHERE NAME = '삭제할 상품명';
-- 모든 상품 조회 (최신등록순)
SELECT * 
FROM ITEM 
ORDER BY ENROLL_DATE ASC;














