--�� ���б� ��ũ�� ����
--SQL01_SELECT(Basic)
SELECT * FROM TB_CLASS;
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_STUDENT;
-- 1��
-- �� ������б��� �а� �̸��� �迭�� ǥ���Ͻÿ�. ��, ��� ����� "�а� ��", "�迭"���� ǥ���ϵ��� �Ѵ�.
SELECT DISTINCT DEPARTMENT_NAME AS "�а� ��", CATEGORY AS "�迭"
FROM TB_DEPARTMENT;

-- 2��
-- �а��� �а� ������ ������ ���� ���·� ȭ�鿡 ����Ѵ�.
/* EX )
    ������а��� ������ 20�� �Դϴ�.
    ������а��� ������ 36�� �Դϴ�.
    ...
*/
--SELECT CONCAT(CONCAT(CONCAT(DEPARTMENT_NAME, '�� ������ '), CAPACITY), '�� �Դϴ�.')
SELECT DEPARTMENT_NAME || '�� ������ ' || CAPACITY || '�� �Դϴ�.'
FROM TB_DEPARTMENT;

-- 3��
-- "������а�" �� �ٴϴ� ���л� �� ���� �������� ���л��� ã�ƴ޶�� ��û�� ���Դ�. �����ΰ�?
-- (�����а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ� ã�� ������ ����)
--TB_DEPARTMENT�� DEPARTMENT_NO�� 001�̰� ��Ʃ��Ʈ���� 001�� ��Ʃ��ƮSSN�� ���ڸ����۹�ȣ�� 2�� ABSENCE_YN�� N�� �л�ã��

SELECT TB_DEPARTMENT.DEPARTMENT_NO AS �а��ڵ�, TB_STUDENT.*
FROM TB_STUDENT
LEFT JOIN TB_DEPARTMENT ON TB_STUDENT.DEPARTMENT_NO = TB_DEPARTMENT.DEPARTMENT_NO
WHERE TB_STUDENT.DEPARTMENT_NO = 001
AND SUBSTR(STUDENT_SSN, 8, 1) = '2'
AND TB_STUDENT.ABSENCE_YN = 'Y';
                     
-- 4�� 
-- ���������� ���� ���� ��� ��ü�ڵ��� ã�� �̸��� �Խ��ϰ��� �Ѵ�.
-- �� ����ڵ��� �й��� ������ ���� �� ����ڵ��� ã�� ������ SQL������ �ۼ��Ͻÿ�.
-- A513079, A513090, A513091, A513110, A513119
-- (�̸� ���� �������� ����)
SELECT *
FROM TB_STUDENT
WHERE STUDENT_NO IN('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
ORDER BY STUDENT_NAME DESC;

-- 5��
-- ���� ������ 20�� �̻� 30�� ������ �а����� �а� �̸��� �迭�� ����Ͻÿ�.
SELECT DEPARTMENT_NAME, CATEGORY, CAPACITY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6��
-- �� ������б��� ������ �����ϰ� ��� �������� �Ҽ� �а��� ������ �ִ�.
-- �׷� �� ������б� ������ �̸��� �˾Ƴ� �� �ִ� SQL ������ �ۼ��Ͻÿ�.
SELECT * 
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7��
-- Ȥ�� ������� ������ �а��� �����Ǿ� ���� ���� �л��� �ִ��� Ȯ���ϰ��� �Ѵ�.
-- ��� SQL������ ����ϸ� �� ������ �ۼ��Ͻÿ�.
-- (SELECT STUDENT_NAME � ����) 
SELECT * 
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;

-- 8��
-- ������û�� �Ϸ��� �Ѵ�. �������� ���θ� Ȯ���ؾ� �ϴµ�, ���������� �����ϴ� ������� � �������� ���� ��ȣ�� ��ȸ�� ���ÿ�.
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9��
-- �� ���п��� � �迭(CATEGORY)���� �ִ��� ��ȸ�� ���ÿ�.
SELECT DISTINCT CATEGORY 
FROM TB_DEPARTMENT;

-- 10��
-- 02�й� ���� �����ڵ��� ������ ������� �Ѵ�. 
-- ������ ������� ������ �������� �л����� 
-- �й�, �̸�, �ֹι�ȣ�� ����ϴ� ������ �ۼ��Ͻÿ�.
SELECT TO_CHAR(ENTRANCE_DATE, 'RR"�й�"') AS �й�, STUDENT_NAME, STUDENT_SSN, STUDENT_ADDRESS, ABSENCE_YN
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) = 2002
AND STUDENT_ADDRESS LIKE '����%'
AND ABSENCE_YN = 'N';









