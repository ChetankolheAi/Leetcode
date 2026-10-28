
    WITH CountSingle AS (
        SELECT num, COUNT(num) AS cnt 
        FROM MyNumbers 
        GROUP BY num
    ),
    SecondWith AS (
        SELECT MAX(num) as num
        FROM CountSingle 
        WHERE cnt = 1
    )
    SELECT num 
    FROM SecondWith;
