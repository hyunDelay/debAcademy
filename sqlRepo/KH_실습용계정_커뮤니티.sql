-- Ŀ�´�Ƽ

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    NO NUMBER
    , ID VARCHAR2(100)
    , PWD VARCHAR2(100)
    , NICK VARCHAR2(100)
    , ENROLL_DATE TIMESTAMP
    , QUIT_YN CHAR(1)
);


-- ȸ������
INSERT INTO MEMBER(NO, ID, NICK, ENROLL_DATE, QUIT_YN) VALUES ('1', '�����Է�ID', '�����Է�PWD', '�����Է�NICK', SYSDATE, 'N');
-- �α���
SELECT * FROM MEMBER WHERE ID = '�����Է�ID' AND PWD = '�����Է�PWD';
-- �������
UPDATE MEMBER 
SET PWD = '�����Է� �űԺ�й�ȣ'
WHERE ID = '�����Է�ID' AND PWD = '�����Է�PWD';
-- �г��� ����
UPDATE MEMBER 
SET NICK = '�����Է� �ٲ� �г���'
WHERE PWD = '�����Է�PWD';
-- Ż��
DELETE MEMBER WHERE ID = '�����Է�ID' AND PWD = '�����Է�PWD';
-- ���������� ��ȸ
SELECT * FROM MEMBER WHERE ID = �α��ξ��̵�;


DROP TABLE BOARD;
CREATE TABLE BOARD(
    NO NUMBER
    , TITLE VARCHAR2(100)
    , CONTENT VARCHAR2(4000)
    , WRITER VARCHAR2(100)
    , ENROLL_DATE TIMESTAMP
    , DEL_YN CHAR(1)
);

-- �Խñ� �ۼ�
INSERT INTO BOARD(NO, TITLE, WRITER, CONTENT, ENROLL_DATE, DEL_YN) 
VALUES ('2', '�����Է�', '�ۼ���', '������ �Է��մϴ�.', SYSDATE, 'N');
-- �Խñ� ��ü ��� ��ȸ (�Խñ� ����, �ۼ��Ͻ�, �ۼ���)
SELECT TITLE, TO_CHAR(ENROLL_DATE, 'YYYY-MM-DD') �ۼ���, WRITER
FROM BOARD;
-- �Խñ� ����ȸ
SELECT TITLE, CONTENT, ENROLL_DATE, WRITER
FROM BOARD
WHERE NO = '1';
-- �Խñ� ���� �� ���� ����
UPDATE BOARD 
SET TITLE = '���� �ٲߴϴ�.'
    , CONTENT = '���뺯���մϴ�'
WHERE NAME = 'NAME';
-- �Խñ� ����
DELETE BOARD WHERE WRITER = '�α��ε� �ۼ���';
