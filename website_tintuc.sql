create database jspservletjdbc;
use jspservletjdbc;

CREATE TABLE role(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

CREATE TABLE user (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname VARCHAR(150) NULL,
  status int NOT NULL,
  roleid bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE news (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  title VARCHAR(255) NULL,
  thumbnail VARCHAR(255) NULL,
  shortdescription TEXT NULL,
  content TEXT NULL,
  categoryid bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

CREATE TABLE category (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (categoryid) REFERENCES category(id);

CREATE TABLE comment (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  content TEXT NOT NULL,
  user_id bigint NOT NULL,
  new_id bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (new_id) REFERENCES news(id);


insert into category(code, name) values('the-thao', 'thể thao');
insert into category(code, name) values('the-gioi', 'thế giới');
insert into category(code, name) values('chinh-tri', 'chính trị');
insert into category(code, name) values('thoi-su', 'thời sự');
insert into category(code, name) values('goc-nhin', 'góc nhìn');

insert into news(title, categoryId) values ('bài viết 1', 1);
insert into news(title, categoryId) values ('bài viết 2', 1);
insert into news(title, categoryId) values ('bài viết 3', 2);

SET SQL_SAFE_UPDATES = 0;
select * from news;
delete  from news where categoryid = 1;

update  news set  title=?, thumbnail=?, shortdescription=?















