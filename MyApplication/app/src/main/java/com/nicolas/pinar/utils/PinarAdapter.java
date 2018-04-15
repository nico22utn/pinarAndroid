package com.nicolas.pinar.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nicolas.pinar.R;
import com.nicolas.pinar.model.DTOPantalla;
import com.nicolas.pinar.view.InformeDetailActivity;
import com.nicolas.pinar.view.ListInformesActivity;

/**
 * Created by User on 15/01/2018.
 */

public class PinarAdapter extends RecyclerView.Adapter {

    DTOPantalla dtoPantalla;
    Context context;

    public PinarAdapter(DTOPantalla dto,Context context){
        dtoPantalla=dto;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PinarViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_list_informes, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final String informe=dtoPantalla.getListInformes().get(position).getInforme();
        final PinarViewHolder viewHolder=(PinarViewHolder) holder;

        viewHolder.informeTextView.setText(informe);
        Bitmap bmp= BitmapFactory.decodeByteArray(dtoPantalla.getFotoPaciente().getBytes(),0,dtoPantalla.getFotoPaciente().getBytes().length);
        viewHolder.informeImageView.setImageBitmap(bmp);
        viewHolder.container.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Creamos el intent
                Intent intent = new Intent(context, InformeDetailActivity.class);
                intent.putExtra("paciente", dtoPantalla.getNombrePaciente());
                intent.putExtra("foto", dtoPantalla.getFotoPaciente());
                intent.putExtra("informe", informe);
                intent.putExtra("medico",dtoPantalla.getListInformes().get(position).getMedico().getNombreMedico());
                intent.putExtra("area",dtoPantalla.getListInformes().get(position).getMedico().getAreaMedico());
                ActivityCompat.startActivity((ListInformesActivity) context,intent,null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dtoPantalla.getListInformes().size();
    }
    static class PinarViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout container;
        ImageView informeImageView;
        TextView informeTextView;

        public PinarViewHolder(View itemView) {
            super(itemView);

            container = (RelativeLayout) itemView.findViewById(R.id.container);
            informeTextView = (TextView) itemView.findViewById(R.id.informe_text);
            informeImageView= (ImageView) itemView.findViewById(R.id.foto_paciente);
        }
    }
}
