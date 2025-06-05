# 분화된 연도(year), 분화된 연도별 대장균 크기의 편차(year_Dev),
# 대장균 개체의 id를 출력
# 편차 : 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
# 연도별 대장균 크기의 편차

SELECT YEAR(DIFFERENTIATION_DATE) AS `YEAR`,
    d.MAX_SIZE - SIZE_OF_COLONY AS `YEAR_DEV`, ID
FROM ECOLI_DATA as e
JOIN (
    SELECT
        YEAR(DIFFERENTIATION_DATE) AS `YEAR`,
        MAX(SIZE_OF_COLONY) as `MAX_SIZE`
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
 ) as d
ON YEAR(e.DIFFERENTIATION_DATE) = d.YEAR
ORDER BY YEAR, YEAR_DEV;
