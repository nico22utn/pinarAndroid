package com.nicolas.pinar.rest;

import com.nicolas.pinar.model.DTOPantalla;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 14/01/2018.
 */

public class PinarUtils {
    static RetrofitCallUtil retrofitCallUtil = new RetrofitCallUtil();

    public static void getPaymentMethods(final RetrofitCallUtil.ApiCallbacksListener<DTOPantalla> apiCallbacksListener,String dni) {
        RetrofitAPI apiService = getPinarApiRetrofitInterface();
        Call<DTOPantalla> call = apiService.getHistorial(dni);
        retrofitCallUtil.GET(call,apiCallbacksListener);
    }

    private static RetrofitAPI getPinarApiRetrofitInterface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkUtils.baseUri.toString() + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitAPI.class);
    }

}

