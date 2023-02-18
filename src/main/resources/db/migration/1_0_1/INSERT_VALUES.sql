insert into user_entity (id, date_of_creation, name, email, password)
    values (nextval('user_sequence'), '2023-02-18T17:51:37.276756', 'Tom', 'tom@gmail.com', 'qwe123');
insert into user_entity (id, date_of_creation, name, email, password)
    values (nextval('user_sequence'), '2023-02-18T17:51:37.276756', 'Johan', 'johan@gmail.com', 'qwerty');
insert into user_entity(id, date_of_creation, name, email, password)
    values (nextval('user_sequence'), '2023-02-18T17:51:37.276756', 'Tim', 'tim@gmail.com', '123456');

insert into quote (id, content, score, timestamp, user_id)
    values (nextval('quote_sequence'), 'Sample quote 1', 3, '2023-02-18T17:53:37.276756', 1);
insert into quote (id, content, score, timestamp, user_id)
    values (nextval('quote_sequence'), 'Sample quote 2', 9, '2023-02-18T17:54:57.276756', 2);
insert into quote (id, content, score, timestamp, user_id)
    values (nextval('quote_sequence'), 'Sample quote 3', 16, '2023-02-18T17:55:37.276756', 1);
insert into quote (id, content, score, timestamp, user_id)
    values (nextval('quote_sequence'), 'Sample quote 4', 4, '2023-02-18T17:53:37.276756', 3);
insert into quote (id, content, score, timestamp, user_id)
    values (nextval('quote_sequence'), 'Sample quote 5', 1, '2023-02-18T17:53:37.276756', 2);
insert into quote (id, content, score, timestamp, user_id)
    values (nextval('quote_sequence'), 'Sample quote 6', 4, '2023-02-18T17:53:37.276756', 1);

insert into vote (id, timestamp, vote_category, quote_id, user_id)
    values (nextval('vote_sequence'), '2023-02-18T17:53:37.276756', 0, 1, 1);
insert into vote (id, timestamp, vote_category, quote_id, user_id)
    values (nextval('vote_sequence'), '2023-02-18T17:53:37.276756', 0, 1, 1);
insert into vote (id, timestamp, vote_category, quote_id, user_id)
    values (nextval('vote_sequence'), '2023-02-18T17:53:37.276756', 1, 1, 2);
insert into vote (id, timestamp, vote_category, quote_id, user_id)
    values (nextval('vote_sequence'), '2023-02-18T17:53:37.276756', 1, 2, 1);
insert into vote (id, timestamp, vote_category, quote_id, user_id)
    values (nextval('vote_sequence'), '2023-02-18T17:53:37.276756', 1, 2, 3);