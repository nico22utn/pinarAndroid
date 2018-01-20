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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nicolas.pinar.R;
import com.nicolas.pinar.model.DTOPantalla;
import com.nicolas.pinar.view.InformeDetailActivity;
import com.nicolas.pinar.view.ListInformesActivity;
import com.squareup.picasso.Picasso;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final String informe=dtoPantalla.getInformes().get(position);
        final PinarViewHolder viewHolder=(PinarViewHolder) holder;

        viewHolder.informeTextView.setText(informe);
        viewHolder.container.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Creamos el intent
                Intent intent = new Intent(context, InformeDetailActivity.class);
                intent.putExtra("foto", (byte [])dtoPantalla.getFoto());
                intent.putExtra("informe", informe);
                //Preparacion de la animacion
                // Obtenemos el nombre de la transicion
                String transitionName = context.getString(R.string.image_transition);

                //Creamos la animacion
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((ListInformesActivity) context, viewHolder.informeImageView, transitionName);

                //Realizamos la transicion
                ActivityCompat.startActivity((ListInformesActivity) context, intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dtoPantalla.getInformes().size();
    }
    static class PinarViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout container;
        CircleImageView informeImageView;
        TextView informeTextView;

        public PinarViewHolder(View itemView) {
            super(itemView);

            container = (RelativeLayout) itemView.findViewById(R.id.container);
            informeTextView = (TextView) itemView.findViewById(R.id.informe_text);
        }
    }
}
