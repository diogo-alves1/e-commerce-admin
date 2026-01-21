CREATE TABLE IF NOT EXISTS produkt (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    preis NUMERIC(10,2) NOT NULL,
    lagerbestand INT NOT NULL,
    kategorie VARCHAR(100)
);