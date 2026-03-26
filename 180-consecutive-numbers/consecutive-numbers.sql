# Write your MySQL query statement below
select distinct num as ConsecutiveNums from 
(select num,
LAG(num,1) Over() prev,
LEAD(num,1) over() next 
from Logs)t
where num=prev and prev=next;