# Write your MySQL query statement below
WITH firstNumber as(SELECT requester_id as id from RequestAccepted UNION ALL SELECT accepter_id as id from RequestAccepted),SecondWith as (Select id , COUNT(*) as num from firstNumber GROUP BY id )Select
id , num from SecondWith order by num desc LIMIT 1; 