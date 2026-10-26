# Write your MySQL query statement below
SELECT name from Customer where COALESCE(referee_id,'') !=2;