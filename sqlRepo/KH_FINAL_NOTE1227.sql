------------------------------------------------
-- ���
------------------------------------------------


-- MEMBER --------------------------------------
-- ȸ������
INSERT INTO MEMBER(NO, ID, PWD, NICK)
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01', '1234', '�г���1');
ROLLBACK;

-- �α���
SELECT
    NO
    , ID
    , PWD
    , NICK
    , ENROLL_DATE
    , DEL_YN
FROM MEMBER WHERE ID = ? 
AND PWD = ?
AND DEL_YN = 'N';

-- ȸ����������(��й�ȣ, �г���)<<<<<<<<<<<

-- ȸ��Ż��
UPDATE MEMBER
    SET DEL_YN = 'Y'
WHERE ID = ?
AND PWD = ?;

-- ��ü ȸ�� ��� ��ȸ (����������)
SELECT 
    NO
    , ID
    , PWD
    , NICK
    , ENROLL_DATE
    , DEL_YN
FROM MEMBER
WHERE DEL_YN = 'N'
ORDER BY NO DESC;
-- BOARD --------------------------------------
-- �Խñ� �ۼ�
INSERT INTO BOARD(NO, TITLE, CONTENT, ENROLL_DATE, WRITER_NO) 
VALUES(SEQ_BOARD_NO.NEXTVAL, ?, ?, SYSDATE, ?);

-- �Խñ� ��� ��ȸ
SELECT * FROM BOARD;

-- �Խñ� �� ��ȸ (�� ��ȣ)
SELECT * FROM BOARD WHERE NO = ?;

-- �Խñ� ���� (����) <<<<<<<<<<<<<<<<<<<<<<<

-- �Խñ� ���� (�� ��ȣ)
UPDATE BOARD
    SET DEL_YN = 'Y'
WHERE NO = ?;

-- �Խñ� �˻� (����, ����, �ۼ���) <<<<<<<<<<<<<
