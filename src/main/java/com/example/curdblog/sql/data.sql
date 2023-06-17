use test;
create TABLE DATA(
    id BIGINT AUTO_INCREMENT primary key ,
    data VARCHAR(255) DEFAULT '' NOT NULL
)
select * from DATA;