-- VIEW
/*
    <VIEW>
        SELECT ���� ������ �� �ִ� ��ü�̴�.(������ ���� ���̺�)
        �����͸� �����ϰ� ���� ������ ���̺� ���� SQL�� ����Ǿ� �־� VIEW ������ �� SQL�� �����ϸ鼭 ������� �����´�.
        
        [����]
            CREATE [OR REPLACE] VIEW ���
            AS ���� ����;
*/
-- DROP VIEW V_EMPLOYEE;
CREATE OR REPLACE VIEW V_EMPLOYEE
AS SELECT E.EMP_NAME, D.DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON D.DEPT_ID = E.DEPT_CODE
;

GRANT CREATE VIEW TO C##KH; -- SYSTEM �������� �����Ͽ� ����

SELECT *
FROM V_EMPLOYEE;

/*
    <�� Į���� ��Ī �ο�>
        ���� ������ SELECT ���� �Լ��� ��������� ����Ǿ� �ִ� ��� �ݵ�� ��Ī�� �����ؾ� �Ѵ�.
*/
/*
    <VIEW�� �̿��ؼ� DML(INSERT, UPDATE, DELETE) ���>
        �並 ���� �����͸� �����ϰ� �Ǹ� ���� �����Ͱ� ����ִ� �⺻ ���̺��� ����ȴ�.
*/
/*
    <DML �������� VIEW ������ �Ұ����� ���>
    --  1) �� ���ǿ� ���Ե��� �ʴ� Į���� �����ϴ� ���
    --  2) �信 ���Ե��� ���� Į�� �߿� �⺻ ���̺� �� NOT NULL ���������� ������ ���
    --  3) ��� ǥ�������� ���ǵ� ���
    --  4) �׷� �Լ��� GROUP BY ���� ������ ���
    --  5) DISTINCT�� ������ ���
    --  6) JOIN�� �̿��� ���� ���̺��� ������ ��� 
*/

/*
    <VIEW �ɼ�>
        [����]
            CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW
            AS ���� ����
            [WITH CHECK OPTION]
            [WITH READ ONLY];
            
        - OR REPLACE : ������ ������ �䰡 ���� ��� �����, �������� ������ �並 ���� �����Ѵ�.
        - FORCE : ���� ������ ����� ���̺��� �������� �ʴ� ���̺��̾ �䰡 �����ȴ�.
        - NOFORCE : ���� ������ ����� ���̺��� �����ؾ߸� �䰡 �����ȴ�. (�⺻��)
        - WITH CHECK OPTION : ���� ������ ����� ���ǿ� �������� �ʴ� ������ �����ϴ� ��� ������ �߻���Ų��.
        - WITH READ ONLY : �信 ���� ��ȸ�� ����(DML ���� �Ұ�)
*/
























