
/* Key Space */
CREATE KEYSPACE myretail
  WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor' : 1};


/* Table */
CREATE TABLE product_price(
	product_id text,
	current_price decimal,
	currency_code text,
	PRIMARY KEY(product_id));


/* Data */
INSERT INTO product_price (product_id, current_price, currency_code) VALUES ('13860428', 13.49, 'USD');
