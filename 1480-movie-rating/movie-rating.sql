# Write your MySQL query statement below
(select u.name as results from MovieRating m join Users u on u.user_id=m.user_id
group by m.user_id 
order by count(*) desc,name limit 1)

union all
(select mo.title as results from MovieRating m join Movies mo on m.movie_id=mo.movie_id
where m.created_at between '2020-02-01' AND '2020-02-29'
group by m.movie_id
order by avg(m.rating) desc,title limit 1)