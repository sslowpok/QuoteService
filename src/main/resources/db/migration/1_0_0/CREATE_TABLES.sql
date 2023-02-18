create sequence quote_sequence start with 1 increment by 1;
create sequence user_sequence start with 1 increment by 1;
create sequence vote_sequence start with 1 increment by 1;

create table quote (
                       id bigint unique not null,
                       content varchar(255),
                       score integer,
                       timestamp timestamp,
                       user_id bigint not null,
                       primary key (id)
);

create table user_entity (
                             id bigint unique not null auto_increment,
                             date_of_creation timestamp,
                             email varchar(255),
                             name varchar(255),
                             password varchar(255),
                             primary key (id)
);

create table vote (
                      id bigint unique not null,
                      timestamp timestamp,
                      vote_category integer,
                      quote_id bigint not null,
                      user_id bigint not null,
                      primary key (id)
);

alter table quote
    add foreign key (user_id)
            references user_entity;

alter table vote
    add foreign key (quote_id)
            references quote;

alter table vote
    add foreign key (user_id)
            references user_entity;