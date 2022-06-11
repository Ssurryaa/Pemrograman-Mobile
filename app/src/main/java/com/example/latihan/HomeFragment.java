package com.example.latihan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView img_produk1, kategori;
    private Context context;

    private TextView text_paper, text_Leather, text_Fabric, text_Embroidery, text_Ceramic;

    private TextView tv_nama1, tv_harga1;
    private TextView tv_nama2, tv_harga2;
    private TextView tv_nama3, tv_harga3;

    ImageView produk1, produk2, produk3;
    ImageView notif;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView tvData1 = (TextView) view.findViewById(R.id.name);
        tvData1.setText(getActivity().getIntent().getStringExtra("dataUsername"));

        img_produk1 = view.findViewById(R.id.img_produk1);

        text_paper = view.findViewById(R.id.text_paper);
        text_Leather = view.findViewById(R.id.text_Leather);
        text_Fabric = view.findViewById(R.id.text_Fabric);
        text_Embroidery = view.findViewById(R.id.text_Embroidery);
        text_Ceramic = view.findViewById(R.id.text_Ceramic);

        tv_nama1 = view.findViewById(R.id.tv_nama1);
        tv_harga1 = view.findViewById(R.id.tv_harga1);
        tv_nama2 = view.findViewById(R.id.tv_nama2);
        tv_harga2 = view.findViewById(R.id.tv_harga2);
        tv_nama3 = view.findViewById(R.id.tv_nama3);
        tv_harga3 = view.findViewById(R.id.tv_harga3);

        kategori = (ImageView) view.findViewById(R.id.paper);
        kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = text_paper.getText().toString();

                Intent intent = new Intent(getActivity(), Product.class);
                intent.putExtra("dataKategori", kategori);
                startActivity(intent);
            }
        });

        kategori = (ImageView) view.findViewById(R.id.Leather);
        kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = text_Leather.getText().toString();

                Intent intent = new Intent(getActivity(), Product.class);
                intent.putExtra("dataKategori", kategori);
                startActivity(intent);
            }
        });

        kategori = (ImageView) view.findViewById(R.id.Fabric);
        kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = text_Fabric.getText().toString();

                Intent intent = new Intent(getActivity(), Product.class);
                intent.putExtra("dataKategori", kategori);
                startActivity(intent);
            }
        });

        kategori = (ImageView) view.findViewById(R.id.Embroidery);
        kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = text_Embroidery.getText().toString();

                Intent intent = new Intent(getActivity(), Product.class);
                intent.putExtra("dataKategori", kategori);
                startActivity(intent);
            }
        });

        kategori = (ImageView) view.findViewById(R.id.Ceramic);
        kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kategori = text_Ceramic.getText().toString();

                Intent intent = new Intent(getActivity(), Product.class);
                intent.putExtra("dataKategori", kategori);
                startActivity(intent);
            }
        });

        produk1 = (ImageView) view.findViewById(R.id.img_produk1);
        produk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String image = img_produk1.getImageAlpha().;
                String nama = tv_nama1.getText().toString();
                String harga = tv_harga1.getText().toString();
                String sku = getString(R.string.sku1);
                String berat = getString(R.string.berat1);
                String stok = getString(R.string.stok1);
                String deskripsi = getString(R.string.lorem_ipsum);

                Intent intent = new Intent(getActivity(), DetailProduk.class);
                intent.putExtra("dataNama", nama);
                intent.putExtra("dataHarga", harga);
                intent.putExtra("dataSku", sku);
                intent.putExtra("dataBerat", berat);
                intent.putExtra("dataStok", stok);
                intent.putExtra("dataDeskripsi", deskripsi);
                startActivity(intent);
            }
        });

        produk2 = (ImageView) view.findViewById(R.id.img_produk2);
        produk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tv_nama2.getText().toString();
                String harga = tv_harga2.getText().toString();
                String sku = getString(R.string.sku2);
                String berat = getString(R.string.berat2);
                String stok = getString(R.string.stok2);
                String deskripsi = getString(R.string.lorem_ipsum);

                Intent intent = new Intent(getActivity(), DetailProduk.class);
                intent.putExtra("dataImage", R.drawable.fabric);
                intent.putExtra("dataNama", nama);
                intent.putExtra("dataHarga", harga);
                intent.putExtra("dataSku", sku);
                intent.putExtra("dataBerat", berat);
                intent.putExtra("dataStok", stok);
                intent.putExtra("dataDeskripsi", deskripsi);
                startActivity(intent);
            }
        });

        produk3 = (ImageView) view.findViewById(R.id.img_produk3);
        produk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tv_nama3.getText().toString();
                String harga = tv_harga3.getText().toString();
                String sku = getString(R.string.sku3);
                String berat = getString(R.string.berat3);
                String stok = getString(R.string.stok3);
                String deskripsi = getString(R.string.lorem_ipsum);

                Intent intent = new Intent(getActivity(), DetailProduk.class);
                intent.putExtra("dataNama", nama);
                intent.putExtra("dataHarga", harga);
                intent.putExtra("dataSku", sku);
                intent.putExtra("dataBerat", berat);
                intent.putExtra("dataStok", stok);
                intent.putExtra("dataDeskripsi", deskripsi);
                startActivity(intent);
            }
        });
        notif = (ImageView) view.findViewById(R.id.notifikasi);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Notifikasi.class);
                startActivity(intent);
            }
        });
        return view;
    }
}