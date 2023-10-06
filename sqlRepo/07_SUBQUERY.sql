/*
    <SUBQUERY>
    하나의 SQL 문 안에 포함된 또 다른 SQL 문을 뜻한다. 
    메인 쿼리(기존 쿼리)를 보조하는 역할을 하는 쿼리문이다.
*/
SELECT *
FROM (SELECT * FROM EMPLOYEE);

SELECT (SELECT 10 FROM DUAL) + 20
FROM DUAL;



















