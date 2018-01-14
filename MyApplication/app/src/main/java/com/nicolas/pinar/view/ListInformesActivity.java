package com.nicolas.pinar.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.nicolas.pinar.R;
import com.nicolas.pinar.model.DTOPantalla;
import com.nicolas.pinar.rest.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListInformesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_informes);
        Intent i = getIntent();
        String dni = i.getStringExtra("dni");
        getHistoriales(dni);
    }

    public void getHistoriales(String dni){
        //Inicio Llamada API Pinar Plaza
        final String url="http://192.168.1.36:8080/historialClinico/";
        Retrofit retrofit= new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        //Instanciar Interface
        ApiService api=retrofit.create(ApiService.class);
        //Llamada Asincrona
        Call<DTOPantalla> call= api.getHistorial(dni);
        call.enqueue(new Callback<DTOPantalla>() {
            @Override
            public void onResponse(Call<DTOPantalla> call, Response<DTOPantalla> response) {
                //Instanciar Recicler View
                Toast.makeText(ListInformesActivity.this, "Llamada exitosa.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DTOPantalla> call, Throwable t) {
                Toast.makeText(ListInformesActivity.this, "Error. Llamada a la APi sin exito.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}