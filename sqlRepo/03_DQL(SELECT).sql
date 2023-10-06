-- DQL (SELECT)
/*
    DQL : Data Query Language == SELECT
    <SELECT>
        [����]
            SELECT Į��1, Į��2...
            FORM ���̺��;
            
        - �����͸� ��ȸ �� �� ���
        - ��ȸ�� ����� RESULT SET (�������) ���� ǥ��.
        - ���̺� ���� Į���� ��ȸ�ϸ� �ȵȴ�.
*/

-- EMPLOYEE ���̺��� ��ü ����� ���(EMP_ID), �̸�(EMP_NAME), ����(SALARY)�� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ��ü ����� ��� �÷�(*) ���� ��ȸ
SELECT *
FROM EMPLOYEE;

-- ������ ��ҹ��� ��� X

/*
    <�������>
    SELECT ������ ��� ���� ����
*/

-- �̸�, ���� ��ȸ
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- ���ʽ� �����ؼ� ��ȸ
-- ������� ��, NULL���� �����ϸ� ������� ������ NULL
SELECT EMP_NAME, SALARY * 12 + SALARY * BONUS
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ������, �Ի���(HIRE_DATE), �ٹ��ϼ�(���� ��¥ - �Ի���) ��ȸ
-- DATE ���� �� ���� ����
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE �ٹ�_�ϼ� -- ��Ī�ο� "�ٹ� �ϼ�"�ϸ� ���� ����
FROM EMPLOYEE;

-- Į���� ��Ī (AS)

/*
    <���ͷ�>
        SELECT ������ ���ͷ��� ��� ����
*/
SELECT EMP_NAME, EMAIL, 123, 'ABC'
FROM EMPLOYEE;

-- [����] ��� ���̺��� ��� ����� ��� ���� ��ȸ
SELECT *
FROM EMPLOYEE;

-- [����] ��� ���̺��� ��� ����� �̸�, �̸���, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, EMAIL, PHONE
FROM EMPLOYEE;

-- [����] ��� ���̺��� ��� ����� �̸�, ����, ���� ��ȸ
-- ������ ����*12�� ���, ������ȸ ����� Į�� ��Ī�� �������� ����
SELECT EMP_NAME, SALARY, SALARY * 12 AS ����
FROM EMPLOYEE;

-- [����] ��� ���̺��� ��� ����� �����ڵ�(JOB_CODE) ��ȸ
-- DISTINCT �ߺ�����
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

/*
    <DISTINCT>
        - �ߺ��� ����
        - SELECT ������ �ѹ��� ��� ����
        - Į���� ���������? ��� �����ؾ� �ߺ����� �Ǵ�
*/

-- �����ڵ� ��ȸ ( �ߺ����� )
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- �μ� �ڵ� ��ȸ ( �ߺ�����)
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- �����ڵ�, �μ��ڵ� ��ȸ ( �ߺ�����)
SELECT DISTINCT JOB_CODE, DEPT_CODE
FROM EMPLOYEE;


/*
    <���� ������>
        ���� ���� ���� ��������
        ���ͷ� ���� ���� ����
        Į���� ���ͷ��� ���� ����
*/

-- ���, �̸�, �޿� ��ȸ
-- || ���� ������
SELECT EMP_ID || '����� ���� ' || EMP_NAME || '����� �޿��� ' || SALARY || '�� �Դϴ�.'
FROM EMPLOYEE;

-------------------------------------------------------------------------------------
/*
    <WHERE>
        [����]
            SELECT Į��, ~~
            FROM ���̺��
            WHERE ���ǽ�;
        - ��ȸ�Ϸ��� ROW�� ���ǽ��� �����ؾ� ��ȸ
        - ���ǽĿ��� ������ ��� ����
*/

-- �μ��ڵ尡 D9�� �ƴ� ����� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE ^= 'D9';
-- !=, ^=, <> ���� ���� �ʴٶ�� ������ ���� �ǹ̸� ������.

