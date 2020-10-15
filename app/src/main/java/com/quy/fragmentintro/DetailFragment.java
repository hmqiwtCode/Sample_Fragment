package com.quy.fragmentintro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_detail,container,false);
        TextView textView = view.findViewById(R.id.text_version);
        if(getArguments().containsKey("version")){
            textView.setText(getArguments().getString("version").toString());
        }
        return view;
    }
}
