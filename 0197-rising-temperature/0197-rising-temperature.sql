WITH Temp AS (
    SELECT 
        id,
        temperature,
        recordDate,
        LAG(temperature, 1) OVER (ORDER BY recordDate) AS prev_temp,
        LAG(recordDate, 1) OVER (ORDER BY recordDate) AS prev_date
    FROM Weather
)
SELECT id 
FROM Temp 
WHERE temperature > prev_temp 
  AND DATEDIFF(recordDate, prev_date) = 1;