/*
    <SUBQUERY>
    �ϳ��� SQL �� �ȿ� ���Ե� �� �ٸ� SQL ���� ���Ѵ�. 
    ���� ����(���� ����)�� �����ϴ� ������ �ϴ� �������̴�.
*/
SELECT *
FROM (SELECT * FROM EMPLOYEE);

SELECT (SELECT 10 FROM DUAL) + 20
FROM DUAL;



















