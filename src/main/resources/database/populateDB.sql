DELETE FROM type_of_work;
DELETE FROM ams;

INSERT INTO ams (id, code, number, cluster, address, type, height, service_contractor, service_date, report_contractor, report_date) VALUES
  (20000, 'LE', 000078, 'ЛО-Восток', 'ЛО, Кировский р-он, пос. Мга', 'mast', 72.0, 'ServiceContractor_1', '10-12-2019', 'ReportContractor_1', '13-12-2019'),
  (20001, 'SP', 001178, 'СПб-Центр', 'г. Санкт-Петербург, ул. Политехническая, д. 9', 'tower', 12.5, 'ServiceContractor_2', '11-12-2019', 'ReportContractor_1', '14-12-2019'),
  (20002, 'LE', 000500, 'ЛО-Юг', 'ЛО, Тихвинский р-он, пос. Васильцово', 'mast', 72.0, 'ServiceContractor_1', '12-12-2019', 'ReportContractor_2', '14-12-2019');

INSERT INTO type_of_work (ams_id, first, second, third, fourth, fifth) VALUES
  (20000, true, true, false, true, true),
  (20001, true, true, false, false, true),
  (20002, true, true, true, false, true);
