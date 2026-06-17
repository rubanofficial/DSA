SELECT Department,
       Employee,
       Salary
FROM
(
    SELECT dep.name AS Department,
           emp.name AS Employee,
           emp.salary AS Salary,
           DENSE_RANK() OVER(
               PARTITION BY dep.id
               ORDER BY emp.salary DESC
           ) AS rnk
    FROM Employee emp
    JOIN Department dep
    ON emp.departmentId = dep.id
) t
WHERE rnk <= 3;