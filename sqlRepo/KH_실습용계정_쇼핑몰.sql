-- ���θ�

/*
    ������ ��� : 
    <����>
        - ȸ������
        - �α���
        - ��й�ȣ ����
        - Ż���ϱ�
        
        - ��ü ��ǰ ��ȸ
        - Ư�� ��ǰ �˻�
    
    <�Ǹ���>
        - ��ǰ ���
        - ��ǰ ���� ����
        - ��ǰ ����
    
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

-- ȸ������
INSERT INTO MEMBER(ID, PWD, NICK, ENROLL_DATE) VALUES ('�����Է�ID', '�����Է�PWD', '�����Է�NICK', SYSDATE);
-- �α���
SELECT * FROM MEMBER WHERE ID = '�����Է�ID' AND PWD = '�����Է�PWD';
-- ��й�ȣ ����
UPDATE MEMBER 
SET PWD = '�����Է� �űԺ�й�ȣ' -- SC.NEXTLINE();
WHERE ID = '�����Է�ID' AND PWD = '�����Է�PWD';  -- ���̵� OOO�� ����� ������
-- Ż��
DELETE MEMBER WHERE ID = '�����Է�ID' AND PWD = '�����Է�PWD';

-- ��ǰ ���
INSERT INTO ITEM(NAME, PRICE, CNT, ENROLL_DATE) VALUES ('�����Է�NAME', '�����Է�PRICE', '�����Է�CNT', SYSDATE);
-- ��ǰ���� ����
UPDATE ITEM 
SET PRICE = '�����Է� ����'
    , CNT = '�����Է� ����'
WHERE NAME = 'NAME';
-- ��ǰ ����
DELETE ITEM WHERE NAME = '������ ��ǰ��';
-- ��� ��ǰ ��ȸ (�ֽŵ�ϼ�)
SELECT * 
FROM ITEM 
ORDER BY ENROLL_DATE ASC;














