-- JOIN

/*
<JOIN>
�� ���� �̻��� ���̺��� �����͸� ��ȸ�ϰ��� �� �� ����ϴ� �����̴�.
        
1. � ����(EQUAL JOIN) / ���� ����(INNER JOIN)
    �����Ű�� Į���� ���� ��ġ�ϴ� ��鸸 ���εǼ� ��ȸ�Ѵ�.(��ġ�ϴ� ���� ���� ���� ��ȸ X)
    
    1) ����Ŭ ���� ����
        [ǥ����]
            SELECT Į��, Į��, ...
            FROM ���̺�1, ���̺�2
            WHERE ���̺�1.Į���� = ���̺�2.Į����;
        
        - FROM ���� ��ȸ�ϰ��� �ϴ� ���̺���� �޸�(,)�� �����Ͽ� �����Ѵ�.
        - WHERE ���� ��Ī ��ų Į���� ���� ������ �����Ѵ�.
    
    2) ANSI ǥ�� ����
        [ǥ����]
            SELECT Į��, Į��, ...
            FROM ���̺�1
            [INNER] JOIN ���̺�2 ON (���̺�1.Į���� = ���̺�2.Į����);
        
        - FROM ���� ������ �Ǵ� ���̺��� ����Ѵ�.
        - JOIN ���� ���� ��ȸ�ϰ��� �ϴ� ���̺��� ��� �� ��Ī ��ų Į���� ���� ������ ����Ѵ�.
        - ���ῡ ����Ϸ��� Į������ ���� ��� ON ���� ��ſ� USING(Į����) ������ ����Ѵ�.
*/

-- �����, �μ��ڵ� ��ȸ
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE, DEPT_ID
FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

-- �����, �����ڵ�, ���޸� ��ȸ
SELECT EMP_NAME, E.JOB_CODE, JOB_NAME  
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE = J.JOB_CODE;

-- NATURAL JOIN
SELECT EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

/*
    2. ���� JOIN
    ���� ���� ���̺� �����ϴ� ��쿡 ����Ѵ�.
*/
-- ��� �̸�, �μ��ڵ�, �μ���, �����ڵ�
SELECT EMP_NAME, DEPT_CODE, DEPT_TITLE, NATIONAL_CODE
FROM EMPLOYEE
JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID 
JOIN LOCATION ON LOCATION_ID = LOCAL_CODE;

/*
    3. �ܺ� ���� (OUTTER JOIN)
    ���̺� ���� JOIN �� ��ġ���� �ʴ� �൵ ���Խ��Ѽ� ��ȸ�� �����ϴ�.
    ��, �ݵ�� �����̵Ǵ� ���̺�(�÷�)�� �����ؾ� �Ѵ�. (LEFT/RIGHT/(+))
*/
-- �����, �μ��̸�
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT OUTER JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

/*
    4. ī�׽þȰ�(CARTESIAN PRODUCT) / ���� ����(CROSS JOIN)
    ���εǴ� ��� ���̺��� �� ����� ���μ��� ��� ���ε� �����Ͱ� �˻��ȴ�.
    ���̺��� ����� ��� ������ ����� ������ ��� -> �������� ����
*/
-- �μ��̸�, �����ڵ�
SELECT DEPT_TITLE, NATIONAL_CODE
FROM DEPARTMENT
CROSS JOIN LOCATION;

/*
    5. �� ����(NON EQUAL JOIN)
    ���� ���ǿ� ��ȣ(=)�� ������� �ʴ� ���ι��� �� �����̶�� �Ѵ�.
    ������ �÷� ���� ��ġ�ϴ� ��찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ����̴�.
    ( = �̿ܿ� �� ������ >, <, >=, <=, BETWEEN AND, IN, NOT IN ���� ����Ѵ�.)
    
    -- ANSI �������δ� JOIN ON �������θ� ����� �����ϴ�. (USING ��� �Ұ�)
*/
-- �����, �޿�, �޿����
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON SALARY >= MIN_SAL AND SALARY <= MAX_SAL;

/*
    6. ��ü ����(SELF JOIN)
    ���� ���̺��� �ٽ� �ѹ� �����ϴ� ��쿡 ����Ѵ�.
*/
-- �����ȣ, �����, �����ȣ, �����
SELECT 
    A.EMP_ID AS �����ȣ
    , A.EMP_NAME AS ����̸�
    , A.MANAGER_ID AS �����ȣ
    , NVL(B.EMP_NAME, '�������') AS ����̸�
FROM EMPLOYEE A
LEFT OUTER JOIN EMPLOYEE B ON A.MANAGER_ID = B.EMP_ID
ORDER BY A.EMP_ID;

--------------------------------------------------------------------------------
-- 1. DEPARTMENT ���̺�� LOCATION ���̺��� �����Ͽ� �μ� �ڵ�, �μ���, ���� �ڵ�, �������� ��ȸ
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;

SELECT 
    D.DEPT_ID
    , D.DEPT_TITLE
    , L.LOCAL_CODE
    , L.NATIONAL_CODE
    , L.LOCAL_NAME
