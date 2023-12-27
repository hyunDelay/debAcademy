---------------------------
-- ���
---------------------------


--------------------------------- <MEMBER> ---------------------------------
-- ȸ������
INSERT INTO MEMBER
(
    NO
    ,ID
    ,PWD
    ,NICK
)
VALUES
(
    SEQ_MEMBER_NO.NEXTVAL
    , ?
    , ?
    , ?
)
;

-- �α���
SELECT
    NO
    ,ID
    ,PWD
    ,NICK
    ,ENROLL_DATE
    ,DEL_YN
FROM MEMBER
WHERE ID = ?
AND PWD = ?
;

-- ȸ�� ���� ���� (��й�ȣ, �г���) <<<<<<<<<<<<<<<<

-- ȸ�� Ż��
UPDATE MEMBER
    SET 
        DEL_YN = 'Y'
WHERE NO = 1
;
rollback;

-- ��ü ȸ�� ��� ��ȸ (������ ����)
SELECT
    NO
    ,ID
    ,PWD
    ,NICK
    ,ENROLL_DATE
    ,DEL_YN
FROM MEMBER
WHERE DEL_YN = 'N'
ORDER BY NO DESC
;

select * from member;
--------------------------------- <BOARD> ---------------------------------
-- �Խñ� �ۼ�
INSERT INTO BOARD
(
    NO
    ,TITLE
    ,CONTENT
    ,WRITER_NO
)
VALUES
(
    SEQ_BOARD_NO.NEXTVAL
    , ?
    , ?
    , ?
)
;

-- �Խñ� ��� ��ȸ
SELECT 
    NO
    ,TITLE
    ,CONTENT
    ,ENROLL_DATE
    ,DEL_YN
    ,WRITER_NO
FROM BOARD
WHERE DEL_YN = 'N'
ORDER BY NO DESC
;

-- �Խñ� �� ��ȸ (�� ��ȣ)
SELECT 
    NO
    ,TITLE
    ,CONTENT
    ,ENROLL_DATE
    ,DEL_YN
    ,WRITER_NO
FROM BOARD
WHERE NO = ?
AND DEL_YN = 'N'
;
-- �Խñ� ���� (����,����) <<<<<<<<<<<<<<<<<<<<<<<<<<<

-- �Խñ� ���� (�� ��ȣ)
UPDATE BOARD
    SET DEL_YN = 'Y'
WHERE NO = ?
;

-- �Խñ� �˻� (����,����,�ۼ���) <<<<<<<<<<<<<<<<<<<<<<

