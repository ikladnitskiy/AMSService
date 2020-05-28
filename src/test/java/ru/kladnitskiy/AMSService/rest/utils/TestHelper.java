package ru.kladnitskiy.AMSService.rest.utils;

public class TestHelper {
    public final static String NORMAL_JSON =
            "{" +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., Porkhovskiy r-n, d. Polonoe\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
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
                    "\"id\": 10000," +
                    "\"code\": \"PS\"," +
                    "\"number\": 38," +
                    "\"cluster\": \"Pskov\"," +
                    "\"address\": \"Pskovskaya obl., Porkhovskiy r-n, d. Polonoe\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
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
                    "\"address\": \"Pskovskaya obl., Porkhovskiy r-n, d. Polonoe\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": -90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
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
                    "\"address\": \"Pskovskaya obl., Porkhovskiy r-n, d. Polonoe\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
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
                    "\"address\": \"Pskovskaya obl., Porkhovskiy r-n, d. Polonoe\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
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
                        "Pskovskaya obl., Porkhovskiy r-n, d. Polonoe\"," +
                    "\"type\": \"MAST\"," +
                    "\"height\": 90," +
                    "\"serviceContractor\": \"Ivanov\"," +
                    "\"serviceDate\": \"2020-05-16\"," +
                    "\"reportContractor\": \"Petrov\"," +
                    "\"reportDate\": \"2020-05-20\"," +
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
}
