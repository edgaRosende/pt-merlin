CREATE TABLE IF NOT EXISTS PRICE (
    id bigint auto_increment,
    brandId smallint,
    startDate datetime,
    endDate datetime,
    priceList smallint,
    productId int,
    priority smallint,
    price double,
    curr varchar(3)
);

INSERT INTO PRICE (brandId, startDate, endDate, priceList, productId, priority, price, curr)
    VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
           (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
           (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
           (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR')