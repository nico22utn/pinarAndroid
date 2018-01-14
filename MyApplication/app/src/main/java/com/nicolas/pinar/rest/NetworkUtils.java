package com.nicolas.pinar.rest;

import android.net.Uri;

/**
 * Created by User on 14/01/2018.
 */

public class NetworkUtils {

    public static final String API_SCHEME = "http";
    public static final String API_BASE_URL = "localhost:8080/historialClinico";
    public static final String API_INFORMES_METHODS_PATH = "find";

    public static final Uri baseUri = buildBaseUri();
    public static final String API_PAYMENT_METHOD_DNI_QUERY = "dni";


    private static Uri buildBaseUri() {
        return new Uri.Builder()
                .scheme(API_SCHEME)
                .authority(API_BASE_URL)
                .build();
    }
}
