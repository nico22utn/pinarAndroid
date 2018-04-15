package com.nicolas.pinar.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicolas.pinar.R;

import static com.nicolas.pinar.R.id.imageView;

public class InformeDetailActivity extends AppCompatActivity {

    TextView text;
    TextView textMedico;
    TextView textArea;
    TextView textPaciente;
    public String foto;
    public String informe;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_detail);
        text=(TextView)findViewById(R.id.informe_detail_text);
        textMedico=(TextView)findViewById(R.id.medico);
        textArea=(TextView)findViewById(R.id.area);
        textPaciente=(TextView)findViewById(R.id.paciente);
        imageView=(ImageView)findViewById(R.id.foto_paciente);
        Intent intent=getIntent();
        foto=intent.getStringExtra("foto");
        Bitmap bmp= BitmapFactory.decodeByteArray(foto.getBytes(),0, foto.getBytes().length);
        imageView.setImageBitmap(bmp);
        text.setText(informe);
        textArea.setText(intent.getStringExtra("area"));
        textMedico.setText(intent.getStringExtra("medico"));
        textPaciente.setText(intent.getStringExtra("paciente"));
    }
}
