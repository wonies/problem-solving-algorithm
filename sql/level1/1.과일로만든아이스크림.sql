// 과일로 만든 아이스크림 고르기


SELECT a.FLAVOR from FIRST_HALF as a
inner join ICECREAM_INFO as b
on a.FLAVOR = b.FLAVOR
WHERE b.INGREDIENT_TYPE = 'FRUIT_BASED'
and a.TOTAL_ORDER > 3000;
