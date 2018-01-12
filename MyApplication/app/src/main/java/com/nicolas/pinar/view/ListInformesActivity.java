package com.nicolas.pinar.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolas.pinar.R;
import com.nicolas.pinar.model.DTOPantalla;
import com.nicolas.pinar.rest.RetrofitAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListInformesActivity extends AppCompatActivity {

    public static String dni;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_informes);
        Intent i=getIntent();
        String dni = i.getStringExtra("dni");
        textView2=(TextView) findViewById(R.id.textView2);
        textView2.setText(dni);
        getHistorialesByDni(dni);
    }
    private void getHistorialesByDni(String dni){
        Gson gson = new GsonBuilder().create();
        //Creamos la instancia de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitAPI llamada = retrofit.create(RetrofitAPI.class);
        Call<DTOPantalla> call = llamada.getHistorial(dni);
        call.enqueue(new Callback<DTOPantalla>() {
            @Override
            public void onResponse(Call<DTOPantalla> call, Response<DTOPantalla> response) {
                Toast.makeText(ListInformesActivity.this, "La llamada a la api anduvo correctamente", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DTOPantalla> call, Throwable t) {
                Toast.makeText(ListInformesActivity.this, "Ups! Problemas en la llamada", Toast.LENGTH_LONG).show();
            }
        });
    }
}
