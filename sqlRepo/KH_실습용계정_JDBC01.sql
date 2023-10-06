-- 테이블 만들기
/*
    CREATE TABLE 테이블명(
        칼럼명 타입
        , 칼럼명 타입
        , 칼럼명 타입
        ...
    );
    [타입종류] 이 네가지 알고있으면 됨
    CHAR()
    VARCHAR2()
    NUMBER
    TIMESTAMP
*/
CREATE TABLE MEMBER(
    ID VARCHAR2(100)
    , PWD VARCHAR2(100)
    , NICK VARCHAR2(100)
);

-- 데이터 집어넣기
/*
    [문법] INSERT INTO 테이블명(칼럼명, 칼럼명, ...) VALUES (값1, 값2, ...);
              INSERT INTO 테이블명 VALUES (값1, 값2 ...); -> 칼럼명 떼도 가능 웬만하면 X
*/
INSERT INTO MEMBER(ID, PWD, NICK) VALUES ('USER01', '1234', 'NICK01');
INSERT INTO MEMBER(ID, PWD) VALUES ('USER02', '1234');

-- 데이터 수정하기
/*
    [문법] UPDATE 테이블명 
            SET 칼럼명 = 값
            , 칼럼명 = 값
            , 칼럼명 = 값
            , ...;
            특정행만 바꾸려면 WHERE조건 추가
*/
UPDATE MEMBER 
    SET NICK = '없음'
    , PWD = '0000';

-- 데이터 삭제하기
/*
    [문법] DELETE 테이블명
*/
DELETE MEMBER
WHERE ID = 'USER02';

-- 데이터 조회하기
SELECT *
FROM MEMBER;

-- 테이블 삭제하기
/*
    [문법] DROP TABLE 테이블명
*/
DROP TABLE MEMBER;

-- 커밋




















