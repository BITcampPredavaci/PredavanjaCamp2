BEGIN TRANSACTION;

CREATE TABLE IF NOT EXISTS new_user (
	id INTEGER PRIMARY KEY,
	full_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	balance DECIMAL NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX IF NOT EXISTS email_index
ON new_user (email);

INSERT INTO new_user (full_name, email)
SELECT full_name, email FROM user;

DROP TABLE user;

ALTER TABLE new_user
RENAME TO user;

COMMIT;
