select em1.employee_id , em1.name , count(em2.reports_to) as reports_count, round(avg(em2.age)) as average_age
from Employees em1 
join Employees em2
on em1.employee_id = em2.reports_to
Group By em1.employee_id
Order By em1.employee_id;
