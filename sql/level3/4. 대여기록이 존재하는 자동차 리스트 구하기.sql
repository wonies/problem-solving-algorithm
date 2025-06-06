# 자동차 종류 = '세단'/ 10월에 대여를 시작한 기록이 있는 자동차 ID리스트 출력하는 SQL문작성!
# 자동차 ID리스트는 중복이 없어야 하며, 자동차 id를 기준으로 내림차순 정렬해야함

SELECT distinct r.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR as r
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
ON r.CAR_ID = h.CAR_ID
WHERE r.CAR_TYPE = '세단' and MONTH(h.START_DATE) = 10
ORDER BY r.CAR_ID DESC
