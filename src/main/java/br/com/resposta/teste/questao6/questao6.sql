-- DESAFIO:

--- Given the tables above, write the SQL query that:

-- a. Returns the names of all Salesperson that don’t have any order with Samsonic.
-- b. Updates the names of Salesperson that have 2 or more orders. It’s necessary to add an ‘*’ in the end of the name.
-- c. Deletes all Ssalesperson that placed orders to the city of Jackson.
-- d. The total sales amount for each Salesperson. If the salesperson hasn’t sold anything, show zero.

-- criação das tabelas

CREATE TABLE Salesperson (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    salary INT
);

CREATE TABLE Customer (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    city VARCHAR(50),
    industry_type CHAR(1)
);

CREATE TABLE Orders (
    id INT PRIMARY KEY,
    order_date DATE,
    customer_id INT,
    salesperson_id INT,
    amount INT,
    FOREIGN KEY (customer_id) REFERENCES Customer(id),
    FOREIGN KEY (salesperson_id) REFERENCES Salesperson(id)
);

-- inserção de dados para teste

INSERT INTO Salesperson (id, name, age, salary) VALUES
(1, 'Diego', 30, 50000),
(2, 'Carlos', 35, 55000),
(3, 'Ana', 28, 48000),
(4, 'Julia', 40, 60000),
(5, 'Marcos', 33, 53000);

INSERT INTO Customer (id, name, city, industry_type) VALUES
(1, 'Samsonic', 'São Paulo', 'A'),
(2, 'TechWave', 'Rio de Janeiro', 'B'),
(3, 'MegaStore', 'Jackson', 'C'),
(4, 'InovaTech', 'Brasília', 'A'),
(5, 'SmartCorp', 'Fortaleza', 'B');

INSERT INTO Orders (id, order_date, customer_id, salesperson_id, amount) VALUES
(1, '2025-05-10', 1, 2, 1000),  -- Pedido para Samsonic feito por Carlos
(2, '2025-05-12', 3, 4, 2500),  -- Pedido para MegaStore feito por Julia (Jackson)
(3, '2025-05-15', 2, 1, 1500),  -- Pedido para TechWave feito por Diego
(4, '2025-05-18', 4, 5, 3000),  -- Pedido para InovaTech feito por Marcos
(5, '2025-05-20', 1, 3, 1800);  -- Pedido para Samsonic feito por Ana

-- QUERY 1, Retorna os nomes de todos os vendedores que não fizeram pedidos para Samsonic

SELECT s.name FROM Salesperson s WHERE s.id NOT IN (
    SELECT o.salesperson_id FROM Orders o WHERE o.customer_id = (SELECT c.id FROM Customer c WHERE c.name = 'Samsonic')
);

-- QUERY 2, Atualiza os nomes dos vendedores que têm 2 ou mais pedidos, adicionando * ao final

UPDATE Salesperson SET name = CONCAT(name, '*') WHERE id IN (
    SELECT o.salesperson_id FROM Orders o GROUP BY o.salesperson_id HAVING COUNT(o.id) >= 2
);

-- QUERY 3, Exclui todos os vendedores que fizeram pedidos para a cidade de Jackson

DELETE FROM Salesperson s WHERE s.id IN (
    SELECT o.salesperson_id FROM Orders o WHERE o.customer_id IN (
        SELECT c.id FROM Customer c WHERE c.city = 'Jackson'
    )
);

-- QUERY 4, Retorna o total de vendas de cada vendedor, mostrando 0 se não houver vendas

SELECT s.name, COALESCE(SUM(o.amount), 0) AS total_sales FROM Salesperson s
LEFT JOIN Orders o ON s.id = o.salesperson_id GROUP BY s.name;