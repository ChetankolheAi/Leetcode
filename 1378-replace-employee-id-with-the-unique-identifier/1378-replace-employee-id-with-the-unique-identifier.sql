# Write your MySQL query statement below
select e.unique_id , b.name from Employees b Left Join EmployeeUNI e on b.id = e.id;