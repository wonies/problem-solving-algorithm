# 입양을 간 동물 중 보호기간이 가장 길었던 동물 두 마리의 아이디와 이름 조회
# 보호 기간이 긴 순으로 조회

SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_INS as a
JOIN ANIMAL_OUTS as b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.DATETIME - a.DATETIME
ORDER BY  b.DATETIME - a.DATETIME DESC
limit 2;
