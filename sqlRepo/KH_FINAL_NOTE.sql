-- ����
-- �Խñ� ��� ��ȸ
SELECT * FROM BOARD;
-- �Խñ� �� ��ȸ
SELECT * FROM BOARD WHERE NO = 1;
-- �Խñ� ����
DELETE FROM BOARD WHERE NO = 1;
ROLLBACK;
-- �Խñ� ����
UPDATE BOARD
SET TITLE = '���ο� ����', CONTENT = '���ο� ����'
WHERE NO = 1;
ROLLBACK;

-- ���
-- ȸ������
INSERT INTO MEMBER(NO, ID, PWD, NICK)
VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?);

-- ȸ�� ��� ��ȸ
SELECT * FROM MEMBER;

-- ȸ�� �� ��ȸ
SELECT * FROM MEMBER WHERE NO = 1;

-- ȸ�� ����
DELETE FROM MEMBER WHERE NO = ?;
rollback;

-- ȸ�� ����
UPDATE 
SET 
    PWD = ?
    , NICK = ?
WHERE ID = ?
AND PWD = ?
;

-- ������
INSERT INTO MEMBER(NO, ID, PWD, NICK)
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01', '1234', '�г���1');
INSERT INTO MEMBER(NO, ID, PWD, NICK)
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user02', '1234', '�г���2');
INSERT INTO MEMBER(NO, ID, PWD, NICK)
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user03', '1234', '�г���3');
INSERT INTO MEMBER(NO, ID, PWD, NICK)
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user04', '1234', '�г���4');
INSERT INTO MEMBER(NO, ID, PWD, NICK)
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user05', '1234', '�г���5');
commit;
















