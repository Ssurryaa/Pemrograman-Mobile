package com.example.latihan;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView profile;
    TextView notification;
    TextView location;
    TextView instagram;
    TextView transaction;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView tvData1 = (TextView) view.findViewById(R.id.tv_name);
        tvData1.setText(getActivity().getIntent().getStringExtra("dataUsername"));

        profile = (TextView) view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = getActivity().getIntent().getStringExtra("dataUsername");
                String email = getActivity().getIntent().getStringExtra("dataEmail");
                String phone = getActivity().getIntent().getStringExtra("dataPhone");
                String loc = getActivity().getIntent().getStringExtra("dataLocation");
                String ig = getActivity().getIntent().getStringExtra("dataInstagram");

                Intent intent = new Intent(getActivity(), Profile.class);
                intent.putExtra("dataUsername", username);
                intent.putExtra("dataEmail", email);
                intent.putExtra("dataPhone", phone);
                intent.putExtra("dataLocation", loc);
                intent.putExtra("dataInstagram", ig);
                startActivity(intent);
            }
        });

        notification = (TextView) view.findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Notifikasi.class);
                startActivity(intent);
            }
        });

        transaction = (TextView) view.findViewById(R.id.transaction);
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = getActivity().getIntent().getStringExtra("dataNama");
                String harga = getActivity().getIntent().getStringExtra("dataHarga");
                String pesanan = getActivity().getIntent().getStringExtra("dataPesanan");
                String loc = getActivity().getIntent().getStringExtra("dataLocation");

                Intent intent = new Intent(getActivity(), Transaksi.class);
                intent.putExtra("dataNama", nama);
                intent.putExtra("dataHarga", harga);
                intent.putExtra("dataPesanan", pesanan);
                intent.putExtra("dataLocation", loc);
                startActivity(intent);
            }
        });

        location = (TextView) view.findViewById(R.id.btn_location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc = getActivity().getIntent().getStringExtra("dataLocation");

                if (loc == null){
                    Toast.makeText(getActivity(), "Unknown Location", Toast.LENGTH_SHORT).show();
                }else {
                    // Parse the location and create the intent.
                    Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                    Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                    // Find an activity to handle the intent, and start that activity.
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                    }
                }
            }
        });

        instagram = (TextView) view.findViewById(R.id.btn_instagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ig = getActivity().getIntent().getStringExtra("dataInstagram");

                if (ig == null){
                    Toast.makeText(getActivity(), "Unknown Instagram", Toast.LENGTH_SHORT).show();
                }else{
                    Uri uri = Uri.parse("http://instagram.com/_u/" + ig);
                    Intent followme = new Intent(Intent.ACTION_VIEW, uri);

                    followme.setPackage("com.instagram.android");

                    try {
                        startActivity(followme);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://instagram.com"+ ig)));
                    }
                }
            }
        });

        return view;
    }


}