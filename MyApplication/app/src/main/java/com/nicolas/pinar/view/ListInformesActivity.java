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
import com.nicolas.pinar.rest.PinarUtils;
import com.nicolas.pinar.rest.RetrofitAPI;
import com.nicolas.pinar.rest.RetrofitCallUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListInformesActivity extends AppCompatActivity implements RetrofitCallUtil.ApiCallbacksListener<DTOPantalla>{

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
        PinarUtils.getPaymentMethods(this,dni);
    }

    @Override
    public void onWillStartLoading() {
        Toast.makeText(ListInformesActivity.this, "La llamada en espera", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccess(DTOPantalla responseBody) {
        Toast.makeText(ListInformesActivity.this, "La llamada a la api anduvo correctamente", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure() {
        Toast.makeText(ListInformesActivity.this, "Ups! Problemas en la llamada", Toast.LENGTH_LONG).show();
    }
}
