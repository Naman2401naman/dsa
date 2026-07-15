SELECT
    s.product_id,
    s.year AS first_year,
    s.quantity,
    s.price
FROM Sales s
join (
    select product_id,min(year) as first_year
    from Sales
    group by product_id
)t
on s.product_id=t.product_id and s.year=t.first_year;