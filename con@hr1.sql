select * from book;

create table register(username varchar2(20),email varchar2(20),password varchar2(20), gender varchar2(20));
create sequence userregister_id_seq start with 1 INCREMENT by 1;


select * from register;
select * from book;

delete register where id =59;

delete book;
rollback;
commit;

delete from author where id=2;
commit;

delete from book where id=9;

delete from register where id=61;
create table author (id number(10),name varchar2(20),dateofbirth date  );
SELECT * FROM author;

select * from book;
select * from USER_CONSTRAINTS where table_name='AUTHOR';
alter table book add foreign key(author_id) references author(id);
alter table author add primary key(id);


create table purchased (id number(10),name varchar2(100),price number(10),order_1d number(20));
create sequence order_id_seq start with 1 INCREMENT by 1;

select * from purchased
;

create table purchased (name varchar2(20),author_id number(20));

select username , password  from register where email= 'karthi@gmail.com';

select * from register;
select * from book;
select * from author;
ALTER TABLE register
modify email unique;

commit;
insert into book values (id=1, name="mani",price=20,author_id=108);