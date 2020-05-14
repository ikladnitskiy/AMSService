package ru.kladnitskiy.AMSService.rest.utils;

public class TestHelper {
    public final static String NORMAL_JSON =
            "{" +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"address\": \"Address of tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviced\": true," +
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
                    "\"address\": \"Address of tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviced\": true," +
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
                    "\"id\": 10100," +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviced\": true," +
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
                    "\"id\": 10100," +
                    "\"number\": 1957," +
                    "\"address\": \"Address of tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": -72," +
                    "\"serviced\": true," +
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
                    "\"id\": 10100," +
                    "\"code\": \"\"," +
                    "\"number\": 1957," +
                    "\"address\": \"Address of tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviced\": true," +
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
                    "\"id\": 10100," +
                    "\"code\": \"T\"," +
                    "\"number\": 1957," +
                    "\"address\": \"Address of tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviced\": true," +
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
                    "\"id\": 10100," +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"address\": \"ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива " +
                        "ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива " +
                        "ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива " +
                        "ЛО, Бокситогорский р-он, пос. Пикалево, юго-западнее лесного массива\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
                    "\"serviced\": true," +
                    "\"typesOfWork\": " +
                        "{" +
                            "\"first\": true," +
                            "\"second\": true," +
                            "\"third\": true," +
                            "\"fourth\": false," +
                            "\"fifth\": true" +
                        "}" +
                    "}";

    public final static String NO_SERVICED_JSON =
            "{" +
                    "\"code\": \"SP\"," +
                    "\"number\": 1957," +
                    "\"address\": \"Address of tower\"," +
                    "\"type\": \"tower\"," +
                    "\"height\": 72," +
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
