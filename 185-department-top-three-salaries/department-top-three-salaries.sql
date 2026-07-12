# Write your MySQL query statement below
select Department, Employee,Salary from (
    select d.name as Department,
            e.name as Employee,
             e.salary as Salary,
            DENSE_RANK() over(partition by departmentId
                            Order by salary desc) as rnk
            from Department d
            join Employee e
            on e.departmentId=d.id
)t 
where rnk<=3;
