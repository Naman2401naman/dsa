# Write your MySQL query statement below
select round(
    count(distinct a1.player_id)/(select count(distinct player_id) from activity),2
) as fraction
from (select player_id,min(event_date) as first_login
 from activity group by player_id) a1

 join activity a2 ON a1.player_id=a2.player_id
    AND a2.event_date=DATE_ADD(a1.first_login, INTERVAL 1 DAY);