DELETE FROM type_of_work;
DELETE FROM ams;

INSERT INTO ams (id, code, number, cluster, address, type, height, service_contractor, service_date, report_contractor, report_date, access_status)
VALUES (20000, 'LE', 000078, 'East', 'Leningradskay obl., Kirovskiy r-n, pos. Mga', 'MAST', 72.0, 'Butorin', parsedatetime('10-12-2019', 'dd-MM-yyyy'), 'Orehov', parsedatetime('13-12-2019', 'dd-MM-yyyy'), false),
       (20001, 'SP', 001178, 'Center', 'Saint-Petersburg, ul. Politekhnicheskaya, d. 9', 'MONOPOLE', 12.5, 'Orehov', parsedatetime('11-12-2019', 'dd-MM-yyyy'), 'Butorin', parsedatetime('14-12-2019', 'dd-MM-yyyy'), false),
       (20002, 'LE', 000500, 'South', 'Leningradskay obl., Tikhvinskiy r-n, pos. Vasiltsovo', 'MAST', 72.0, 'Butorin', parsedatetime('12-12-2019', 'dd-MM-yyyy'), 'Orehov', parsedatetime('14-12-2019', 'dd-MM-yyyy'), false),
       (20003, 'LE', 001090, 'West', 'Leningradskay obl., Lomonosovskiy r-n, der. Gostilicy', 'TOWER', 60.0, 'Krivorukov', parsedatetime('12.05.2020', 'dd.MM.yyyy'), 'Dolgodumov', parsedatetime('13.05.2020', 'dd.MM.yyyy'), false),
       (20004, 'LE', 000696, 'East', 'Leningradskay obl., Volkhovsiy r-n, massiv Pupyshevo', 'PILLAR', 40.0, 'Kosoglazov', parsedatetime('13.05.2020', 'dd.MM.yyyy'), 'Idealniy', parsedatetime('23.05.2020', 'dd.MM.yyyy'), false),
       (20005, 'LE', 001031, 'East', 'Leningradskay obl., Kirishskiy r-n, g. Kirishi, pr-t Geroev, d. 16', 'MAST', 20.0, 'Bespalov', null, null, null, false),
       (20006, 'SP', 000386, 'West', 'Saint-Petersburg, Anninskoe (Gorelovo) sh., d. 1, korp. 5, str. E', 'MAST', 20.0, null, null, null, null, false),
       (20007, 'PS', 000038, 'Pskov', 'Pskovskaya obl., Porkhovskiy r-n, d. Polonoe', 'MAST', 90.0, 'Ivanov', parsedatetime('16.05.2020', 'dd.MM.yyyy'), 'Petrov', parsedatetime('20.05.2020', 'dd.MM.yyyy'), false),
       (20008, 'PS', 000073, 'Pskov', 'Pskovskaya obl., Gdovskiy r-n, s. Yamm', 'MAST', 90.0, 'Bespalov', null, null, null, false),
       (20009, 'VG', 000050, 'Vologda', 'Vologodskaya obl., Cherepovetskiy r-n, pos. Suda', 'TOWER', 60.0, 'Krivorukov', parsedatetime('18.05.2020', 'dd.MM.yyyy'), null, null, false),
       (20010, 'PZ', 000026, 'Kareliya', 'Respublika Kareliya, g. Petrozavodsk, Pervomayskiy pr-t, d. 17', 'MAST', 15.0, 'Kosoglazov', parsedatetime('19.05.2020', 'dd.MM.yyyy'), 'Podpolniy', null, false),
       (20011, 'PZ', 000030, 'Kareliya', 'Respublika Kareliya, g. Petrozavodsk, ul. Zavodskaya, d. 10', 'MAST', 27.0, null, null, null, null, false),
       (20012, 'MU', 000076, 'Murmansk', 'Murmanskaya obl., g. Kirovsk, pr-t Lenina, d. 8', 'TRIPOD', 11.0, 'Krivorukov', parsedatetime('21.05.2020', 'dd.MM.yyyy'), null, null, false),
       (20013, 'MU', 000085, 'Murmansk', 'Murmanskaya obl., g. Kandalaksha, 1-ya Liniya, d. 27', 'MAST', 32.0, 'Kosoglazov', parsedatetime('12.04.2020', 'dd.MM.yyyy'), 'Podpolniy', parsedatetime('20.04.2020', 'dd.MM.yyyy'), false),
       (20014, 'MU', 000093, 'Murmansk', 'Murmanskaya obl., Kolskiy r-n, st. Magnetity, gora Golaya', 'TOWER', 40.0, 'Bespalov', null, null, null, false),
       (20015, 'EK', 000042, 'Ekaterinburg', 'Sverdlovskaya obl, g. Ekaterinburg, ul. Selkorovskaya, d. 40', 'MAST', 9.5, 'Krivorukov', parsedatetime('14.04.2020', 'dd.MM.yyyy'), 'Dolgodumov', null, false),
       (20016, 'EK', 000054, 'Ekaterinburg', 'Sverdlovskaya obl, Achitskiy r-n, der. Osyp', 'TOWER', 72.0, 'Kosoglazov', parsedatetime('15.04.2020', 'dd.MM.yyyy'), 'Idealniy', parsedatetime('16.04.2020', 'dd.MM.yyyy'), false),
       (20017, 'EK', 000075, 'Ekaterinburg', 'Sverdlovskaya obl, g. Kachkanar, ul. Sverdlova, d. 39/1', 'MAST', 15.0, 'Bespalov', parsedatetime('16.04.2020', 'dd.MM.yyyy'), null, null, true),
       (20018, 'EK', 000080, 'Ekaterinburg', 'Sverdlovskaya obl, Nigneserginskiy r-n, der. Urazaevo', 'TOWER', 30.0, 'Krivorukov', parsedatetime('17.04.2020', 'dd.MM.yyyy'), 'Dolgodumov', null, true),
       (20019, 'EK', 000086, 'Ekaterinburg', 'Sverdlovskaya obl, g. Krasnoufimsk, ul. Gagarina', 'PILLAR', 30.0, 'Kosoglazov', parsedatetime('18.04.2020', 'dd.MM.yyyy'), 'Idealniy', parsedatetime('23.04.2020', 'dd.MM.yyyy'), false),
       (20020, 'PM', 000384, 'Perm', 'Permskiy kray, Gornozavodskiy r-n, rab. pos. Pashiya, ul. Lenina, d. 4', 'PILLAR', 30.0, 'Bespalov', null, null, null, false),
       (20021, 'PM', 000389, 'Perm', 'Permskiy kray, g. Dobryanka, der. Penki', 'TOWER', 79.0, 'Krivorukov', parsedatetime('10.02.2020', 'dd.MM.yyyy'), null, null, true),
       (20022, 'OR', 000101, 'Orenburg', 'Orenburgskaya obl., g. Orenburg, ul. Chkalova, d. 9', 'TRIPOD', 6.0, 'Krivorukov', null, null, null, true),
       (20023, 'OR', 000103, 'Orenburg', 'Orenburgskaya obl., g. Buguruslan, ul. Fruktovaya, d. 2a', 'PILLAR', 31.0, 'Krivorukov', parsedatetime('12.02.2020', 'dd.MM.yyyy'), 'Podpolniy', null, true),
       (20024, 'KG', 000293, 'Kurgan', 'Kurganskaya obl., g. Kurgan, ul. Timofeya Nevezhina, d. 7', 'TRIPOD', 15.0, 'Kosoglazov', null, null, null, true),
       (20025, 'KG', 000296, 'Kurgan', 'Kurganskaya obl., g. Kurgan, pr-t Mashinostroiteley, d. 37', 'MAST', 12.0, 'Bespalov', parsedatetime('14.02.2020', 'dd.MM.yyyy'), 'Idealniy', parsedatetime('13.04.2020', 'dd.MM.yyyy'), true),
       (20026, 'KG', 002218, 'Kurgan', 'Kurganskaya obl., Tselinniy r-n, s. Ust-Uyskoye, ul. Kirova, d. 20', 'MONOPOLE', 16.0, null, null, null, null, true),
       (20027, 'KG', 002219, 'Kurgan', 'Kurganskaya obl., Mishkinskiy r-n, s. Kirovo, ul. Sovetskaya, d. 108', 'MAST', 18.0, 'Kosoglazov', parsedatetime('16.02.2020', 'dd.MM.yyyy'), 'Podpolniy',  parsedatetime('16.03.2020', 'dd.MM.yyyy'), true),
       (20028, 'TU', 000250, 'Tyumen', 'Tyumenskaya obl., Tyumenskiy r-n, rab. pos. Bogandinskiy, ul. Neftianikov, d. 11, str. 11', 'MAST', 37.0, 'Bespalov', null, null, null, true),
       (20029, 'TU', 000251, 'Tyumen', 'Tyumenskaya obl., Vagayskiy r-on, s. Vagay, ul. Pervukhina, d. 16', 'PILLAR', 29.0, 'Krivorukov', parsedatetime('01.03.2020', 'dd.MM.yyyy'), null, null, true),
       (20030, 'KO', 000192, 'Komi', 'Respublika Komi, g. Syktyvkar, ul. Dimitrova, str. 44/3', 'TOWER', 20.0, null, null, null, null, true),
       (20031, 'KO', 000193, 'Komi', 'Respublika Komi, g. Syktyvkar, ul. Babushkina, d. 4', 'TRIPOD', 14.0, 'Krivorukov', parsedatetime('03.03.2020', 'dd.MM.yyyy'), 'Podpolniy', null, true),
       (20032, 'KO', 001020, 'Komi', 'Respublika Komi, g. Ukhta, ul. Semiashkina, d. 4A', 'TRIPOD', 10.0, 'Kosoglazov', null, null, null, true),
       (20033, 'KO', 001020, 'Komi', 'Respublika Komi, g. Syktyvkar, ul. Mira, d. 14/2', 'TOWER', 17.0, 'Bespalov', parsedatetime('05.03.2020', 'dd.MM.yyyy'), null, null, true);

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