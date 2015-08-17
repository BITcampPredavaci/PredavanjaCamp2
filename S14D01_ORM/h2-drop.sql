SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

drop table if exists purchase;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists purchase_seq;

drop sequence if exists user_seq;

