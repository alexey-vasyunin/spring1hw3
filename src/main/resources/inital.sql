set foreign_key_checks = off;

drop table if exists springhw3.order_information;
drop table if exists springhw3.orders;
drop table if exists springhw3.clients;
drop table if exists springhw3.products;

create table springhw3.clients
(
  id int auto_increment
    primary key,
  name varchar(255) null
);

create table springhw3.products
(
  id int auto_increment
    primary key,
  product_name varchar(255) not null,
  price decimal not null
);

create table orders
(
  id int auto_increment,
  client_id int not null,
  product_id int not null,
  constraint orders_pk
    primary key (id),
  constraint orders_clients_id_fk
    foreign key (client_id) references clients (id),
  constraint orders_products_id_fk
    foreign key (product_id) references products (id)
);

create table springhw3.order_information
(
  order_id int null,
  price int null,
  constraint order_information_orders_id_fk
    foreign key (order_id) references springhw3.orders (id)
);



INSERT INTO springhw3.clients (id, name) VALUES (1, 'Bob');
INSERT INTO springhw3.clients (id, name) VALUES (2, 'Georg');
INSERT INTO springhw3.clients (id, name) VALUES (3, 'Nikole');
INSERT INTO springhw3.clients (id, name) VALUES (4, 'Jozef');
INSERT INTO springhw3.products (id, product_name, price) VALUES (1, 'Milk', 52);
INSERT INTO springhw3.products (id, product_name, price) VALUES (2, 'Eggs (9pc)', 80);
INSERT INTO springhw3.products (id, product_name, price) VALUES (3, 'Meal', 70);
INSERT INTO springhw3.products (id, product_name, price) VALUES (4, 'Soalt', 12);
INSERT INTO springhw3.products (id, product_name, price) VALUES (5, 'Sugar', 68);
INSERT INTO springhw3.products (id, product_name, price) VALUES (6, 'Ferment', 30);
INSERT INTO springhw3.products (id, product_name, price) VALUES (7, 'Water', 50);
INSERT INTO springhw3.products (id, product_name, price) VALUES (8, 'Raisins', 120);
INSERT INTO springhw3.products (id, product_name, price) VALUES (9, 'Poppy', 35);
INSERT INTO springhw3.orders (client_id, product_id) VALUES (1, 2);
INSERT INTO springhw3.orders (client_id, product_id) VALUES (1, 3);
INSERT INTO springhw3.orders (client_id, product_id) VALUES (1, 6);
INSERT INTO springhw3.orders (client_id, product_id) VALUES (4, 5);
INSERT INTO springhw3.orders (client_id, product_id) VALUES (4, 6);
INSERT INTO springhw3.orders (client_id, product_id) VALUES (4, 7);
INSERT INTO springhw3.order_information (order_id, price) VALUES (5, 150);

set foreign_key_checks = on;