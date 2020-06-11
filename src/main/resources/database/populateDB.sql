SET client_encoding TO 'utf8';

DELETE FROM type_of_work;
DELETE FROM ams;

INSERT INTO ams (id, code, number, cluster, address, type, height, service_contractor, service_date, report_contractor, report_date)
VALUES (20000, 'LE', 000078, 'СПб-Восток', 'ЛО, Кировский р-он, пос. Мга', 'MAST', 72.0, 'Буторин', '10-12-2019', 'Орехов', '13-12-2019'),
       (20001, 'SP', 001178, 'СПб-Центр', 'г. Санкт-Петербург, ул. Политехническая, д. 9', 'MONOPOLE', 12.5, 'Орехов', '11-12-2019', 'Буторин', '14-12-2019'),
       (20002, 'LE', 000500, 'СПб-Юг', 'ЛО, Тихвинский р-он, пос. Васильцово', 'MAST', 72.0, 'Буторин', '12-12-2019', 'Орехов', '14-12-2019'),
       (20003, 'LE', 001090, 'СПб-Запад', 'Ленинградская обл., Ломоносовский р-он, дер. Гостилицы', 'TOWER', 60.0, 'Криворуков', '12.05.2020', 'Долгодумов', '13.05.2020'),
       (20004, 'LE', 000696, 'СПб-Восток', 'Ленинградская обл., Волховский р-он, массив Пупышево, садовое некоммерческое товарищество "Восход", 10-я Аллея, территория СНТ Восход', 'PILLAR', 40.0, 'Косоглазов', '13.05.2020', 'Идеальный', null),
       (20005, 'LE', 001031, 'СПб-Восток', 'Ленинградская обл., Киришский р-он, г. Кириши, пр-т Героев, д. 16', 'MAST', 20.0, 'Беспалов', null, null, null),
       (20006, 'SP', 000386, 'СПб-Запад', 'г. Санкт-Петербург, Аннинское (Горелово) шоссе, д. 1, корп. 5, стр. Е', 'MAST', 20.0, null, null, null, null),
       (20007, 'PS', 000038, null, 'Псковская обл., Порховский р-он, дер. Полоное, АМС ООО "Тяп-Ляп Телеком"', 'MAST', 90.0, 'Косоглазов', '16.05.2020', 'Подпольный', '20.05.2020'),
       (20008, 'PS', 000073, null, 'Псковская обл., Гдовский р-он, с. Ямм, АМС ООО "Тяп-Ляп Телеком"', 'MAST', 90.0, 'Беспалов', null, null, null),
       (20009, 'VG', 000050, null, 'Вологодская обл., Череповецкий р-он, пос. Суда, АМС ОАО "Тяп-Ляп Телеком"', 'TOWER', 60.0, 'Криворуков', '18.05.2020', null, null),
       (20010, 'PZ', 000026, null, 'Республика Карелия, г. Петрозаводск, Первомайский пр-т, д. 17', 'MAST', 15.0, 'Косоглазов', '19.05.2020', 'Подпольный', null),
       (20011, 'PZ', 000030, null, 'Республика Карелия, г. Петрозаводск, ул. Заводская, д. 10', 'MAST', 27.0, null, null, null, null),
       (20012, 'MU', 000076, null, 'Мурманская обл., г. Кировск, пр-т Ленина, д. 8', 'TRIPOD', 11.0, 'Криворуков', '21.05.2020', null, null),
       (20013, 'MU', 000085, null, 'Мурманская обл., г. Кандалакша, 1-я Линия, д. 27', 'MAST', 32.0, 'Косоглазов', '12.04.2020', 'Подпольный', '20.04.2020'),
       (20014, 'MU', 000093, null, 'Мурманская обл., Кольский р-он, ж/д ст. Магнетиты , гора Голая, АМС ЗАО "Тяп-Ляп Телеком"', 'TOWER', 40.0, 'Беспалов', null, null, null),
       (20015, 'EK', 000042, null, 'Свердловская обл., г. Екатеринбург, ул. Селькоровская, д. 40', 'MAST', 9.5, 'Криворуков', '14.04.2020', 'Долгодумов', null),
       (20016, 'EK', 000050, null, 'Свердловская обл., Ачитский р-он, дер. Осыпь, мачта ООО "Тяп-Ляп Телеком"', 'TOWER', 72.0, 'Косоглазов', '15.04.2020', 'Идеальный', '16.04.2020'),
       (20017, 'EK', 000075, null, 'Свердловская обл., г. Качканар, ул. Свердлова, д. 39/1', 'MAST', 15.0, 'Беспалов', '16.04.2020', null, null),
       (20018, 'EK', 000080, null, 'Свердловская обл., Нижнесергинский р-он, дер. Уразаево, мачта ООО "Тяп-Ляп Телеком"', 'TOWER', 30.0, 'Криворуков', '17.04.2020', 'Долгодумов', null),
       (20019, 'EK', 000086, null, 'Свердловская обл., г. Красноуфимск, ул. Гагарина, мачта связи', 'PILLAR', 30.0, 'Косоглазов', '18.04.2020', 'Идеальный', '23.04.2020'),
       (20020, 'PM', 000384, null, 'Пермский Край, Горнозаводский р-он, раб. пос. Пашия, ул. Ленина, д. 4, АМС ЗАО "Тяп-Ляп Телеком"', 'PILLAR', 30.0, 'Беспалов', null, null, null),
       (20021, 'PM', 000389, null, 'Пермский Край, г. Добрянка, дер. Пеньки, АМС', 'TOWER', 79.0, 'Криворуков', '10.02.2020', null, null),
       (20022, 'OR', 000101, null, 'Оренбургская обл., г. Оренбург, ул. Чкалова, д. 9', 'TRIPOD', 6.0, 'Криворуков', null, null, null),
       (20023, 'OR', 000103, null, 'Оренбургская обл., г. Бугуруслан, ул. Фруктовая, д. 2а', 'PILLAR', 31.0, 'Криворуков', '12.02.2020', 'Подпольный', null),
       (20024, 'KG', 000293, null, 'Курганская обл., г. Курган, ул. Тимофея Невежина, д. 7', 'TRIPOD', 15.0, 'Косоглазов', null, null, null),
       (20025, 'KG', 000296, null, 'Курганская обл., г. Курган, пр-т Машиностроителей, д. 37', 'MAST', 12.0, 'Беспалов', '14.02.2020', 'Идеальный', '13.04.2020'),
       (20026, 'KG', 002218, null, 'Курганская обл., Целинный р-он, с. Усть-Уйское, ул. Кирова, д. 20', 'MONOPOLE', 16.0, null, null, null, null),
       (20027, 'KG', 002219, null, 'Курганская обл., Мишкинский р-он, с. Кирово, ул. Советская, д. 108', 'MAST', 18.0, 'Косоглазов', '16.02.2020', 'Подпольный', '16.03.2020'),
       (20028, 'TU', 000250, null, 'Тюменская обл., Тюменский р-он, раб. пос. Богандинский, ул. Нефтяников, д. 11, стр. 11', 'MAST', 37.0, 'Беспалов', null, null, null),
       (20029, 'TU', 000251, null, 'Тюменская обл., Вагайский р-он, с. Вагай, ул. Первухина, в р-оне д. 16', 'PILLAR', 29.0, 'Криворуков', '01.03.2020', null, null),
       (20030, 'KO', 000192, null, 'Республика Коми, г. Сыктывкар, ул. Димитрова, стр. 44/3', 'TOWER', 20.0, null, null, null, null),
       (20031, 'KO', 000193, null, 'Республика Коми, г. Сыктывкар, ул. Бабушкина, д. 4', 'TRIPOD', 14.0, 'Криворуков', '03.03.2020', 'Подпольный', null),
       (20032, 'KO', 000249, null, 'Республика Коми, г. Ухта, ул. Семяшкина, д. 4А', 'TRIPOD', 10.0, 'Косоглазов', null, null, null),
       (20033, 'KO', 000250, null, 'Республика Коми, г. Сыктывкар, ул. Мира, д. 14/2', 'TOWER', 17.0, 'Беспалов', '05.03.2020', null, null);

