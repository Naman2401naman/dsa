SELECT c.category,
       IFNULL(t.accounts_count,0) AS accounts_count
FROM
(
    SELECT 'Low Salary' AS category
    UNION ALL
    SELECT 'Average Salary'
    UNION ALL
    SELECT 'High Salary'
) c
left join (
    select case 
        when income < 20000 then 'Low Salary'
        when income > 50000 then 'High Salary'
        else 'Average Salary' end as category,count(*) as accounts_count
        from Accounts
        group by category 
)t
on c.category=t.category;