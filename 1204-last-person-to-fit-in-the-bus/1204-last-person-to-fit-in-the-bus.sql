WITH RunningSum AS (
    SELECT 
        person_name, 
        SUM(weight) OVER (ORDER BY turn) AS cumulative_weight
    FROM Queue
)
SELECT person_name
FROM RunningSum
WHERE cumulative_weight <= 1000
ORDER BY cumulative_weight DESC
LIMIT 1;