INSERT INTO type_of_work (ams_id, first_1, first_1a, second, third, fourth, fifth, sixth, seventh, eighth_1, eighth_2,
                          eighth_3, eighth_4, eighth_5, eighth_6, eighth_7)
VALUES (20000, true, true, false, true, true, false, false, false, false, false, false, false, false, false, false),
       (20001, true, true, false, false, true, false, false, false, false, false, false, false, false, false, false),
       (20002, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false),
       (20003, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true),
       (20004, true, true, false, false, false, true, false, false, false, false, false, false, false, false, false),
       (20005, true, true, false, true, false, true, false, false, false, false, false, false, false, false, false),
       (20006, true, true, false, true, false, true, false, false, true, false, false, false, false, false, false),
       (20007, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false),
       (20008, true, true, true, true, true, false, false, false, true, true, true, false, false, false, false),
       (20009, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false),
       (20010, true, true, false, true, false, true, false, false, false, false, false, false, false, false, false),
       (20011, true, true, false, true, true, true, false, false, false, false, false, false, false, false, false),
       (20012, true, true, false, false, false, true, false, false, false, false, false, false, false, false, false),
       (20013, true, true, false, true, true, true, false, false, false, false, false, false, false, false, false),
       (20014, true, true, false, false, true, true, false, false, true, false, false, false, false, false, false),
       (20015, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false),
       (20016, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20017, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false),
       (20018, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20019, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20020, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20021, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20022, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20023, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20024, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20025, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false),
       (20026, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20027, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false),
       (20028, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false),
       (20029, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20030, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20031, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20032, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false),
       (20033, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false);

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (id, username, email, first_name, last_name, password, created, updated, status)
VALUES (1, 'Admin', 'admin@test.com', 'David', 'Ivanov', '$2a$04$BXQ8GHJqM9nlVA0ephumbOEnolo/o6Rr8PKc7PA1SQl7xsCcAPqwe', '10-06-2020', '10-06-2020', 'ACTIVE'), -- password 'admin'
       (2, 'User', 'user@test.com', 'Ivan', 'Davidov', '$2a$04$G/PHPCzElBdVlk4n0koA9.jjVHk52hfNmeBpqyGtZ8NcQjq6Mh.0u', '10-06-2020', '10-06-2020', 'ACTIVE'); -- password 'user'

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1)