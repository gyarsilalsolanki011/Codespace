## Real-World SQL Interview Questions with answers
#### 1. Find the second highest salary:  
```sql
SELECT MAX(salary)  
FROM employees  
WHERE salary < (SELECT MAX(salary) FROM employees);
```

#### 2. Count employees in each department:  
```sql
SELECT department, COUNT(*)  
FROM employees  
GROUP BY department;
```

#### 3. Fetch duplicate emails:  
```sql
SELECT email, COUNT(*)  
FROM users  
GROUP BY email  
HAVING COUNT(*) > 1;
```

#### 4. Join orders with customer names:  
```sql
SELECT c.name, o.order_date  
FROM customers c  
JOIN orders o ON c.id = o.customer_id;
```

#### 5. Get top 3 highest salaries:  
```sql
SELECT DISTINCT salary  
FROM employees  
ORDER BY salary DESC  
LIMIT 3;
```
#### 6. Retrieve latest 5 logins:  
```sql
SELECT * FROM logins  
ORDER BY login_time DESC  
LIMIT 5;
```

#### 7. Employees with no manager:  
```sql
SELECT name  
FROM employees  
WHERE manager_id IS NULL;
```

#### 8. Search names starting with ‘S’:  
```sql
SELECT * FROM employees  
WHERE name LIKE 'S%';
```

#### 9. Total sales per month:  
```sql
SELECT MONTH(order_date) AS month, SUM(amount)  
FROM sales  
GROUP BY MONTH(order_date);
```

#### 10. Delete inactive users:  
```sql
DELETE FROM users  
WHERE last_active < '2023-01-01';
```

#### 11. "Can you find the second highest salary from an employee table?"
Table: `Employees(id, name, salary)`

Answer:
```sql
SELECT MAX(salary) AS second_highest_salary
FROM Employees
WHERE salary < (SELECT MAX(salary) FROM Employees);
```


#### 12. "Write a query to find duplicate emails in a users table."
Table: `Users(id, email)`

Answer:
```sql
SELECT email, COUNT(*) AS count
FROM Users
GROUP BY email
HAVING COUNT(*) > 1;
```

#### 13. "How do you find employees who don’t have any manager assigned?"
Table: `Employees(id, name, manager_id)`

Answer:
```sql
SELECT * FROM Employees
WHERE manager_id IS NULL;
```


#### 14. "Get the top 3 highest earning employees from each department."
Table: `Employees(id, name, salary, department_id)`

Answer (Using Window Function):
```sql
SELECT id, name, salary, department_id
FROM (
  SELECT *, RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rnk
  FROM Employees
) AS ranked
WHERE rnk <= 3;
```

#### 15. "Write a query to calculate running total of sales per month."
Table: `Sales(id, amount, sale_date)`

Answer:
```sql
SELECT
  sale_date,
  amount,
SUM(amount) OVER (ORDER BY sale_date) AS running_total
FROM Sales;
```


#### 16. "Find customers who placed more than 3 orders."
Tables: `Customers(customer_id, name), Orders(order_id, customer_id)`

Answer:
```sql
SELECT c.customer_id, c.name
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.name
HAVING COUNT(o.order_id) > 3;
```

## SQL Interview Questions With Answers 

#### ⿡ How to find duplicates in a table?  
```sql
SELECT column_name, COUNT(*)  
FROM table_name  
GROUP BY column_name  
HAVING COUNT(*) > 1;
```
✅ This groups rows by the column and returns only those with more than one occurrence.

#### ⿢ How to delete duplicates from a table?  
Assuming there’s no primary key:  
```sql
DELETE FROM table_name
WHERE rowid NOT IN (
  SELECT MIN(rowid)
  FROM table_name
  GROUP BY column_name
);
```
✅ Keeps the first occurrence and deletes the rest based on rowid (use CTE + ROW_NUMBER() for other DBs).

#### ⿣ Difference between UNION and UNION ALL  
- UNION removes duplicates, but is slower.  
- UNION ALL keeps duplicates and is faster.

#### ⿤ Difference between RANK(), ROW_NUMBER(), and DENSE_RANK()  
All are window functions used for ranking.  
- ROW_NUMBER() – unique sequential number  
- RANK() – same rank for ties, skips next number  
- DENSE_RANK() – same rank for ties, no skips  
```sql
SELECT *, 
  ROW_NUMBER() OVER (ORDER BY salary DESC),
  RANK() OVER (ORDER BY salary DESC),
  DENSE_RANK() OVER (ORDER BY salary DESC)
FROM employees;
```

#### ⿥ How to find records in one table that aren't in another?  
Option 1 – `NOT IN`:  
```sql
SELECT *
FROM table1
WHERE id NOT IN (SELECT id FROM table2);
```
  
Option 2 – `LEFT JOIN`:  
```sql
SELECT t1.*
FROM table1 t1
LEFT JOIN table2 t2 ON t1.id = t2.id
WHERE t2.id IS NULL;
```

#### ⿦ How to find the second highest salary in each department?  
```sql
SELECT department, salary
FROM (
  SELECT department, salary,
         DENSE_RANK() OVER (PARTITION BY department ORDER BY salary DESC) as rank
  FROM employees
) ranked
WHERE rank = 2;
```

#### ⿧ How to find employees with salary higher than their manager's?  
```sql
SELECT e.name
FROM employees e
JOIN employees m ON e.manager_id = m.id
WHERE e.salary > m.salary;
```

#### ⿨ Difference between INNER JOIN and LEFT JOIN  
- INNER JOIN returns only matched rows.  
- LEFT JOIN returns all rows from the left table and NULLs for unmatched right rows.

#### ⿩ Update a table and swap gender values  
```sql
UPDATE employees
SET gender = CASE 
               WHEN gender = 'Male' THEN 'Female'
               WHEN gender = 'Female' THEN 'Male'
             END;
```
***Tap 🌟 for more***