FROM DEPARTMENT D
JOIN LOCATION L ON D.LOCATION_ID = L.LOCAL_CODE;

-- 2. EMPLOYEE ���̺�� DEPARTMENT ���̺��� �����ؼ� ���ʽ��� �޴� ������� ���, �����, ���ʽ�, �μ����� ��ȸ
SELECT E.EMP_ID, E.EMP_NAME, E.BONUS, D.DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
WHERE BONUS IS NOT NULL;

-- 3. EMPLOYEE ���̺�� DEPARTMENT ���̺��� �����ؼ� �λ�����ΰ� �ƴ� ������� �����, �μ���, �޿��� ��ȸ
SELECT
    E.EMP_NAME
    , D.DEPT_TITLE
    , E.SALARY
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
--WHERE NOT(D.DEPT_TITLE = '�λ������')
WHERE D.DEPT_TITLE != '�λ������'
;

-- 4. EMPLOYEE ���̺�, DEPARTMENT ���̺�, LOCATION ���̺��� �����ؼ� ���, �����, �μ���, ������ ��ȸ
SELECT 
    E.EMP_ID
    , E.EMP_NAME
    , D.DEPT_TITLE
    , L.LOCAL_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
LEFT JOIN LOCATION L ON L.LOCAL_CODE = D.LOCATION_ID
;

-- 5. ���, �����, �μ���, ������, ������ ��ȸ
SELECT
    E.EMP_ID AS ���
    , E.EMP_NAME AS �����
    , D.DEPT_TITLE AS �μ���
    , L.LOCAL_NAME AS ������
    , N.NATIONAL_NAME AS ������
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
LEFT JOIN LOCATION L ON L.LOCAL_CODE = D.LOCATION_ID
LEFT JOIN NATIONAL N ON L.NATIONAL_CODE = N.NATIONAL_CODE
;

-- 6. ���, �����, �μ���, ������, ������, �޿� ��� ��ȸ
SELECT
    E.EMP_ID AS ���
    , E.EMP_NAME AS �����
    , D.DEPT_TITLE AS �μ���
    , L.LOCAL_NAME AS ������
    , N.NATIONAL_NAME AS ������
    , S.SAL_LEVEL AS �޿����
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
LEFT JOIN LOCATION L ON L.LOCAL_CODE = D.LOCATION_ID
LEFT JOIN NATIONAL N ON L.NATIONAL_CODE = N.NATIONAL_CODE
LEFT JOIN SAL_GRADE S ON E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL
;

------------------------- ���� �ǽ� ���� -------------------------
-- 1. ������ �븮�̸鼭 ASIA �������� �ٹ��ϴ� �������� ���EMP_ID, �����EMP_NAME, ���޸�JOB JOB_NAME, �μ���DEPARTMENT DEPT_TITLE, �ٹ�����DEPARTMENT LOCATION_ID, �޿�SALARY�� ��ȸ�ϼ���.
SELECT 
    E.EMP_ID AS ���
    , E.EMP_NAME AS �����
    , J.JOB_NAME AS ���޸�
    , D.DEPT_TITLE AS �μ���
    , D.LOCATION_ID AS �ٹ�����
    , E.SALARY AS �޿�
FROM EMPLOYEE E
JOIN JOB J ON J.JOB_CODE = E.DEPT_CODE
JOIN DEPARTMENT D ON D.DEPT_ID = E.DEPT_CODE
JOIN NATIONAL N ON N.NATIONAL_CODE = D.LOCATION_ID
WHERE JOB_NAME = '�븮'
AND N.NATIONAL_NAME = 'ASIA';

-- 2. 70���� �̸鼭 �����̰�, ���� �� ���� �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�ϼ���.

-- 3. ���ʽ��� �޴� �������� �����, ���ʽ�, ����, �μ���, �ٹ������� ��ȸ�ϼ���.

-- 4. �ѱ��� �Ϻ����� �ٹ��ϴ� �������� �����, �μ���, �ٹ�����, �ٹ� ������ ��ȸ�ϼ���.

-- 5. �� �μ��� ��� �޿��� ��ȸ�Ͽ� �μ���, ��� �޿�(���� ó��)�� ��ȸ�ϼ���.

-- 6. �� �μ��� �� �޿��� ���� 1000���� �̻��� �μ���, �޿��� ���� ��ȸ�Ͻÿ�.

-- 7. ���, �����, ���޸�, �޿� ���, �������θ� ��ȸ

-- 8. ���ʽ��� ���� �ʴ� ������ �� ���� �ڵ尡 J4 �Ǵ� J7�� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�.

-- 9. �μ��� �ִ� �������� �����, ���޸�, �μ���, �ٹ� ������ ��ȸ�Ͻÿ�.

-- 10. �ؿܿ������� �ٹ��ϴ� �������� �����, ���޸�, �μ� �ڵ�, �μ����� ��ȸ�Ͻÿ�

-- 11. �̸��� '��'�ڰ� ����ִ� �������� ���, �����, ���޸��� ��ȸ�Ͻÿ�.






















