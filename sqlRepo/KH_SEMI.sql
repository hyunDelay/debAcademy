

-- MEMBER
DROP SEQUENCE SEQ_MEMBER_NO;
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;

DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    NO                  NUMBER          PRIMARY KEY
    , ID                VARCHAR2(100)   NOT NULL UNIQUE
    , PWD               VARCHAR2(100)   NOT NULL
    , NICK              VARCHAR2(100)   NOT NULL
    , PHONE             CHAR(13)        
    , EMAIL             VARCHAR2(100)
    , ADDRESS           VARCHAR2(100)
    , HOBBYS            VARCHAR2(100)
    , ENROLL_DATE       TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE       TIMESTAMP       DEFAULT SYSDATE
    , STATUS            CHAR(1)         DEFAULT 'O' CHECK (STATUS IN ('O', 'X'))
);

-- BOARD
DROP SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;

DROP TABLE BOARD CASCADE CONSTRAINTS;
CREATE TABLE BOARD(
    NO                  NUMBER              PRIMARY KEY
    , CATEGORY_NO       NUMBER              NOT NULL
    , TITLE             VARCHAR2(100)       NOT NULL
    , CONTENT           VARCHAR2(4000)      NOT NULL
    , WRITER_NO         NUMBER              NOT NULL
    , HIT               NUMBER              DEFAULT 0
    , ENROLL_DATE       TIMESTAMP           DEFAULT SYSDATE
    , MODIFY_DATE       TIMESTAMP           DEFAULT SYSDATE
    , STATUS            CHAR(1)             DEFAULT 'O' CHECK(STATUS IN('O', 'X'))
);

-- GALLERY
DROP SEQUENCE SEQ_GALLERY_NO;
CREATE SEQUENCE SEQ_GALLERY_NO NOCACHE NOCYCLE;

DROP TABLE GALLERY CASCADE CONSTRAINTS;
CREATE TABLE GALLERY(
    NO                  NUMBER              PRIMARY KEY
    , TITLE             VARCHAR2(100)       NOT NULL
    , WRITER_NO         NUMBER              NOT NULL
    , HIT               NUMBER              DEFAULT 0
    , ENROLL_DATE       TIMESTAMP           DEFAULT SYSDATE
    , MODIFY_DATE       TIMESTAMP           DEFAULT SYSDATE
    , STATUS            CHAR(1)             DEFAULT 'O' CHECK(STATUS IN('O', 'X'))
);

-- ATTACHMENT
DROP SEQUENCE SEQ_ATTACHMENT_NO;
CREATE SEQUENCE SEQ_ATTACHMENT_NO NOCACHE NOCYCLE;

DROP TABLE ATTACHMENT CASCADE CONSTRAINTS;
CREATE TABLE ATTACHMENT(
    NO                  NUMBER              PRIMARY KEY
    , REF_NO            NUMBER              NOT NULL
    , ORIGIN_NAME       VARCHAR2(1000)     
    , CHANGE_NAME       VARCHAR2(1000)      NOT NULL
    , FILE_PATH         VARCHAR2(1000)      NOT NULL
    , THUMBNAIL_YN      CHAR(1)             DEFAULT 'N' CHECK(THUMBNAIL_YN IN ('Y', 'N'))
);

-- 朝砺壱軒
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
CREATE TABLE CATEGORY(
    NO          NUMBER              PRIMARY KEY
    , NAME      VARCHAR2(100)       NOT NULL
);

-- COMMENT
DROP SEQUENCE SEQ_REPLY_NO;
CREATE SEQUENCE SEQ_REPLY_NO NOCACHE NOCYCLE;
DROP TABLE REPLY CASCADE CONSTRAINTS;
CREATE TABLE REPLY(
    NO              NUMBER          PRIMARY KEY
    , REF_NO        NUMBER          NOT NULL
    , CONTENT       VARCHAR2(1000)  NOT NULL
    , WRITER_NO     NUMBER          NOT NULL
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , STATUS        CHAR(1)         DEFAULT 'O' CHECK( STATUS IN ('O','X') )
);

