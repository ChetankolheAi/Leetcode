# Write your MySQL query statement below
SELECT e.name , b.bonus FROM Employee e LEFT JOIN Bonus b ON e.empid = b.empid where b.bonus<1000 OR e.empid NOT IN(Select empid from Bonus); 