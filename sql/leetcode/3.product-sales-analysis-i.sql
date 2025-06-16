/*
https://leetcode.com/problems/Product-sales-analysis-i/

Table: Sales
+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| sale_id     | int   |
| product_id  | int   |
| year        | int   |
| quantity    | int   |
| price       | int   |
+-------------+-------+
(sale_id, year) is the primary key of this table.
product_id is a foreign key to Product table.
Each row of this table shows a sale on the Product product_id in a certain year.
Note that the price is per unit.
(sale_id, year)는 이 테이블의 기본 키입니다.
product_id는 Product 테이블의 외래 키입니다.
price는 개당 가격입니다.
이 테이블의 각 행에는 특정 연도의 product_id 제품 판매가 표시됩니다.


Table: Product
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| product_id   | int     |
| product_name | varchar |
+--------------+---------+
product_id is the primary key of this table.
Each row of this table indicates the Product name of each Product.
product_id는 이 테이블의 기본 키입니다.
이 표의 각 행은 각 제품의 제품 이름을 나타냅니다.


Write an SQL query that reports the product_name, year, and price for each sale_id in the Sales table.
Return the resulting table in any order.
Sales 테이블의 각 sale_id에 대한 product_name, year, price를 출력하는 SQL 코드를 작성합니다.
결과는 어떤 순서이든 괜찮습니다.


Example:
Input:
Sales table:
+---------+------------+------+----------+-------+
| sale_id | product_id | year | quantity | price |
+---------+------------+------+----------+-------+
| 1       | 100        | 2008 | 10       | 5000  |
| 2       | 100        | 2009 | 12       | 5000  |
| 7       | 200        | 2011 | 15       | 9000  |
+---------+------------+------+----------+-------+
Product table:
+------------+--------------+
| product_id | product_name |
+------------+--------------+
| 100        | Nokia        |
| 200        | Apple        |
| 300        | Samsung      |
+------------+--------------+
Output:
+--------------+-------+-------+
| product_name | year  | price |
+--------------+-------+-------+
| Nokia        | 2008  | 5000  |
| Nokia        | 2009  | 5000  |
| Apple        | 2011  | 9000  |
+--------------+-------+-------+
Explanation:
From sale_id = 1, we can conclude that Nokia was sold for 5000 in the year 2008.
From sale_id = 2, we can conclude that Nokia was sold for 5000 in the year 2009.
From sale_id = 7, we can conclude that Apple was sold for 9000 in the year 2011.
설명:
sale_id = 1을 통해 Nokia가 2008년에 5000에 판매된 것을 확인할 수 있습니다.
sale_id = 2을 통해 Nokia가 2009년에 5000에 판매된 것을 확인할 수 있습니다.
sale_id = 7을 통해 Apple이 2011년에 9000에 판매된 것을 확인할 수 있습니다.
*/

# [SETTING]
USE practice;
DROP TABLE Sales;
CREATE TABLE Sales (
  sale_id INT,
  product_id INT,
  year INT,
  quantity INT,
  price INT
);
INSERT INTO
  Sales (sale_id, product_id, year, quantity, price)
VALUES
  (1, 100, 2008, 10, 5000),
  (2, 100, 2009, 12, 5000),
  (7, 200, 2011, 15, 9000);
SELECT *
FROM Sales;

# [SETTING]
USE practice;
DROP TABLE Product;
CREATE TABLE Product (
	product_id INT,
	product_name VARCHAR(255)
);
INSERT INTO
  Product (product_id, product_name)
VALUES
  (100, 'Nokia'),
  (200, 'Apple'),
  (300, 'Samsung');
SELECT *
FROM Product;

# [PRACTICE]
SELECT *
FROM Sales AS s
INNER JOIN Product AS p
ON s.product_id = p.product_id;

# [MYSQL]
SELECT
  p.product_name,
  s.year,
  s.price
FROM Sales AS s
INNER JOIN Product AS p
ON s.product_id = p.product_id;
