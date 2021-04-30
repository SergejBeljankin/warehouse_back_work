
delete from invoice_products;

INSERT INTO invoice_products (id, count, price, sum ,invoice_id, product_id)
VALUES ( 1, 10  , 10, 10, DEFAULT ,DEFAULT);
INSERT INTO invoice_products (id, count, price, sum ,invoice_id, product_id)
VALUES ( 3, 3000  , 3000, 6000, DEFAULT ,DEFAULT);