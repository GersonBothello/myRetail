
/* Key Space */
CREATE KEYSPACE myretail
  WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor' : 1};


/* Table */
CREATE TABLE product_price(
	product_id int,
	current_price decimal,
	currency_code text,
	PRIMARY KEY(product_id));

/* Data */
INSERT INTO product_price (product_id, current_price, currency_code) VALUES (13860428, 13.49, 'USD');
INSERT INTO product_price (product_id, current_price, currency_code) VALUES (77400978, 19.99, 'USD');
INSERT INTO product_price (product_id, current_price, currency_code) VALUES (77285200, 9.60, 'USD');
INSERT INTO product_price (product_id, current_price, currency_code) VALUES (52918604, 19.99, 'USD');
INSERT INTO product_price (product_id, current_price, currency_code) VALUES (15302388, 39.99, 'USD');




