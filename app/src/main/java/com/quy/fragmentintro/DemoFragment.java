package com.quy.fragmentintro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DemoFragment extends Fragment {
    private ArrayList<String> arr;
    private VersionAndroidFragmentListener verionAndroid;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof VersionAndroidFragmentListener){
            verionAndroid = (VersionAndroidFragmentListener) context;
            System.out.println("Thong tin context: " + context.getClass().toString());
        }else{
            throw new ClassCastException("Can't cast");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.fragment_layout,container,false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,getVersionAndroid());
        ListView listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                verionAndroid.onVersion(arr.get(i).toString());
                // Cach 2
                //String version = ((TextView) view).getText().toString();
            }
        });
        return view;
    }

    public ArrayList<String> getVersionAndroid(){
        arr = new ArrayList<>();
        arr.add("Verson_1");
        arr.add("Verson_2");
        arr.add("Verson_3");
        arr.add("Verson_4");
        arr.add("Verson_5");
        arr.add("Verson_6");
        arr.add("Verson_7");
        arr.add("Verson_8");
        arr.add("Verson_9");
        arr.add("Verson_10");
        return arr;
    }
}
