
-- BOARD, ADMIN ���̺� (���¹���)
CREATE TABLE BOARD (
   BOARD_NO               NUMBER              PRIMARY KEY
   ,STATION_NO            NUMBER              �ܷ�Ű
   ,USER_NO               NUMBER              �ܷ�Ű
   ,TITLE                 VARCHAR2(1000)      NOT NULL
   ,CONTENT               VARCHAR2(4000)      NOT NULL
   ,ENROLL_DATE           TIMESTAMP           DEFAULT SYSDATE
   ,MODIFY_DATE           TIMESTAMP
   ,INQUIRY               NUMBER              DEFAULT 0
   ,WRITER_NICK           VARCHAR2(100)      
   ,DELETE_YN             CHAR(1)             DEFAULT 'N' CHECK(DEL_YN IN('Y' , 'N'))   
);

CREATE TABLE ADMIN (
   ADMIN_NO           NUMBER          PRIMARY KEY
    ,ID               VARCHAR2(100)   NOT NULL UNIQUE
    ,PWD              VARCHAR2(100)   NOT NULL
    ,NICK             VARCHAR2(100)   NOT NULL
    ,EDIT_DATE        TIMESTAMP      
);

DROP SEQUENCE SEQ_ADMIN_NO;
DROP SEQUENCE SEQ_BOARD_NO;

CREATE SEQUENCE SEQ_ADMIN_NO NOCYCLE NOCACHE;
CREATE SEQUENCE SEQ_BOARD_NO NOCYCLE NOCACHE;

-- NOTICE, FAQ ���̺� (��������)
CREATE TABLE NOTICE(
    NOTICE_NO            NUMBER             PRIMARY KEY
    , STATION_NO         NUMBER             �ܷ�Ű
    , ADMIN_NO           NUMBER             �ܷ�Ű
    , POST_TIME          TIMESTAMP          DEFAULT SYSDATE
    , TITLE              VARCHAR2(4000)     NOT NULL
    , CONTENT            VARCHAR2(4000)     NOT NULL
    , INQUIRY            NUMBER             DEFAULT 0
    , DELECT_YN          CHAR(1)            DEFAULT 'N' CHECK(DEL_YN IN ('Y' , 'N'))
    , MODIFY_DATE        TIMESTAMP         
);

CREATE TABLE FAQ(
    FAQ_NO               NUMBER             PRIMARY KEY
    , STATION_NO         NUMBER             �ܷ�Ű
    , ADMIN_NO           NUMBER             �ܷ�Ű
    , FAQ_TITLE          VARCHAR2(4000)     NOT NULL
    , CONTENT            VARCHAR2(4000)     NOT NULL
    , POST_TIME          TIMESTAMP          DEFAULT SYSDATE
    , DELECT_YN          CHAR(1)            DEFAULT 'N' CHECK(DEL_YN IN ('Y' , 'N'))
    , MODIFY_DATE        TIMESTAMP
);

DROP SEQUENCE SEQ_NOTICE_NO;
DROP SEQUENCE SEQ_FAQ_NO;

CREATE SEQUENCE SEQ_NOTICE_NO NOCYCLE NOCACHE ;
CREATE SEQUENCE SEQ_FAQ_NO NOCYCLE NOCACHE ;

-- ���� ���̺� (������)
CREATE TABLE USER (
   USER_NO             NUMBER          PRIMARY KEY
    , ID               VARCHAR2(100)   NOT NULL UNIQUE
    , PWD              VARCHAR2(100)   NOT NULL
    , NICK             VARCHAR2(100)   NOT NULL
    , ENROLL_DATE      TIMESTAMP       DEFAULT SYSDATE
    , DEL_YN           CHAR(1)         DEFAULT 'N' CHECK(DEL_YN IN ('Y' , 'N'))
    , PWDEDIT_DATE     TIMESTAMP
);










