package com.nicolas.pinar.rest;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 14/01/2018.
 */

public class RetrofitCallUtil<T> {
        private static final String TAG = "RetrofitCallUtil";


        public interface ApiCallbacksListener<T> {
            void onWillStartLoading();

            void onSuccess(T responseBody);

            void onFailure();
        }

        public void GET(Call call, final ApiCallbacksListener<T> listener) {

            Log.d(TAG, "GET url: " + call.request().url().toString());
            listener.onWillStartLoading();
            call.enqueue(new Callback<T>() {
                             @Override
                             public void onResponse(Call<T> call, Response<T> response) {
                                 switch (response.code()) {
                                     case 200:
                                         listener.onSuccess(response.body());
                                         break;
                                     default:
                                         Log.d(TAG, "onFailure: " + response.toString());
                                         listener.onFailure();
                                         break;
                                 }
                             }

                             @Override
                             public void onFailure(Call<T> call, Throwable t) {
                                 Log.d(TAG, "onFailure: " + t.getMessage());
                                 listener.onFailure();
                             }
                         }
            );

        }
    }

