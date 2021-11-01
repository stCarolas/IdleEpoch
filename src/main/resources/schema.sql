DROP ALL OBJECTS ;

create table villagers
(
  id varchar(255) not null,
  primary key(id)
);

create table storages
(
  id varchar(255) not null,
  villager_id varchar(255) not null,
  primary key(id)
);

create table storage_products
(
  villager_id varchar(255) not null,
  name varchar(255) not null,
  amount long
);

create table mines
(
  id varchar(255) not null,
  ore_name varchar(255) not null,
  progress bigint,
  labor_intensity bigint,
  primary key(id)
);
