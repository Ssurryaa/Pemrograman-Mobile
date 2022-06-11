package com.example.latihan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ProductModel> dataProduct;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textPrice;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.product_name);
            textPrice = itemView.findViewById(R.id.product_price);
            img = itemView.findViewById(R.id.img_produk);
        }
    }

    AdapterRecyclerView(ArrayList<ProductModel> data){
        this.dataProduct = data;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {

        TextView product_name = holder.textName;
        TextView product_price = holder.textPrice;
        ImageView img_price = holder.img;

        product_name.setText(dataProduct.get(position).getName());
        product_price.setText(dataProduct.get(position).getPrice());
        img_price.setImageResource(dataProduct.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return dataProduct.size();
    }

}
