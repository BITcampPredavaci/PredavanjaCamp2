.echo on
.headers on
.mode columns

.read 001_create_product.sql

-- Ubacivanje nekoliko proizvoda
INSERT INTO product (title, price) VALUES ('Post-its', 3.59);
INSERT INTO product (title, price) VALUES ('Fountain pen', 25.99);
INSERT INtO product (title, price) VALUES ('Monitor', 359.99);

-- Par upita nad jednom tabelom
SELECT * FROM product WHERE price < 200;
SELECT * FROM product WHERE LENGTH(title) < 10;
SELECT SUM(price) FROM product;

.read 002_add_quantity_to_product.sql

-- Proizvodima jeftinijim od 200KM dajemo količinu 10
UPDATE product
SET quantity = 10
WHERE price < 200;

-- Trebamo paziti kada radimo s NULL-ovima!
SELECT NULL = NULL;
SELECT NULL < 5;
SELECT NULL > 5;
SELECT NULL + "abc";
SELECT NULL + 0;

-- Proizvodima kod kojih nema količine dajemo količinu 5. Obratite pažnju na `IS NULL`
UPDATE product
SET quantity = 5
WHERE quantity IS NULL;

.read 003_create_user.sql

-- Ubacivanje nekoliko korisnika (kupaca)
INSERT INTO user (full_name, email) VALUES ('Semir Šahman', 'semir.sahman@gmail.com');
INSERT INTO user (full_name, email) VALUES ('Narena Ibrišimović', 'narena.ibrisimovic@bitcamp.ba');
INSERT INTO user (full_name, email) VALUES ('Mladen Teofilović', 'mt@bitcamp.ba');
INSERT INTO user (full_name, email) VALUES ('Gordan Mašić', 'gm@bitcamp.ba');
INSERT INTO user (full_name, email) VALUES ('Amra Šabić', 'as@bitcamp.ba');

-- Ponovno ubacivanje ne radi pošto je email adresa već zauzeta
INSERT INTO user (full_name, email) VALUES
('Narena Ibrišimović', 'narena.ibrisimovic@bitcamp.ba');

-- Ali trebamo paziti na case sensitivity!
INSERT INTO user (full_name, email) VALUES
('Narena Ibrišimović', 'Narena.Ibrisimovic@bitcamp.ba');

SELECT * FROM user WHERE email = 'Narena.Ibrisimovic@bitcamp.ba';
SELECT * FROM user WHERE email = 'narena.ibrisimovic@bitcamp.ba';

.read 004_create_purchase.sql

-- Otkrivamo da korisnicima nismo dali ispravne ID-eve (`INT` vs `INTEGER`)
SELECT * FROM user;

.read 005_fix_user.sql

-- Zapisujemo nekoliko kupovina. Kupovina podrazumijeva kreiranje kupovine,
-- smanjivanje korisničkog balansa, te smanjivanje dostupnosti proizvoda.
-- Kako bi se osigurale da su sve tri operacije izvršene (ili nijedna),
-- grupišemo naredbe u transakciju
BEGIN; -- Transakcija 1

INSERT INTO purchase (user_id, product_id) VALUES (1, 3);

UPDATE user SET balance = balance - 359.99
WHERE id = 1;

UPDATE product
SET quantity = quantity - 1
WHERE id = 3;

COMMIT; -- Kraj transakcije 1

-- Provjeravamo kako se ponašaju strani ključevi, da li možemo obrisati zapis o
-- korisniku koji ima kupovine?
BEGIN; -- Transakcija 2
DELETE FROM user WHERE id = 1;

SELECT * FROM user;
SELECT * FROM purchase;

ROLLBACK; -- Poništavamo transakciju 2, ne želimo zapravo izbrisati korisnika

-- Da bismo natjerali SQLite da pazi na referencijalni integritet, moramo
-- izričito uključiti podršku za strane ključeve
PRAGMA foreign_keys = 1;

-- Sad možemo pokušati ponovo
DELETE FROM user WHERE id = 1;

-- Takđer možemo vidjeti da ne možemo uraditi update kupovine tako da
-- referencira zapis o korisniku koji ne postoji
UPDATE purchase SET user_id = 10;

-- Dodajemo još nekoliko kupovina
BEGIN; -- Transkacija 3
INSERT INTO purchase (user_id, product_id) VALUES (2, 2);
UPDATE user SET balance = balance - 25.99 WHERE id = 2;
UPDATE product SET quantity = quantity - 1 WHERE id = 2;
COMMIT; -- Kraj transakcije 3

BEGIN; -- Transakcija 4
INSERT INTO purchase (user_id, product_id) VALUES (3, 3);
UPDATE user SET balance = balance - 359.99 WHERE id = 3;
UPDATE product SET quantity = quantity - 1 WHERE id = 3;
COMMIT; -- Kraj transakcije 4

BEGIN; -- Transakcija 5
INSERT INTO purchase (user_id, product_id) VALUES (3, 1);
UPDATE user SET balance = balance - 3.59 WHERE id = 3;
UPDATE product SET quantity = quantity - 1 WHERE id = 1;
COMMIT; -- Transakcija 6

-- Prikaz kupovina nema puno smisla, bilo bi dobro da možemo izlistati kupovine,
-- ali tako da uključuju imena kupaca i nazive proizvoda
SELECT * FROM purchase;

-- Hajmo probati uraditi JOIN
SELECT * FROM purchase
JOIN product;
-- Vidimo da rezultat ovog upita sadrži sve kombinacije svih redova iz tabele
-- `purchase` i tabele `product`. Ako bismo tabele posmatrali kao skup svih
-- redova, onda možemo reći da smo dobili proizvod dva skupa (kartezijanski
-- proizvod, odnosno Cartesian product). Ovo nam nije od puno koristi trenutno.

-- Možemo filtrirati rezultate tako da vidimo samo one redove gdje je ID iz
-- tabele proizvoda jednak stranom ključu koji pokazuje na proizvod
SELECT * FROM purchase
JOIN product
WHERE purchase.product_id = product.id;

-- Za ovo postoji i jednostavniji zapis koristeći `ON`
SELECT * FROM purchase
JOIN product ON purchase.product_id = product.id;

-- U rezultate možemo na isti način dodati i informacije o kupcima
SELECT * FROM purchase
JOIN product ON purchase.product_id = product.id
JOIN user ON purchase.user_id = user.id;

-- Možemo se, naravno, ograničiti samo na one kolone koje su nam neophodne
SELECT user.full_name, product.title
FROM purchase
JOIN product ON product_id = product.id
JOIN user ON user_id = user.id;

-- Možemo koristiti `GROUP BY` da dobijemo informacije o tomo koliko je koji
-- proizvod bio puta prodan
SELECT product.id, product.title, COUNT(purchase.id)
FROM purchase
JOIN product ON product_id = product.id
GROUP BY product.id;

-- Kada koristimo `GROUP BY` i želimo filtrirati rezultate po koloni koja sadrži
-- agregacijsku funkciju (npr. `COUNT`, `MAX`, `MIN`) onda ne možemo koristiti
-- `WHERE`, te moramo koristiti `HAVING`. Razlog za ovo je što se `WHERE` odnosi
-- na redove prije nego što su grupisani, dok se `HAVING` primjenjuje na rezultate
-- nakon grupisanja.
SELECT product.id, product.title, COUNT(purchase.id)
FROM purchase
JOIN product ON product_id = product.id
GROUP BY product.id
HAVING COUNT(purchase.id) > 1;
