DROP TABLE t_user;
create table t_user(
	u_id int not null AUTO_INCREMENT,
	u_name varchar(100),
	u_password varchar(100),
	u_age int,
	u_salary double,
	u_hiredate date,
	primary key (u_id)
);
insert into t_user (u_id,u_name,u_password,u_age,u_salary,u_hiredate)
values(null,'DMETAL','A123',21,12000,NOW());

select * from t_user;