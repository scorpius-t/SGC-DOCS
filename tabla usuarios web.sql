use SGCdb 

create table usuarios(
usr varchar(40) primary key,
pswd varchar(40) not null,
rol varchar(40) not null,
account_non_locked tinyint not null default 1,
constraint ck_rol check (rol in ('USER','ADMIN'))
)

create table log_attempts(
id int not null primary key identity(1,1),
usr	 varchar(40) not null,
attempts varchar(40) not null,

)

insert into usuarios (usr, pswd,rol, account_non_locked ) values
('iecuser', 'iecgaen', 'USER'),
('adminiec', 'potus1234', 'ADMIN')





select * from usuarios 

select * from log_attempts 


update usuarios
set account_non_locked =1
where usr='adminiec'