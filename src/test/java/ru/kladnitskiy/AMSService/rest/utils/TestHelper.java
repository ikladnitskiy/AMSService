package ru.kladnitskiy.AMSService.rest.utils;

public class TestHelper {
    public final static String NORMAL_JSON =
            "{" +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"cluster\": \"SPb-west\"," +
                    "\"address\": \"Test_address_of_tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviceContractor\": \"Test_ServiceContractor_1\"," +
                    "\"serviceDate\": \"2019-12-07\"," +
                    "\"reportContractor\": \"Test_ReportContractor_1\"," +
                    "\"reportDate\": \"2019-12-10\"," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";

    public final static String NORMAL_JSON_WITH_ID =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"cluster\": \"SPb-west\"," +
                    "\"address\": \"Test_address_of_tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviceContractor\": \"Test_ServiceContractor_1\"," +
                    "\"serviceDate\": \"2019-12-7\"," +
                    "\"reportContractor\": \"Test_ReportContractor_1\"," +
                    "\"reportDate\": \"2019-12-10\"," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";

    public final static String NO_ADDRESS_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"cluster\": \"SPb-west\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviceContractor\": \"Test_ServiceContractor_1\"," +
                    "\"serviceDate\": \"2019-12-7\"," +
                    "\"reportContractor\": \"Test_ReportContractor_1\"," +
                    "\"reportDate\": \"2019-12-10\"," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";

    public final static String NEGATIVE_HEIGHT_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"cluster\": \"SPb-west\"," +
                    "\"address\": \"Test_address_of_tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": -72," +
                    "\"serviceContractor\": \"Test_ServiceContractor_1\"," +
                    "\"serviceDate\": \"2019-12-7\"," +
                    "\"reportContractor\": \"Test_ReportContractor_1\"," +
                    "\"reportDate\": \"2019-12-10\"," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";

    public final static String EMPTY_CODE_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"\"," +
                    "\"number\": 1957," +
                    "\"cluster\": \"SPb-west\"," +
                    "\"address\": \"Test_address_of_tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviceContractor\": \"Test_ServiceContractor_1\"," +
                    "\"serviceDate\": \"2019-12-7\"," +
                    "\"reportContractor\": \"Test_ReportContractor_1\"," +
                    "\"reportDate\": \"2019-12-10\"," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";

    public final static String LENGTH_CODE_TOO_SMALL_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"C\"," +
                    "\"number\": 1957," +
                    "\"cluster\": \"SPb-west\"," +
                    "\"address\": \"Test_address_of_tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviceContractor\": \"Test_ServiceContractor_1\"," +
                    "\"serviceDate\": \"2019-12-7\"," +
                    "\"reportContractor\": \"Test_ReportContractor_1\"," +
                    "\"reportDate\": \"2019-12-10\"," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";

    public final static String LENGTH_ADDRESS_TOO_BIG_JSON =
            "{" +
                    "\"id\": 10000," +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"cluster\": \"SPb-west\"," +
                    "\"address\": \"ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива " +
                        "ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива " +
                        "ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива " +
                        "ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviceContractor\": \"Test_ServiceContractor_1\"," +
                    "\"serviceDate\": \"2019-12-7\"," +
                    "\"reportContractor\": \"Test_ReportContractor_1\"," +
                    "\"reportDate\": \"2019-12-10\"," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";
}
