# Write your MySQL query statement below
SELECT id , CASE WHEN id%2 = 1 THEN LEAD(student , 1 , student) OVER (ORDER BY id)
ELSE LAG(student,1) OVER(ORDER BY id)
END AS student
FROM seat;
