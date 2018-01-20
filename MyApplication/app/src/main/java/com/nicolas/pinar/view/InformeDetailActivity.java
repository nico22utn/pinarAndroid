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
    public byte[] foto;
    public String informe;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe_detail);
        text=(TextView)findViewById(R.id.informe_detail_text);
        imageView=(ImageView)findViewById(R.id.foto_image);
        Intent intent=getIntent();
        informe=intent.getStringExtra("informe");
        foto=intent.getByteArrayExtra("foto");
        Bitmap bmp= BitmapFactory.decodeByteArray(foto,0, foto.length);
        imageView.setImageBitmap(bmp);
        text.setText(informe);
    }
}
