# Write your MySQL query statement below
select employee_id 
from Employees 
where 
salary<30000 
and manager_id 
not in (select employee_id from Employees)
and manager_id is not null
order by employee_id;