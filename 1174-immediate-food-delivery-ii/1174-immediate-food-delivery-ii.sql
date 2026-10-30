# Write your MySQL query statement below
WITH FirstWith AS (
    SELECT DISTINCT 
        customer_id ,
        customer_pref_delivery_date, 
        order_date , DENSE_RANK() OVER (PARTITION by customer_id ORDER BY order_date) AS rnk 
        FROM Delivery 
        ORDER BY order_date 
)
SELECT ROUND(SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) * 100.0/COUNT(*),2)AS immediate_percentage FROM FirstWith WHERE rnk=1 ;