-- EMPLOYEE ���̺��� �޿��� 400���� �̻��� �������� ������, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

---------------------- �ǽ� ���� ----------------------
-- 1. EMPLOYEE ���̺��� ���� ��(ENT_YN_ �÷� ���� 'N')�� �������� ���, �̸�, �Ի��� ��ȸ
SELECT EMP_ID AS ���, EMP_NAME AS �̸�, HIRE_DATE AS �Ի���, ENT_YN AS ��������
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- 2. EMPLOYEE ���̺��� ������ 5000�̻��� ������ ������, �޿�, ����, �Ի��� ��ȸ
SELECT EMP_NAME, SALARY, SALARY * 12 ����, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000;
------------------------------------------------------

-- EMPLOYEE ���̺��� �μ� �ڵ尡 D6�̸鼭 �޿��� 300���� �̻��� �������� ���, ������, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND SALARY >= 3000000;

-- EMPLOYEE ���̺��� �޿��� 400���� �̻�, ���� �ڵ尡 J2�� ����� ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000 AND JOB_CODE = 'J2';

-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������ ���, ������, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;

/*
    <BETWEEN A AND B>
    - A �̻� B ����
*/
-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���ϸ� �޴� ������ ���, ������, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE ���̺��� �޿��� 350���� �̻� 600���� ���ϰ� �ƴ� ������ ���, ������, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE SALARY NOT BETWEEN 3500000 AND 6000000;
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
-- NOT Į���� �տ��ᵵ �ǰ� �ڿ��ᵵ �ȴ�.

SELECT * FROM EMPLOYEE;
-- EMPLOYEE ���̺��� �Ի��� '90/01/01' ~ '01/01/01'�� ����� ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01'
ORDER BY HIRE_DATE;

/*
    <LIKE>
        [����]
            WHERE �񱳴���÷� LIKE 'Ư�� ����';
            
        - ���Ϸ��� �÷� ���� ������ Ư�� ���Ͽ� ������ ��� TRUE�� �����Ѵ�.
        - Ư�� ���Ͽ��� '%', '_'�� ���ϵ�ī��� ����� �� �ִ�.
          '%' : 0���� �̻�
            ex) �񱳴���÷� LIKE '����%'  => �񱳴���÷� �� �߿� '����'�� �����ϴ� ��� ���� ��ȸ�Ѵ�.
                �񱳴���÷� LIKE '%����'  => �񱳴���÷� �� �߿� '����'�� ������ ��� ���� ��ȸ�Ѵ�.
                �񱳴���÷� LIKE '%����%' => �񱳴���÷� �� �߿� '����'�� ���ԵǾ� �ִ� ��� ���� ��ȸ�Ѵ�.
                
          '_' : 1����
            ex) �񱳴���÷� LIKE '_����'  => �񱳴���÷� �� �߿� '����'�տ� ������ �� ���ڰ� ���� ��� ���� ��ȸ�Ѵ�.
                �񱳴���÷� LIKE '__����' => �񱳴���÷� �� �߿� '����'�տ� ������ �� ���ڰ� ���� ��� ���� ��ȸ�Ѵ�.
*/
-- EMPLOYEE ���̺��� ���� �� ���� ����� �����, �޿�, �Ի��� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- EMPLOYEE ���̺��� �̸� �߿� '��'�� ���Ե� ����� ��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- EMPLOYEE ���̺��� ��ȭ��ȣ 4��° �ڸ��� 9�� �����ϴ� ����� ���Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

--EMPLOYEE ���̺��� �̸��� �� _ �� ���ڰ� 3�ڸ��� �̸��� �ּҸ� ���� ����� ��� �����, �̸��� ��ȸ
-- ex) sun_di@kh.or.kr, yoo_js@kh.or.kr, ...
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

