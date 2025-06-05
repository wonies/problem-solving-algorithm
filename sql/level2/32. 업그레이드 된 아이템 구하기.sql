# 아이템의 회귀도가 RARE인 아이템들의 모든 다음 아이템의 id, item_name, rarity를 출력
# 아이템 id기준으로 내림차순

SELECT a.ITEM_ID, a.ITEM_NAME, a.RARITY
FROM ITEM_INFO as a
WHERE a.ITEM_ID IN (
    SELECT ITEM_ID
    FROM ITEM_TREE
    WHERE PARENT_ITEM_ID IN (
        SELECT ITEM_ID
        FROM ITEM_INFO
        WHERE RARITY = 'RARE'
    )
)
ORDER BY a.ITEM_ID DESC;
