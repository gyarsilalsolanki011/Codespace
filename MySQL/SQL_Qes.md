Real-World SQL Interview Questions with answers

1. "Can you find the second highest salary from an employee table?"

Table: Employees(id, name, salary)

Answer:
sql
SELECT MAX(salary) AS second_highest_salary
FROM Employees
WHERE salary < (SELECT MAX(salary) FROM Employees);



2. "Write a query to find duplicate emails in a users table."

Table: Users(id, email)

Answer:
sql
SELECT email, COUNT(*) AS count
FROM Users
GROUP BY email
HAVING COUNT(*) > 1;


3. "How do you find employees who don’t have any manager assigned?"

Table: Employees(id, name, manager_id)

Answer:
sql
SELECT * FROM Employees
WHERE manager_id IS NULL;



4. "Get the top 3 highest earning employees from each department."

Table: Employees(id, name, salary, department_id)

Answer (Using Window Function):
sql
SELECT id, name, salary, department_id
FROM (
  SELECT *, RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rnk
  FROM Employees
) AS ranked
WHERE rnk <= 3;


5. "Write a query to calculate running total of sales per month."

Table: Sales(id, amount, sale_date)

Answer:
sql
SELECT
  sale_date,
  amount,
SUM(amount) OVER (ORDER BY sale_date) AS running_total
FROM Sales;



6. "Find customers who placed more than 3 orders."

Tables: Customers(customer_id, name), Orders(order_id, customer_id)

Answer:
sql
SELECT c.customer_id, c.name
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.name
HAVING COUNT(o.order_id) > 3;
