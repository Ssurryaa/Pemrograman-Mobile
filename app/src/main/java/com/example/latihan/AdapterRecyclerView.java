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

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(ProductModel productModel);
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textName, textPrice, textWeight, textStock;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.product_name);
            textPrice = itemView.findViewById(R.id.product_price);
//            textWeight = itemView.findViewById(R.id.tv_berat);
//            textStock = itemView.findViewById(R.id.tv_stok);
            img = itemView.findViewById(R.id.img_produk);
        }
    }

    AdapterRecyclerView(ArrayList<ProductModel> data){
        this.dataProduct = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView product_name = holder.textName;
        TextView product_price = holder.textPrice;
//        TextView product_weight = holder.textWeight;
//        TextView product_stock = holder.textStock;
        ImageView img_price = holder.img;

        product_name.setText(dataProduct.get(position).getName());
        product_price.setText(dataProduct.get(position).getPrice());
//        product_weight.setText(dataProduct.get(position).getWeight());
//        product_stock.setText(dataProduct.get(position).getStock());
        img_price.setImageResource(dataProduct.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(dataProduct.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {

        return dataProduct.size();
    }

}
