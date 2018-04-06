package com.nicolas.pinar.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nicolas.pinar.R;
import com.nicolas.pinar.model.DTOPantalla;
import com.nicolas.pinar.rest.ApiService;
import com.nicolas.pinar.utils.PinarAdapter;
import com.nicolas.pinar.utils.PinarUtis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListInformesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public String dni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        String dni = i.getStringExtra("dni");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListInformesActivity.this));
        this.dni=dni;
        getHistoriales(dni);
    }

    public void getHistoriales(String dni){
        //Inicio Llamada API Pinar Plaza
        Retrofit retrofit= new Retrofit.Builder().baseUrl(PinarUtis.URL_CONEXION).addConverterFactory(GsonConverterFactory.create()).build();
        //Instanciar Interface
        ApiService api=retrofit.create(ApiService.class);
        //Llamada Asincrona
        Call<DTOPantalla> call= api.getHistorial(dni);
        call.enqueue(new Callback<DTOPantalla>() {
            @Override
            public void onResponse(Call<DTOPantalla> call, Response<DTOPantalla> response) {
                //Instanciar Recicler View
                PinarAdapter adapter = new PinarAdapter( response.body(), ListInformesActivity.this);
                recyclerView.setAdapter(adapter);

                //Mostrar el recycler view, ocultar el loading
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<DTOPantalla> call, Throwable t) {
                Toast.makeText(ListInformesActivity.this, "Error. Llamada a la APi sin exito.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}