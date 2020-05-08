DELETE FROM type_of_work;
DELETE FROM ams;

INSERT INTO ams (id, code, number, address, type, height, serviced) VALUES
  (10100, 'LE', 000078, 'ЛО, Кировский р-он, пос. Мга', 'mast', 72.0, true),
  (10101, 'SP', 001178, 'г. Санкт-Петербург, ул. Политехническая, д. 9', 'tower', 12.5, false),
  (10102, 'LE', 000500, 'ЛО, Тихвинский р-он, пос. Васильцово', 'tower', 100, false);

INSERT INTO type_of_work (ams_id, first, second, third, fourth, fifth) VALUES
  (10100, true, true, false, true, true),
  (10101, true, true, false, false, true),
  (10102, true, true, true, false, true);
