-- DDL
/*
<DDL(Data Definition Language)>
    ������ ���� ���� ����Ŭ���� �����ϴ� ��ü�� �����(CREATE), �����ϰ�(ALTER), �����ϴ�(DROP) ��
    ���� ������ ���� �ƴ� �������� ���� ��ü�� �����ϴ� ���� DB ������, �����ڰ� �ַ� ����Ѵ�.

    * ����Ŭ������ ��ü : ���̺�, ��, ������, �ε���, Ʈ����, ���ν���, �Լ�, ����� ���
    
<CREATE>
    �����ͺ��̽��� ��ü�� �����ϴ� �����̴�.

<TABLE(���̺�)>
    ���̺��� ��� ���� �����Ǵ� ���� �⺻���� �����ͺ��̽� ��ü�� �����ͺ��̽� ������ ��� �����ʹ� ���̺��� ����ȴ�.
    
<���̺� ����>
    [����]
    CREATE TABLE ���̺��� (
        Į���� �ڷ���(ũ��) [DEFAULT �⺻��] [��������],
        Į���� �ڷ���(ũ��) [DEFAULT �⺻��] [��������],
        ...
    );
*/

DROP TABLE MEMBER;
--CREATE TABLE MEMBER(
--    NO               NUMBER        PRIMARY KEY
--    , ID             VARCHAR2(100) NOT NULL UNIQUE
--    , PWD            VARCHAR2(100) NOT NULL
--    , NICK           VARCHAR2(100)
--    , ENROLL_DATE    TIMESTAMP     DEFAULT SYSDATE
--    , QUIT_YN        CHAR(1)       CHECK(QUIT_YN IN('Y', 'N'))
--);
CREATE TABLE MEMBER(
    NO               NUMBER        --PRIMARY KEY
    , ID             VARCHAR2(100) --NOT NULL UNIQUE
    , PWD            VARCHAR2(100) --CONSTRAINT �����ڵ�00123�н����峴�� NOT NULL
    , NICK           VARCHAR2(100)
    , ENROLL_DATE    TIMESTAMP     --DEFAULT SYSDATE
    , QUIT_YN        CHAR(1)       --CHECK(QUIT_YN IN('Y', 'N'))
    -- , NOT NULL(ID) -- NOT NULL ���������� ���̺� �������� ���� �Ұ���
    , UNIQUE(ID)
    , CHECK(QUIT_YN IN ('Y', 'N'))
    , PRIMARY KEY(ID)
    , FOREIGN KEY
);

SELECT * FROM MEMBER;
DESC MEMBER;

/*
    <Į���� �ּ� �ޱ�>
        [����]
            COMMENT ON COLUMN ���̺���.Į���� IS '�ּ�����';
*/
COMMENT ON COLUMN MEMBER.ID IS 'ȸ�����̵�';
COMMENT ON COLUMN MEMBER.PWD IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.NICK IS '�г���';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '�����Ͻ�';

/*
    ������ ��ųʸ�(��Ÿ ������)
        �ڿ��� ȿ�������� �����ϱ� ���� �پ��� ��ü���� ������ �����ϴ� �ý��� ���̺��̴�.
        ����ڰ� ��ü�� �����ϰų� ��ü�� �����ϴ� ���� �۾��� �� �� �����ͺ��̽��� ���ؼ� �ڵ����� ���ŵǴ� ���̺��̴�.
        �����Ϳ� ���� �����Ͱ� ����Ǿ� �ִٰ� �ؼ� ��Ÿ �����Ͷ���� �Ѵ�.
        
    USER_TABLES         : ����ڰ� ������ �ִ� ���̺����� �������� ������ Ȯ���ϴ� �� ���̺��̴�. 
    USER_TAB_COLUMNS    : ���̺�, ���� Į���� ���õ� ������ ��ȸ�ϴ� �� ���̺��̴�.
*/
SELECT * FROM USER_TABLES;

INSERT INTO MEMBER(ID, PWD, NICK, ENROLL_DATE) VALUES('USER01', '1234', 'NICK01', SYSDATE);
INSERT INTO MEMBER VALUES('USER02', '1234', 'NICK02', SYSDATE);
INSERT INTO MEMBER(ID, PWD, NICK) VALUES('USER01', '1234', NULL);
INSERT INTO MEMBER(ID, PWD, NICK, ENROLL_DATE) VALUES('USER02', '1234', NULL, NULL);
INSERT INTO MEMBER(ID, PWD, NICK, ENROLL_DATE) VALUES('USER03', '1234', NULL, DEFAULT);
INSERT INTO MEMBER(NO, ID, PWD, NICK, ENROLL_DATE) VALUES('', 'USER03', '1234', NULL, DEFAULT);

SELECT * FROM MEMBER;

COMMIT;

SHOW AUTOCOMMIT;

SET AUTOCOMMIT ON;

/*
    <���� ����(CONSTRAINT)>
    ����ڰ� ���ϴ� ������ �����͸� �����ϱ� ���ؼ� ���̺� �ۼ� �� �� Į���� ���� ����� ���� ���� ���������� ������ �� �ִ�.
    ���� ������ ������ ���Ἲ ������ �������� �Ѵ�. (�������� ��Ȯ���� �ϰ����� ������Ű�� ��)
    
    * ���� : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
    
    [����]
    1) Į�� ����
        CRATE TABLE ���̺��� (
            Į���� �ڷ���(ũ��) [CONSTRAINT �������Ǹ�] ��������,
            ...
        );
    
    2) ���̺� ����
        CRATE TABLE ���̺��� (
            Į���� �ڷ���(ũ��),
            ...,
            [CONSTRAINT �������Ǹ�] ��������(Į����)
        );
*/
DROP TABLE SCORE;
CREATE TABLE SCORE(
    MEMBER_NO NUMBER
    , GRADE CHAR(1)
    , FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER(NO)
);

SELECT * FROM SCORE;
SELECT * FROM MEMBER;

INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(1, 'USER01', '1234', 'NICK01');

INSERT INTO SCORE(MEMBER_NO, GRADE) VALUES(1, 'A');
INSERT INTO SCORE(MEMBER_NO, GRADE) VALUES(NULL, 'A');

ON DELETE SET NULL
ON DELETE CASCADE














