DELETE FROM warehouses;

INSERT INTO warehouses(id,name, sort_number, address, comment_to_address, comment)
VALUES (2, 'Запасной склад','123Sort', 'Moscow', 'someComments', 'ttt'),
       (1, 'Основной склад','123Sort', 'Moscow', 'someComments', 'ttt')