------------------- �ǽ� ���� -------------------
-- 1. EMPLOYEE ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- 2. DEPARTMENT ���̺��� �ؿܿ����ο� ���� ��� �÷� ��ȸ
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '%�ؿܿ���%';
------------------------------------------------

/*
    <IS NULL / IS NOT NULL>
    [����]
        WHERE �񱳴���÷� IS [NOT] NULL;
        
    - �÷� ���� NULL�� ���� ��� NULL �� �񱳿� ���ȴ�.
      IS NULL : �񱳴���÷� ���� NULL�� ��� TRUE�� �����Ѵ�.
      IS NOT NULL : �񱳴���÷� ���� NULL�� �ƴ� ��� TRUE �����Ѵ�.
*/ 
-- EMPLOYEE ���̺��� ���ʽ��� ���� �ʴ� ����� ���, �����, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
--WHERE BONUS = NULL -- NULL���� �񱳿��� �Ұ���
WHERE BONUS IS NULL
;

--EMPLOYEE ���̺��� ������(���)�� �ִ� ��� �̸�, �μ� �ڵ� ��ȸ 
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
;

-- �μ��� ����, ���ʽ��� �޴� ��� Į�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL
AND BONUS IS NOT NULL
;

/*
    <IN>
    [����] WHERE �񱳴���÷� IN('��', '��', '��', ..., '��');
    - �� ��� �߿� ��ġ�ϴ� ���� ���� �� TRUE �����Ѵ�.
*/
SELECT * FROM EMPLOYEE;
-- �μ��ڵ� D5, D6, D8 �� �ش��ϴ� ������� ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5', 'D6', 'D8');

/*
    <������ �켱����>
    1. ��ȣ: ( )
    2. ���� ������: + (��� ��ȣ), - (���� ��ȣ), NOT (�� NOT)
    3. ���� ������: **
    4. ���� �� ������ ������: *, /, % (������ ����)
    5. ���� �� ���� ������: +, -
    6. ���ڿ� ���� ������: ||
    7. �� ������: =, !=, <>, <, >, <=, >=, IS NULL, IS NOT NULL, LIKE, BETWEEN, IN, ��
    8. �� ������: NOT, AND, OR
    9. CASE ǥ����
*/


/*
    <ORDER BY>
     [����]
        SELECT �÷�, �÷�, ..., �÷�
          FROM ���̺��
         WHERE ���ǽ�
      ORDER BY ���Ľ�Ű���� �ϴ� �÷���|��Ī|�÷� ���� [ASC|DESC] [NULLS FIRST | NULLS LAST];
      
    - SELECT ������ ���� �������� �����ϴ� �������� ���� ���� ���� �������� ����ȴ�.
    - ASC : ������������ �����Ѵ�. (ASC �Ǵ� DESC ���� �� �⺻��)
    - DESC : ������������ �����Ѵ�.
    - NULLS FIRST : �����ϰ��� �ϴ� �÷� ���� NULL�� �ִ� ��� �ش� ������ ���� �� ������ �����Ѵ�.
    - NULLS LAST : �����ϰ��� �ϴ� �÷� ���� NULL�� �ִ� ��� �ش� ������ ���� �� �ڷ� �����Ѵ�.
*/
-- EMPLOYEE ���̺��� BONUS�� �������� ����
SELECT *
FROM EMPLOYEE
ORDER BY BONUS ASC;
-- ������ �⺻�� ���������̶� ��������, NULL�� ���������� �⺻ (NULL LAST)

-- EMPLOYEE ���̺��� BONUS�� �������� ����(��, BONUS ���� ��ġ�� ��� �׶��� SALARY ������ ������������)
SELECT *
FROM EMPLOYEE
ORDER BY BONUS DESC, SALARY ASC;

-- EMPLOYEE ���̺��� ������ ������������ ���ĵ� ����� �����, ���� ��ȸ
SELECT EMP_NAME, SALARY*12 AS "����"
FROM EMPLOYEE
ORDER BY ���� DESC;




