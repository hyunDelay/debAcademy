-- BOARD
DROP SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NO                  NUMBER          PRIMARY KEY
    , TITLE             VARCHAR2(100)   NOT NULL
    , CONTENT           VARCHAR2(4000)  NOT NULL
    , ENROLL_DATE       TIMESTAMP       DEFAULT SYSDATE
    , DEL_YN            CHAR(1)         DEFAULT 'N' CHECK(DEL_YN IN ('Y','N'))
    , WRITER_NO         NUMBER          NOT NULL
);

-- MEMBER
DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    NO              NUMBER          PRIMARY KEY
    , ID            VARCHAR2(100)   NOT NULL UNIQUE
    , PWD           VARCHAR2(100)   NOT NULL
    , NICK          VARCHAR2(100)   NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , DEL_YN        CHAR(1)         DEFAULT 'N' CHECK(DEL_YN IN ('Y','N'))
);

-- �ܷ�Ű
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO);



-- GALLERY
DROP SEQUENCE SEQ_GALLERY_NO;
CREATE SEQUENCE SEQ_GALLERY_NO NOCACHE NOCYCLE;
DROP TABLE GALLERY CASCADE CONSTRAINTS;
CREATE TABLE GALLERY(
    NO                  NUMBER          PRIMARY KEY
    , TITLE             VARCHAR2(100)   NOT NULL
    , FULL_PATH         VARCHAR2(1000)  NOT NULL
    , WRITER_NO         NUMBER          NOT NULL
    , HIT               NUMBER          DEFAULT 0
    , ENROLL_DATE       TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE       TIMESTAMP       DEFAULT SYSDATE
    , STATUS            CHAR(1)         DEFAULT 'O' CHECK( STATUS IN ('O', 'X') )
);
----------------------------------------------------
-- �ܷ�Ű
----------------------------------------------------
-- MEMBER
--INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL, 'USERUSER', '1234', 'NICK01');
-- BOARD
--INSERT INTO BOARD (NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, 'TTT01', 'CCC01', 1);
--INSERT INTO BOARD (NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, 'TTT02', 'CCC02', 1);
--INSERT INTO BOARD (NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL, 'TTT03', 'CCC03', 1);
COMMIT;












