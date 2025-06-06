# 주문Id, 제품Id, 출고일자, 출고여부를 조회하는 sql문
# 2022년 5월 1일 기준
# 5월 1일까지 출교완료로 이후 날짜는 출고대기/ ㅁ ㅣ정이면 출고 미정
# 주문 id기준으로 오름차순 정렬

SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d'), `출고여부`
FROM (
    SELECT ORDER_ID, PRODUCT_ID, OUT_DATE,
    CASE WHEN OUT_DATE IS NULL THEN '출고미정'
        WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
        ELSE '출고완료'
    END AS `출고여부`
    FROM FOOD_ORDER
) as a
ORDER BY ORDER_ID;
