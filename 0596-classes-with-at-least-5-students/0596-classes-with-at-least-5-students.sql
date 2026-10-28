# Write your MySQL query statement below
with countClass as (Select student ,class, COUNT(class) as cnt from Courses  group by class)select class from countClass where cnt>=5;