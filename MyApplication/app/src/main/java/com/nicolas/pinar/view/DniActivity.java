package com.nicolas.pinar.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nicolas.pinar.R;

public class DniActivity extends AppCompatActivity {

    private String dni;
    private EditText dniEditText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dni);
    }

    public void consultarConDni(View view) {
        dniEditText=(EditText)findViewById(R.id.dni);
        dni=dniEditText.getText().toString();
    }
}