-- 須掘徹
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO);
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_CATEGORY FOREIGN KEY(CATEGORY_NO) REFERENCES CATEGORY(NO);
ALTER TABLE ATTACHMENT ADD CONSTRAINT FK_ATTACHMENT_REF_NO FOREIGN KEY(REF_NO) REFERENCES GALLERY(NO);
ALTER TABLE REPLY ADD CONSTRAINT FK_REPLY_REF_NO FOREIGN KEY(REF_NO) REFERENCES BOARD(NO);

-- 汽戚斗 INSERT (MEMBER)
INSERT INTO MEMBER (NO, ID, PWD, NICK) VALUES (0, 'admin', '1234', '淫軒切');
COMMIT;

-- 汽戚斗 INSERT (CATEGORY)
INSERT INTO CATEGORY (NO, NAME) VALUES (1, '切政');
INSERT INTO CATEGORY (NO, NAME) VALUES (2, '惟績');
INSERT INTO CATEGORY (NO, NAME) VALUES (3, '推軒');
INSERT INTO CATEGORY (NO, NAME) VALUES (4, '錘疑');
INSERT INTO CATEGORY (NO, NAME) VALUES (5, '切郊');
INSERT INTO CATEGORY (NO, NAME) VALUES (6, '切什');
INSERT INTO CATEGORY (NO, NAME) VALUES (7, '汀軒');
INSERT INTO CATEGORY (NO, NAME) VALUES (8, '奄展');
COMMIT;

-- 汽戚斗 INSERT (BOARD)
INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL, 1, '薦鯉脊艦陥111ぞぞぞ', '鎧遂脊艦陥1', 0);
INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL, 3, '薦鯉脊艦陥21ぞぞぞ', '鎧遂脊艦陥2', 0);
INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL, 6, '薦鯉脊艦陥41ぞぞぞ', '鎧遂脊艦陥3', 0);
INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL, 1, '薦鯉脊艦陥111ぞぞぞ', '鎧遂脊艦陥4', 0);
INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL, 3, '薦鯉脊艦陥21ぞぞぞ', '鎧遂脊艦陥5', 0);
INSERT INTO BOARD (NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL, 6, '薦鯉脊艦陥41ぞぞぞ', '鎧遂脊艦陥6', 0);

-- 汽戚斗 INSERT (GALLERY)
-- 汽戚斗 (GALLERY)
INSERT INTO GALLERY ( NO ,TITLE ,WRITER_NO ) VALUES ( SEQ_GALLERY_NO.NEXTVAL , '斡君軒薦鯉01' , 0 );
INSERT INTO GALLERY ( NO ,TITLE ,WRITER_NO ) VALUES ( SEQ_GALLERY_NO.NEXTVAL , '斡君軒薦鯉02' , 0 );
INSERT INTO GALLERY ( NO ,TITLE ,WRITER_NO ) VALUES ( SEQ_GALLERY_NO.NEXTVAL , '斡君軒薦鯉03' , 0 );
INSERT INTO GALLERY ( NO ,TITLE ,WRITER_NO ) VALUES ( SEQ_GALLERY_NO.NEXTVAL , '斡君軒薦鯉04' , 0 );
INSERT INTO GALLERY ( NO ,TITLE ,WRITER_NO ) VALUES ( SEQ_GALLERY_NO.NEXTVAL , '斡君軒薦鯉05' , 0 );
INSERT INTO GALLERY ( NO ,TITLE ,WRITER_NO ) VALUES ( SEQ_GALLERY_NO.NEXTVAL , '斡君軒薦鯉06' , 0 );
COMMIT;

