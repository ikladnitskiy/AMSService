package ru.kladnitskiy.AMSService.rest.utils;

import ru.kladnitskiy.AMSService.model.TypeAms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestHelper {
    public final static String NORMAL_JSON =
            "{" +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., g. Ostrov\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String NORMAL_JSON_WITH_ID =
            "{" +
                    "\"id\": %s," +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., g. Ostrov\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String NO_ADDRESS_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String NEGATIVE_HEIGHT_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., g. Ostrov\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": -90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String EMPTY_CODE_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., g. Ostrov\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String LENGTH_CODE_TOO_SMALL_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"P\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., g. Ostrov\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String EMPTY_ADDRESS_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String LENGTH_ADDRESS_TOO_BIG_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe " +
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String SERVICE_DATE_LATER_WHEN_THE_REPORT_DATE_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., g. Ostrov\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-20\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-16\"," +
                    "\"accessStatus\": false," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first1\": true," +
                            "\"first1A\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": true," +
                            "\"fifth\": false," +
                            "\"sixth\": false," +
                            "\"seventh\": false," +
                            "\"eighth1\": false," +
                            "\"eighth2\": false," +
                            "\"eighth3\": false," +
                            "\"eighth4\": false," +
                            "\"eighth5\": false," +
                            "\"eighth6\": false," +
                            "\"eighth7\": false" +
                        "}" +
                    "}";

    public final static String JSON_SKELETON =
            "{" +
                    "\"code\": \"%s\"," +
                    "\"number\": %d," +
                    "\"address\": \"%s\"," +
                    "\"type\": \"%s\"," +
                    "\"height\": %s," +
                    "\"serviceContractor\": \"%s\"," +
                    "\"serviceDate\": \"%s\"" +
                    "}";

    private List<AmsInfoTest> allAms = new ArrayList<>();

    public TestHelper() {
        allAms.add(new AmsInfoTest(20000, "LE", 78, "East", "Leningradskay obl., Kirovskiy r-n, pos. Mga", TypeAms.MAST, 72.0, "Butorin", LocalDate.of(2019, 12, 10), "Orehov", LocalDate.of(2019, 12, 13), false,
                new TypesOfWorkInfoTest(true, true, false, true, true, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20001, "SP", 1178, "Center", "Saint-Petersburg, ul. Politekhnicheskaya, d. 9", TypeAms.MONOPOLE, 12.5, "Orehov", LocalDate.of(2019, 12, 11), "Butorin", LocalDate.of(2019, 12, 14), false,
                new TypesOfWorkInfoTest(true, true, false, false, true, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20002, "LE", 500, "South", "Leningradskay obl., Tikhvinskiy r-n, pos. Vasiltsovo", TypeAms.MAST, 72.0, "Butorin", LocalDate.of(2019, 12, 12), "Orehov", LocalDate.of(2019, 12, 14), false,
                new TypesOfWorkInfoTest(true, true, true, false, true, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20003, "LE", 1090, "West", "Leningradskay obl., Lomonosovskiy r-n, der. Gostilicy", TypeAms.TOWER, 60.0, "Krivorukov", LocalDate.of(2020, 5, 12), "Dolgodumov", LocalDate.of(2020, 5, 13), false,
                new TypesOfWorkInfoTest(true, true, true, false, true, true, true, true, true, true, true, true, true, true, true)));
        allAms.add(new AmsInfoTest(20004, "LE", 696, "East", "Leningradskay obl., Volkhovsiy r-n, massiv Pupyshevo", TypeAms.PILLAR, 40.0, "Kosoglazov", LocalDate.of(2020, 5, 13), "Idealniy", LocalDate.of(2020, 5, 23), false,
                new TypesOfWorkInfoTest(true, true, false, false, false, true, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20005, "LE", 1031, "East", "Leningradskay obl., Kirishskiy r-n, g. Kirishi, pr-t Geroev, d. 16", TypeAms.MAST, 20.0, "Bespalov", null, null, null, false,
                new TypesOfWorkInfoTest(true, true, false, true, false, true, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20006, "SP", 386, "West", "Saint-Petersburg, Anninskoe (Gorelovo) sh., d. 1, korp. 5, str. E", TypeAms.MAST, 20.0, null, null, null, null, false,
                new TypesOfWorkInfoTest(true, true, false, true, false, true, false, false, true, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20007, "PS", 38, "Pskov", "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe", TypeAms.MAST, 90.0, "Ivanov", LocalDate.of(2020, 5, 16), "Petrov", LocalDate.of(2020, 5, 20), false,
                new TypesOfWorkInfoTest(true, true, true, true, true, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20008, "PS", 73, "Pskov", "Pskovskaya obl., Gdovskiy r-n, s. Yamm", TypeAms.MAST, 90.0, "Bespalov", null, null, null, false,
                new TypesOfWorkInfoTest(true, true, true, true, true, false, false, false, true, true, true, false, false, false, false)));
        allAms.add(new AmsInfoTest(20009, "VG", 50, "Vologda", "Vologodskaya obl., Cherepovetskiy r-n, pos. Suda", TypeAms.TOWER, 60.0, "Krivorukov", LocalDate.of(2020, 5, 18), null, null, false,
                new TypesOfWorkInfoTest(true, true, true, false, true, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20010, "PZ", 26, "Kareliya", "Respublika Kareliya, g. Petrozavodsk, Pervomayskiy pr-t, d. 17", TypeAms.MAST, 15.0, "Kosoglazov", LocalDate.of(2020, 5, 19), "Podpolniy", null, false,
                new TypesOfWorkInfoTest(true, true, false, true, false, true, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20011, "PZ", 30, "Kareliya", "Respublika Kareliya, g. Petrozavodsk, ul. Zavodskaya, d. 10", TypeAms.MAST, 27.0, null, null, null, null, false,
                new TypesOfWorkInfoTest(true, true, false, true, true, true, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20012, "MU", 76, "Murmansk", "Murmanskaya obl., g. Kirovsk, pr-t Lenina, d. 8", TypeAms.TRIPOD, 11.0, "Krivorukov", LocalDate.of(2020, 5, 21), null, null, false,
                new TypesOfWorkInfoTest(true, true, false, false, false, true, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20013, "MU", 85, "Murmansk", "Murmanskaya obl., g. Kandalaksha, 1-ya Liniya, d. 27", TypeAms.MAST, 32.0, "Kosoglazov", LocalDate.of(2020, 4, 12), "Podpolniy", LocalDate.of(2020, 4, 20), false,
                new TypesOfWorkInfoTest(true, true, false, true, true, true, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20014, "MU", 93, "Murmansk", "Murmanskaya obl., Kolskiy r-n, st. Magnetity, gora Golaya", TypeAms.TOWER, 40.0, "Bespalov", null, null, null, false,
                new TypesOfWorkInfoTest(true, true, false, false, true, true, false, false, true, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20015, "EK", 42, "Ekaterinburg", "Sverdlovskaya obl, g. Ekaterinburg, ul. Selkorovskaya, d. 40", TypeAms.MAST, 9.5, "Krivorukov", LocalDate.of(2020, 4, 14), "Dolgodumov", null, false,
                new TypesOfWorkInfoTest(true, true, false, true, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20016, "EK", 54, "Ekaterinburg", "Sverdlovskaya obl, Achitskiy r-n, der. Osyp", TypeAms.TOWER, 72.0, "Kosoglazov", LocalDate.of(2020, 4, 15), "Idealniy", LocalDate.of(2020, 4, 16), false,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20017, "EK", 75, "Ekaterinburg", "Sverdlovskaya obl, g. Kachkanar, ul. Sverdlova, d. 39/1", TypeAms.MAST, 15.0, "Bespalov", LocalDate.of(2020, 4, 16), null, null, false,
                new TypesOfWorkInfoTest(true, true, false, true, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20018, "EK", 80, "Ekaterinburg", "Sverdlovskaya obl, Nigneserginskiy r-n, der. Urazaevo", TypeAms.TOWER, 30.0, "Krivorukov", LocalDate.of(2020, 4, 17), "Dolgodumov", null, false,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20019, "EK", 86, "Ekaterinburg", "Sverdlovskaya obl, g. Krasnoufimsk, ul. Gagarina", TypeAms.PILLAR, 30.0, "Kosoglazov", LocalDate.of(2020, 4, 18), "Idealniy", LocalDate.of(2020, 4, 23), false,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20020, "PM", 384, "Perm", "Permskiy kray, Gornozavodskiy r-n, rab. pos. Pashiya, ul. Lenina, d. 4", TypeAms.PILLAR, 30.0, "Bespalov", null, null, null, false,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20021, "PM", 389, "Perm", "Permskiy kray, g. Dobryanka, der. Penki", TypeAms.TOWER, 79.0, "Krivorukov", LocalDate.of(2020, 2, 10), null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20022, "OR", 101, "Orenburg", "Orenburgskaya obl., g. Orenburg, ul. Chkalova, d. 9", TypeAms.TRIPOD, 6.0, "Krivorukov", null, null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20023, "OR", 103, "Orenburg", "Orenburgskaya obl., g. Buguruslan, ul. Fruktovaya, d. 2a", TypeAms.PILLAR, 31.0, "Krivorukov", LocalDate.of(2020, 2, 12), "Podpolniy", null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20024, "KG", 293, "Kurgan", "Kurganskaya obl., g. Kurgan, ul. Timofeya Nevezhina, d. 7", TypeAms.TRIPOD, 15.0, "Kosoglazov", null, null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20025, "KG", 296, "Kurgan", "Kurganskaya obl., g. Kurgan, pr-t Mashinostroiteley, d. 37", TypeAms.MAST, 12.0, "Bespalov", LocalDate.of(2020,2, 14), "Idealniy", LocalDate.of(2020, 4, 13), true,
                new TypesOfWorkInfoTest(true, true, false, true, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20026, "KG", 2218, "Kurgan", "Kurganskaya obl., Tselinniy r-n, s. Ust-Uyskoye, ul. Kirova, d. 20", TypeAms.MONOPOLE, 16.0, null, null, null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20027, "KG", 2219, "Kurgan", "Kurganskaya obl., Mishkinskiy r-n, s. Kirovo, ul. Sovetskaya, d. 108", TypeAms.MAST, 18.0, "Kosoglazov", LocalDate.of(2020, 2, 16), "Podpolniy",  LocalDate.of(2020, 3, 16), true,
                new TypesOfWorkInfoTest(true, true, false, true, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20028, "TU", 250, "Tyumen", "Tyumenskaya obl., Tyumenskiy r-n, rab. pos. Bogandinskiy, ul. Neftianikov, d. 11, str. 11", TypeAms.MAST, 37.0, "Bespalov", null, null, null, true,
                new TypesOfWorkInfoTest(true, true, false, true, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20029, "TU", 251, "Tyumen", "Tyumenskaya obl., Vagayskiy r-on, s. Vagay, ul. Pervukhina, d. 16", TypeAms.PILLAR, 29.0, "Krivorukov", LocalDate.of(2020, 3, 1), null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20030, "KO", 192, "Komi", "Respublika Komi, g. Syktyvkar, ul. Dimitrova, str. 44/3", TypeAms.TOWER, 20.0, null, null, null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20031, "KO", 193, "Komi", "Respublika Komi, g. Syktyvkar, ul. Babushkina, d. 4", TypeAms.TRIPOD, 14.0, "Krivorukov", LocalDate.of(2020, 3, 3), "Podpolniy", null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20032, "KO", 1020, "Komi", "Respublika Komi, g. Ukhta, ul. Semiashkina, d. 4A", TypeAms.TRIPOD, 10.0, "Kosoglazov", null, null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.add(new AmsInfoTest(20033, "KO", 1020, "Komi", "Respublika Komi, g. Syktyvkar, ul. Mira, d. 14/2", TypeAms.TOWER, 17.0, "Bespalov", LocalDate.of(2020, 3, 5), null, null, true,
                new TypesOfWorkInfoTest(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false)));
        allAms.sort(Comparator.comparing(o -> o.number));
    }

    public List<AmsInfoTest> getAllAms() {
        return allAms;
    }

    public List<AmsInfoTest> getAmsInfoByPage(Integer pageNumber, Integer pageSize, List<AmsInfoTest> list) {
        return list.stream().skip(pageNumber * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public AmsInfoTest getAmsInfoById(Integer id) {
        return allAms.stream().filter(ams -> ams.id.equals(id)).findFirst().orElse(null);
    }
}
