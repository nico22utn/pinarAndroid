package com.nicolas.pinar.rest;

import com.nicolas.pinar.model.DTOPantalla;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by User on 10/01/2018.
 */

public interface RetrofitAPI {
    String ENDPOINT="http://localhost:8080/historialClinioo/";

    @GET(NetworkUtils.API_INFORMES_METHODS_PATH)
    Call<DTOPantalla> getHistorial(@Query(NetworkUtils.API_PAYMENT_METHOD_DNI_QUERY) String dni);
}
