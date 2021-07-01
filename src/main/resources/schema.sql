create table wayfarers
(
  id varchar(255) not null,
  primary key(id)
);

create table storages
(
  id varchar(255) not null,
  wayfarer_id varchar(255) not null,
  primary key(id)
);

create table storage_products
(
  wayfarer_id varchar(255) not null,
  name varchar(255) not null,
  amount long
);
