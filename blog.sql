/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/11 9:19:54                           */
/*==============================================================*/


drop table if exists article;

drop table if exists article_classify;

drop table if exists article_favorite;

drop table if exists article_label;

drop table if exists article_type;

drop table if exists blogroll;

drop table if exists comment;

drop table if exists favorite;

drop table if exists friend;

drop table if exists label;

drop table if exists menu;

drop table if exists message;

drop table if exists user;

drop table if exists user_concern;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   blog_article_id      bigint not null auto_increment,
   user_id              bigint,
   blog_article_title   varchar(128),
   blog_article_createtime timestamp default CURRENT_TIMESTAMP,
   blog_article_modifieddate timestamp,
   blog_article_status  tinyint,
   blog_article_details text,
   blog_article_likes   int default 0,
   blog_article_views   int default 0,
   blog_article_commentnum int default 0,
   primary key (blog_article_id)
);

alter table article comment '记录博文的基本信息
如博文标题，关键字，创建日期，修改日期。。。';

/*==============================================================*/
/* Table: article_classify                                      */
/*==============================================================*/
create table article_classify
(
   classify_id          bigint not null,
   blog_article_id      bigint,
   type_id              bigint,
   primary key (classify_id)
);

/*==============================================================*/
/* Table: article_favorite                                      */
/*==============================================================*/
create table article_favorite
(
   article_favorite_id  bigint not null auto_increment,
   favorite_id          bigint,
   blog_article_id      bigint,
   primary key (article_favorite_id)
);

/*==============================================================*/
/* Table: article_label                                         */
/*==============================================================*/
create table article_label
(
   article_label_id     bigint not null,
   label_id             bigint,
   blog_article_id      bigint,
   primary key (article_label_id)
);

/*==============================================================*/
/* Table: article_type                                          */
/*==============================================================*/
create table article_type
(
   type_id              bigint not null auto_increment,
   type_superior        bigint,
   type_name            varchar(32),
   primary key (type_id)
);

alter table article_type comment '分类（分类ID，分类名称，分类别名，分类描述，上级分类ID）';

/*==============================================================*/
/* Table: blogroll                                              */
/*==============================================================*/
create table blogroll
(
   blogroll_id          bigint not null auto_increment,
   blogroll_link        varchar(255),
   blogroll_name        varchar(64),
   blogroll_detail      varchar(128),
   blogroll_logo        varchar(128),
   primary key (blogroll_id)
);

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   comment_id           bigint not null auto_increment,
   comment_superior     bigint,
   comment_article_id   bigint,
   comment_user_id      bigint,
   comment_likes        int,
   comment_date         timestamp default CURRENT_TIMESTAMP,
   comment_details      text,
   primary key (comment_id)
);

/*==============================================================*/
/* Table: favorite                                              */
/*==============================================================*/
create table favorite
(
   favorite_id          bigint not null auto_increment,
   user_id              bigint,
   favorite_name        varchar(128),
   primary key (favorite_id)
);

/*==============================================================*/
/* Table: friend                                                */
/*==============================================================*/
create table friend
(
   friend_serialnum     bigint not null auto_increment,
   friend_user_id       bigint,
   friend_id            bigint,
   friend_type          varchar(16),
   friend_comment       varchar(16),
   primary key (friend_serialnum)
);

/*==============================================================*/
/* Table: label                                               */
/*==============================================================*/
create table label
(
   label_id             bigint not null,
   label_superior       bigint,
   label_name           varchar(16),
   primary key (label_id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   menu_id              bigint not null auto_increment,
   menu_superior        bigint default 0,
   menu_name            varchar(32),
   menu_url             varchar(128),
   menu_status          tinyint,
   menu_usertype        tinyint,
   primary key (menu_id)
);

alter table menu comment '菜单（菜单ID，菜单名称，菜单链接，菜单打开方式，上级菜单ID，菜单状态,所允许使用用户类型）';

/*==============================================================*/
/* Table: message                                               */
/*==============================================================*/
create table message
(
   message_id           bigint not null,
   message_user_id      bigint,
   message_user_user_id bigint,
   message_detail       text,
   primary key (message_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              bigint not null auto_increment,
   user_name            varchar(32),
   user_type            tinyint,
   user_password        varchar(64),
   user_ip              varchar(16),
   user_status          tinyint default 0,
   user_email           varchar(32),
   user_phone           varchar(16),
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_concern                                          */
/*==============================================================*/
create table user_concern
(
   concern_id           bigint not null auto_increment,
   user_id              bigint,
   concern_user_id      bigint,
   primary key (concern_id)
);

alter table article add constraint FK_Reference_1 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table article_classify add constraint FK_Reference_5 foreign key (blog_article_id)
      references article (blog_article_id) on delete restrict on update restrict;

alter table article_classify add constraint FK_Reference_6 foreign key (type_id)
      references article_type (type_id) on delete restrict on update restrict;

alter table article_favorite add constraint FK_Reference_17 foreign key (favorite_id)
      references favorite (favorite_id) on delete restrict on update restrict;

alter table article_favorite add constraint FK_Reference_18 foreign key (blog_article_id)
      references article (blog_article_id) on delete restrict on update restrict;

alter table article_label add constraint FK_Reference_10 foreign key (blog_article_id)
      references article (blog_article_id) on delete restrict on update restrict;

alter table article_label add constraint FK_Reference_9 foreign key (label_id)
      references label (label_id) on delete restrict on update restrict;

alter table article_type add constraint FK_Reference_7 foreign key (type_superior)
      references article_type (type_id) on delete restrict on update restrict;

alter table comment add constraint FK_Reference_11 foreign key (comment_superior)
      references comment (comment_id) on delete restrict on update restrict;

alter table comment add constraint FK_Reference_12 foreign key (comment_article_id)
      references article (blog_article_id) on delete restrict on update restrict;

alter table comment add constraint FK_Reference_13 foreign key (comment_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table favorite add constraint FK_Reference_16 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table friend add constraint FK_Reference_2 foreign key (friend_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table friend add constraint FK_Reference_3 foreign key (friend_id)
      references user (user_id) on delete restrict on update restrict;

alter table label add constraint FK_Reference_8 foreign key (label_superior)
      references label (label_id) on delete restrict on update restrict;

alter table menu add constraint FK_Reference_4 foreign key (menu_superior)
      references menu (menu_id) on delete restrict on update restrict;

alter table message add constraint FK_Reference_14 foreign key (message_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table message add constraint FK_Reference_15 foreign key (message_user_user_id)
      references user (user_id) on delete restrict on update restrict;

alter table user_concern add constraint FK_Reference_19 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table user_concern add constraint FK_Reference_20 foreign key (concern_user_id)
      references user (user_id) on delete restrict on update restrict;