-- 汽戚斗 INSERT (ATTACHMENT)
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 1 , '歎採督析1.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'Y');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 1 , '歎採督析2.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'N');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 2 , '歎採督析3.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'Y');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 2 , '歎採督析4.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'N');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 3 , '歎採督析5.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'Y');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 3 , '歎採督析6.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'N');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 4 , '歎採督析7.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'Y');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 4 , '歎採督析8.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'N');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 5 , '歎採督析9.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'Y');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 5 , '歎採督析10.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'N');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 6 , '歎採督析11.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'Y');
INSERT INTO ATTACHMENT ( NO ,REF_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMBNAIL_YN ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL , 6 , '歎採督析12.PNG' , '叔薦煽舌吉督析誤' , '督析井稽', 'N');
COMMIT;

-- 汽戚斗 (REPLY)
INSERT INTO REPLY(NO, REF_NO, CONTENT, WRITER_NO) VALUES(SEQ_REPLY_NO.NEXTVAL, 1, '奇越鎧遂せせせ1', 0);
INSERT INTO REPLY(NO, REF_NO, CONTENT, WRITER_NO) VALUES(SEQ_REPLY_NO.NEXTVAL, 1, '奇越鎧遂せせせ2', 0);
INSERT INTO REPLY(NO, REF_NO, CONTENT, WRITER_NO) VALUES(SEQ_REPLY_NO.NEXTVAL, 1, '奇越鎧遂せせせ3', 0);
INSERT INTO REPLY(NO, REF_NO, CONTENT, WRITER_NO) VALUES(SEQ_REPLY_NO.NEXTVAL, 1, '奇越鎧遂せせせ4', 0);
INSERT INTO REPLY(NO, REF_NO, CONTENT, WRITER_NO) VALUES(SEQ_REPLY_NO.NEXTVAL, 1, '奇越鎧遂せせせ5', 0);
COMMIT;


--SELECT * FROM BOARD;
SELECT 
    B.NO
    , B.CATEGORY_NO
    , B.TITLE
    , B.CONTENT
    , B.WRITER_NO
    , B.HIT
    , B.ENROLL_DATE
    , B.MODIFY_DATE
    , B.STATUS
    , M.NICK
FROM BOARD B
JOIN MEMBER M ON M.NO = B.WRITER_NO
WHERE B.STATUS = 'O' 
ORDER BY B.NO DESC;
SELECT B.NO , B.CATEGORY_NO , B.TITLE , B.CONTENT , B.WRITER_NO , B.HIT , B.ENROLL_DATE , B.MODIFY_DATE , B.STATUS , M.NICK FROM BOARD B JOIN MEMBER M ON M.NO = B.WRITER_NO WHERE B.STATUS = 'O' ORDER BY B.NO DESC;

SELECT 
    G.NO AS GALLERY_NO
    , G.TITLE
    , G.WRITER_NO
    , G.HIT
    , G.ENROLL_DATE
    , G.MODIFY_DATE
    , G.STATUS
    , A.NO AS ATTACHMENT_NO
    , A.REF_NO
    , A.ORIGIN_NAME
    , A.CHANGE_NAME
    , A.FILE_PATH
    , M.NICK AS WRITER_NICK
FROM GALLERY G
JOIN MEMBER M ON G.WRITER_NO = M.NO
JOIN ATTACHMENT A ON G.NO = A.REF_NO
WHERE G.STATUS = 'O'
ORDER BY G.NO DESC;

-- 奇越 鯉系 繕噺
SELECT 
    NO
    ,REF_NO
    ,CONTENT
    ,WRITER_NO
    ,ENROLL_DATE
    ,STATUS
FROM REPLY
WHERE REF_NO = 1
AND STATUS = 'O'
ORDER BY NO DESC
;

-- 奇越 拙失
INSERT INTO REPLY
(
    NO
    ,REF_NO
    ,CONTENT
    ,WRITER_NO
)
VALUES
(
    SEQ_REPLY_NO.NEXTVAL
    , 惟獣越腰硲
    , 鎧遂
    , 拙失切腰硲
)
;















