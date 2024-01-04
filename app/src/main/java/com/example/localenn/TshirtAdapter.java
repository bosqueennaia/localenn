package com.example.localenn;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TshirtAdapter extends RecyclerView.Adapter<TshirtAdapter.ViewHolder> {

    public TshirtAdapter(ArrayList<TshirtClass> listShirt) {this.listShirt = listShirt;}
    private ArrayList<TshirtClass> listShirt;
    //adapter untuk recyclerview
    @NonNull
    @Override
    public TshirtAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_tshirt, parent, false));
        return holder;
    }

    //implement method
    @Override
    public void onBindViewHolder(@NonNull TshirtAdapter.ViewHolder holder, int position) {

        TshirtClass shirtadapter = listShirt.get(position);
        holder.tv_merk.setText(shirtadapter.getMerk());
        holder.tv_jenis.setText(shirtadapter.getJenis());
        holder.tv_harga.setText(shirtadapter.getHarga());
        holder.img.setImageResource(shirtadapter.getGambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailShirt.class);
                intent.putExtra("nama_merk",shirtadapter.getMerk());
                intent.putExtra("nama_jenis",shirtadapter.getJenis());
                intent.putExtra("nama_price",shirtadapter.getHarga());
                intent.putExtra("nama_desc",shirtadapter.getDesc());
                intent.putExtra("foto_pakaian", shirtadapter.getGambar());

                v.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {return listShirt.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public   TextView tv_merk ;
        public  TextView tv_jenis;
        public  TextView tv_harga;
        public  TextView tv_desc;
        public  ImageView img;
        public  ConstraintLayout itemView;
        //public ConstraintLayout itemView;

        public ViewHolder( @NonNull View itemView) {
            super(itemView);
            tv_merk = (TextView) itemView.findViewById(R.id.merk_id);
            tv_jenis = (TextView) itemView.findViewById(R.id.jenis_id);
            tv_harga = (TextView) itemView.findViewById(R.id.price_id);
            tv_desc = (TextView) itemView.findViewById(R.id.desc);
            img = (ImageView)  itemView.findViewById(R.id.gambar_id);
            this.itemView = (ConstraintLayout) itemView.findViewById(R.id.mainLayout);
        }

    }
}

