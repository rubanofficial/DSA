# Write your MySQL query statement below
select un.unique_id , emp.name from Employees emp left join EmployeeUNI un on emp.id = un.id;