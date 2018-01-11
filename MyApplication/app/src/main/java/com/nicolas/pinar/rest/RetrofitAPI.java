package com.nicolas.pinar.rest;

import com.nicolas.pinar.model.DTOPantalla;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by User on 10/01/2018.
 */

public interface RetrofitAPI {
    String ENDPOINT="http://localhost:8080/historialclinioo/find?dni=";

    @GET("find")
    Call<DTOPantalla> getHistorial(@Query("dni")int dni);
}
