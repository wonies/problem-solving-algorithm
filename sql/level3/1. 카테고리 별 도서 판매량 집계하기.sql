# 2022년 1월의 카테고리별 도서 판매량을 합산
# 카테고리, 총 판매량 리스트를 출력하는 SQL문 작성
# 카데고리명을 기준으로 오름차순 정렬

SELECT a.CATEGORY, SUM(SALES) as TOTAL_SALES
FROM BOOK as a
JOIN BOOK_SALES as b
ON a.BOOK_ID = b.BOOK_ID
WHERE YEAR(b.SALES_DATE) = '2022' and MONTH(b.SALES_DATE) = 1
GROUP BY CATEGORY
ORDER BY CATEGORY
