# Write your MySQL query statement below
WITH countSum as(
SELECT p.product_name , o.unit , o.product_id from Products p join Orders o on o.product_id = p.product_id where o.order_date <'2020-03-01' AND order_date >= '2020-02-01') Select product_name , SUM(unit) as unit from countSum group by product_id Having SUM(unit) >= 100; 