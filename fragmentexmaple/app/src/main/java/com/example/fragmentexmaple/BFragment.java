package com.example.fragmentexmaple;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BFragment extends Fragment {
    public TextView textFrag2;

    public BFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_b, container, false);
        textFrag2 = view.findViewById(R.id.textFrag2);
        textFrag2.setText("Fragment B");
        return  view;
    }
}