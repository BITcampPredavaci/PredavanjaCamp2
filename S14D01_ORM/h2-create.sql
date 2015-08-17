create table product (
  id                        bigint not null,
  title                     varchar(255),
  price                     decimal(10,2),
  quantity                  integer,
  constraint pk_product primary key (id))
;

create table purchase (
  id                        bigint not null,
  product_id                bigint,
  user_id                   bigint,
  constraint pk_purchase primary key (id))
;

create table user (
  id                        bigint not null,
  full_name                 varchar(255),
  email                     varchar(255),
  balance                   decimal(10,2),
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id))
;

create sequence product_seq;

create sequence purchase_seq;

create sequence user_seq;

alter table purchase add constraint fk_purchase_product_1 foreign key (product_id) references product (id) on delete restrict on update restrict;
create index ix_purchase_product_1 on purchase (product_id);
alter table purchase add constraint fk_purchase_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_purchase_user_2 on purchase (user_id);


