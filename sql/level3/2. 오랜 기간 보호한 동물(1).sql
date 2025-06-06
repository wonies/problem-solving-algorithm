# 입양을 못간 동물 중, 가장 오래 보호소에 있던 동물 3마리의 이름 / 보호시작일을 조회하는 SQL문
# 보호 시작일 순으로 조회!

SELECT a.NAME, a.DATETIME
FROM ANIMAL_INS as a
LEFT JOIN ANIMAL_OUTS as b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.ANIMAL_ID IS NULL
ORDER BY DATETIME
LIMIT 3
