CREATE TABLE IF NOT EXISTS purchase (
	id INTEGER PRIMARY KEY,
	user_id INTEGER
		REFERENCES user ON DELETE RESTRICT,
	product_id INTEGER
		REFERENCES product ON DELETE RESTRICT
);