---------------------------
-- 기능
---------------------------


--------------------------------- <MEMBER> ---------------------------------
-- 회원가입
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

-- 로그인
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

-- 회원 정보 수정 (비밀번호, 닉네임) <<<<<<<<<<<<<<<<

-- 회원 탈퇴
UPDATE MEMBER
    SET 
        DEL_YN = 'Y'
WHERE NO = 1
;
rollback;

-- 전체 회원 목록 조회 (관리자 전용)
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
-- 게시글 작성
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

-- 게시글 목록 조회
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

-- 게시글 상세 조회 (글 번호)
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
-- 게시글 수정 (제목,내용) <<<<<<<<<<<<<<<<<<<<<<<<<<<

-- 게시글 삭제 (글 번호)
UPDATE BOARD
    SET DEL_YN = 'Y'
WHERE NO = ?
;

-- 게시글 검색 (제목,내용,작성자) <<<<<<<<<<<<<<<<<<<<<<

